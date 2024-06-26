package services;

import java.util.ArrayList;
import java.util.List;

import core.Service;
import entities.NonBoursier;

public class NonBoursierService implements Service<NonBoursier> {
    List<NonBoursier> nonBoursiers = new ArrayList<>();

    @Override
    public boolean add(NonBoursier nonBoursier) {
        return nonBoursiers.add(nonBoursier);
    }

    @Override
    public List<NonBoursier> show() {
        return nonBoursiers;
    }

    @Override
    public NonBoursier getBy(String critere) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBy'");
    }

    @Override
    public int count() {
        int counter = 0;
        for (NonBoursier nonBoursier : nonBoursiers) {
            if (nonBoursier != null) {
                counter++;
            }
        }
        return counter;
    }
}
