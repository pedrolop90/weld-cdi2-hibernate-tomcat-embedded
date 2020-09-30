package com.test.cdi.repository;

import java.util.Collection;

/**
 * @author pedro
 */
public interface CrudRepository<T, L> {

    T save(T t);

    void delete(L l);

    T findById(L l);

    Collection<T> findAll();

}
