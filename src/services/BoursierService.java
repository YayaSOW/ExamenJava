package services;

import java.util.ArrayList;
import java.util.List;

import core.Service;
import entities.Boursier;

public class BoursierService implements Service<Boursier> {
    List<Boursier> boursiers = new ArrayList<>();

    @Override
    public boolean add(Boursier boursier) {
        return boursiers.add(boursier);
    }

    @Override
    public List<Boursier> show() {
        return boursiers;
    }

    @Override
    public Boursier getBy(String critere) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBy'");
    }

    @Override
    public int count() {
        int counter = 0;
        for (Boursier boursier : boursiers) {
            if (boursier != null) {
                counter++;
            }
        }
        return counter;
    }
}
