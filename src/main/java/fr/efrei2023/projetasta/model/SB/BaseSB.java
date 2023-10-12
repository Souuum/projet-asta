package fr.efrei2023.projetasta.model.SB;

import java.util.List;

public abstract class BaseSB<T> {

    //Common methods for all SBs
    public abstract List<T> getAll();
    public abstract T getById(int id);
    public abstract void add(T t);
    public abstract void update(T t);
    public abstract void delete(T t);
}
