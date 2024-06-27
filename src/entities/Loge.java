package entities;

import java.time.LocalDate;

import enums.TypeBourse;

public class Loge extends Boursier {
    //Attribut navigable
    //ManyToOne (Loge => Chambre)
    private Chambre chambre;
    public Loge(String nom, String prenom, String email, String tel, LocalDate dateNaissance, TypeBourse typeBourse, Chambre chambre) {
        super(nom, prenom, email, tel, dateNaissance,typeBourse);
        this.chambre=chambre;
    }
    public Loge() {
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    @Override
    public String toString() {
        return "Loge [chambre=" + chambre + " " + super.toString() + "]";
    }
    
}
