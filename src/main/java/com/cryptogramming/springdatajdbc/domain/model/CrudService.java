package com.cryptogramming.springdatajdbc.domain.model;

import java.util.Collection;
import java.util.List;

public interface CrudService<T> {
    public abstract void create(T t );
    public abstract void update(int id, T t);
    public abstract void delete(int id);
    public abstract Collection<T> getItem();
    public abstract List<T> getAllItems();
}
