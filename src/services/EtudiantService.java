package services;

import java.util.ArrayList;
import java.util.List;

import core.ServiceImpEtudiant;
import entities.Boursier;
import entities.Etudiant;
import entities.Loge;
import entities.NonBoursier;

public class EtudiantService implements ServiceImpEtudiant {
    List<Etudiant> etudiants = new ArrayList<>();

    @Override
    public boolean add(Etudiant etudiant) {
        if (etudiant != null) {
            return etudiants.add(etudiant);
        }
        return false;
    }

    @Override
    public List<Etudiant> show() {
        return etudiants;
    }

    @Override
    public Etudiant getBy(String critere) {
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getMatricule().compareToIgnoreCase(critere) == 0) {
                return etudiant;
            }
        }
        return null;
    }

    @Override
    public int count() {
        return etudiants.size();
    }

    @Override
       // Méthode pour récupérer tous les boursiers
    public List<Boursier> getBoursiers() {
        List<Boursier> boursiers = new ArrayList<>();
        for (Etudiant etudiant : etudiants) {
            if (etudiant instanceof Boursier) {
                boursiers.add((Boursier) etudiant);
            }
        }
        return boursiers;
    }

    @Override
    // Méthode pour récupérer tous les étudiants logés
    public List<Loge> getEtudiantsLoges() {
        List<Loge> loges = new ArrayList<>();
        for (Etudiant etudiant : etudiants) {
            if (etudiant instanceof Loge) {
                loges.add((Loge) etudiant);
            }
        }
        return loges;
    }

    @Override
    // Méthode pour récupérer tous les étudiants Non logés et qui doivent etre logé
    public List<Loge> getEtudiantsNonLoges() {
        List<Loge> loges = new ArrayList<>();
        for (Etudiant etudiant : etudiants) {
            if (etudiant instanceof Loge && ((Loge)etudiant).getChambre() == null) {
                loges.add((Loge) etudiant);
            }
        }
        return loges;
    }

    @Override
    // Méthode pour récupérer tous les étudiants non boursiers
    public List<NonBoursier> getNonBoursiers() {
        List<NonBoursier> nonBoursiers = new ArrayList<>();
        for (Etudiant etudiant : etudiants) {
            if (etudiant instanceof NonBoursier) {
                nonBoursiers.add((NonBoursier) etudiant);
            }
        }
        return nonBoursiers;
    }


}
