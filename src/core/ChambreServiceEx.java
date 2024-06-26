package core;

import java.util.List;

import entities.Chambre;
import entities.Loge;

public interface ChambreServiceEx extends Service<Chambre> {
    List<Loge> getEtudiantsParChambre(Chambre chambre);
}
