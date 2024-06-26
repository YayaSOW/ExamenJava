package core;

import java.util.List;

import entities.Loge;

public interface Service <T> {
    boolean add(T objet);
    List<T> show();
    T getBy(String critere);
    int count();
}
