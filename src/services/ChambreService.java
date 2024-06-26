package services;

import java.util.ArrayList;
import java.util.List;

import core.Service;
import entities.Chambre;
import entities.Loge;

public class ChambreService implements Service<Chambre> {
    List<Chambre> chambres = new ArrayList<>();

    @Override
    public boolean add(Chambre chambre) {
        if (chambre!=null) {
            return chambres.add(chambre);
        }
        return false;
    }

    @Override
    public List<Chambre> show() {
        return chambres;
    }

    @Override
    public Chambre getBy(String critere) {
        for (Chambre chambre : chambres) {
            if (chambre.getNumeroChambre().compareToIgnoreCase(critere) == 0) {
                return chambre;
            }
        }
        return null;
    }

    @Override
    public int count() {
        return chambres.size();
    }

    // Méthode pour récupérer tous les étudiants logés dans une chambre spécifique
    public List<Loge> getEtudiantsParChambre(Chambre chambre) {
        if (chambre != null) {
            return chambre.getLoges();
        }
        return new ArrayList<>(); // Retourne une liste vide si la chambre n'existe pas ou n'a pas d'étudiants
    }

}
