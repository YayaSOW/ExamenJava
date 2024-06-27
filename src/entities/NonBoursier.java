package entities;

import java.time.LocalDate;

public class NonBoursier extends Etudiant {
    private String adresse;

    public NonBoursier(String nom, String prenom, String email, String tel, LocalDate dateNaissance, String adresse) {
        super(nom, prenom, email, tel, dateNaissance);
        this.adresse = adresse;
    }

    public NonBoursier() {
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "NonBoursier [adresse=" + adresse + ", l'etudiant=" + super.toString() + "]";
    }
}
