package core;

import java.util.List;

import entities.Etudiant;
import entities.Loge;

public interface ServiceImpEtudiant extends Service<Etudiant> {
    public List<Loge> getEtudiantsLoges();
}
