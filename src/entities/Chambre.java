package entities;

import java.util.ArrayList;
import java.util.List;

import enums.TypeChambre;

public class Chambre {
    private int id;
    private String numeroChambre;
    private int numeroEtage;
    private static int nbreChambre;
    private boolean etat;
    private boolean occuper;

    // Attribut navigable
    // ManyToOne (Chambre => Pavillon)
    private Pavillon pavillon;
    // ManyToOne (Chambre => TypeChambre)
    private TypeChambre typeChambre;
    // OneToMany (Pavillon => Chambre)
    private List<Loge> loges = new ArrayList<>();

    public Chambre(int numeroEtage, Pavillon pavillon, TypeChambre typeChambre) {
        this.id = ++nbreChambre;
        this.numeroChambre = generateNumero(id, "CHA");
        this.numeroEtage = numeroEtage;
        this.pavillon = pavillon;
        this.typeChambre = typeChambre;
        this.etat = true;
        this.occuper = false;
    }

    public Chambre() {
        this.id = ++nbreChambre;
        this.numeroChambre = generateNumero(id, "CHA");
        this.etat = true;
        this.occuper = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroChambre() {
        return numeroChambre;
    }

    public void setNumeroChambre(String numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

    public int getNumeroEtage() {
        return numeroEtage;
    }

    public void setNumeroEtage(int numeroEtage) {
        this.numeroEtage = numeroEtage;
    }

    public Pavillon getPavillon() {
        return pavillon;
    }

    public void setPavillon(Pavillon pavillon) {
        this.pavillon = pavillon;
    }

    public TypeChambre getTypeChambre() {
        return typeChambre;
    }

    public void setTypeChambre(TypeChambre typeChambre) {
        this.typeChambre = typeChambre;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public boolean isOccuper() {
        return occuper;
    }

    public void setOccuper(boolean occuper) {
        this.occuper = occuper;
    }

    public List<Loge> getLoges() {
        return loges;
    }

    public void add(Loge loge) {
        this.loges.add(loge);
    }

    public String generateNumero(int nbre, String format) {
        int size = String.valueOf(nbre).length();
        return format + "0".repeat((4 - size) < 0 ? 0 : 4 - size) + nbre;
    }

    @Override
    public String toString() {
        return "Chambre [id=" + id + ", numeroChambre=" + numeroChambre + ", numeroEtage=" + numeroEtage
                + ", typeChambre=" + typeChambre + ", etat=" + etat + ", occuper=" + occuper + "]";
    }
}
