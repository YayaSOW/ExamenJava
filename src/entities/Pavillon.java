package entities;

import java.util.ArrayList;
import java.util.List;

public class Pavillon {
    private int id;
    private String numeroPavillon;
    private int nbreEtage;
    private static int nbrePavillon;

    //Attribut navigable
    //OneToMany (Pavillon => Chambre)
    private List<Chambre> chambres = new ArrayList<>();

    public Pavillon(int nbreEtage) {
        this.id = ++nbrePavillon;
        this.nbreEtage = nbreEtage;
        numeroPavillon=generateNumero(id, "PAV");
    }

    public Pavillon() {
        this.id = ++nbrePavillon;
        numeroPavillon=generateNumero(id, "PAV");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroPavillon() {
        return numeroPavillon;
    }

    public void setNumeroPavillon(String numeroPavillon) {
        this.numeroPavillon = numeroPavillon;
    }

    public int getNbreEtage() {
        return nbreEtage;
    }

    public void setNbreEtage(int nbreEtage) {
        this.nbreEtage = nbreEtage;
    }

    public List<Chambre> getChambres() {
        return chambres;
    }

    public void add(Chambre chambre) {
        this.chambres.add(chambre);
    }

    public  String generateNumero(int nbre,String format){
        int size=String.valueOf(nbre).length();
        return format+"0".repeat((4-size)<0?0:4-size)+nbre;
    }
    @Override
    public String toString() {
        return "Pavillon [id=" + id + ", numeroPavillon=" + numeroPavillon + ", nbreEtage=" + nbreEtage + "]";
    }
    
}
