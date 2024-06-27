package core;

import java.util.List;

import entities.Boursier;
import entities.Etudiant;
import entities.Loge;
import entities.NonBoursier;

public interface ServiceImpEtudiant extends Service<Etudiant> {
    List<Boursier> getBoursiers();
    List<Loge> getEtudiantsLoges();
    List<Loge> getEtudiantsNonLoges();
    List<NonBoursier> getNonBoursiers();
}
