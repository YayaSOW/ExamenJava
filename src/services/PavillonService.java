package services;

import java.util.ArrayList;
import java.util.List;

import core.Service;
import entities.Pavillon;

public class PavillonService implements Service<Pavillon> {
    List<Pavillon> pavillons = new ArrayList<>();

    @Override
    public boolean add(Pavillon pavillon) {
        if (pavillon!=null) {
            return pavillons.add(pavillon);
        }
        return false;
    }

    @Override
    public List<Pavillon> show() {
        return pavillons;
    }

    @Override
    public Pavillon getBy(String critere) {
        for (Pavillon pavillon : pavillons) {
            if (pavillon.getNumeroPavillon().compareToIgnoreCase(critere) == 0) {
                return pavillon;
            }
        }
        return null;
    }

    @Override
    public int count() {
        return pavillons.size();
    }

}
