package entities;

import java.time.LocalDate;

import enums.TypeBourse;

public class Boursier extends Etudiant {
    //Attribut navigable
    //ManyToOne (Boursier => TypeBourse)
    private TypeBourse typeBourse;  
    
    public Boursier(String nom, String prenom, String email, String tel, LocalDate dateNaissance, TypeBourse typeBourse) {
        super(nom, prenom, email, tel, dateNaissance);
        this.typeBourse = typeBourse;
    }
    public Boursier() {
    }

    public TypeBourse getTypeBourse() {
        return typeBourse;
    }

    public void setTypeBourse(TypeBourse typeBourse) {
        this.typeBourse = typeBourse;
    }
    @Override
    public String toString() {
        return "Boursier [typeBourse=" + typeBourse + ", l'etudiant=" + super.toString() +"]";
    }
}
