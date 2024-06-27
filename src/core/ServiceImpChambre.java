package core;

import java.util.List;

import entities.Chambre;
import entities.Loge;

public interface ServiceImpChambre extends Service<Chambre> {
    List<Loge> getEtudiantsParChambre(Chambre chambre);
}
