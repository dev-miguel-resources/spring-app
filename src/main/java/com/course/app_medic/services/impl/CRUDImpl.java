package com.course.app_medic.services.impl;

import java.util.List;

import com.course.app_medic.repositories.IGenericRepo;
import com.course.app_medic.services.ICRUD;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public T save(T t) {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) {
        // modificarla para más adelante
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) {
        // Supplier: falta código
        return getRepo().findById(id).orElseThrow(null);
    }

    @Override
    public void delete(ID id) {
        getRepo().findById(id).orElseThrow(null);
        getRepo().deleteById(id);
    }

}
