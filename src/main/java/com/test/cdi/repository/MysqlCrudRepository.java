package com.test.cdi.repository;

import com.test.cdi.entity.PersonaEntity;
import com.test.cdi.repository.manager.Conexion;

import javax.inject.Inject;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;

/**
 * @author pedro
 */

public class MysqlCrudRepository<T, L> implements CrudRepository<T, L> {

    private Class<T> entityClass = (Class) PersonaEntity.class;

    @Inject
    private Conexion conexion;

    @Override
    public T save(T t) {
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = conexion.getEntityManager().getTransaction();
            conexion.getEntityManager().persist(t);
            entityTransaction.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally {
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
                conexion.getEntityManager().close();
            }
        }
        return t;
    }

    @Override
    public void delete(L l) {
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = conexion.getEntityManager().getTransaction();
            conexion.getEntityManager().remove(l);
            entityTransaction.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
                conexion.getEntityManager().close();
            }
        }
    }

    @Override
    public T findById(L l) {
        return conexion.getEntityManager().find(entityClass, l);
    }

    @Override
    public Collection<T> findAll() {
        CriteriaBuilder criteriaBuilder = conexion.getEntityManager().getCriteriaBuilder();

        CriteriaQuery<T> consulta = criteriaBuilder.createQuery(entityClass);
        Root<T> tabla = consulta.from(entityClass);
        consulta.select(tabla);
        TypedQuery query = conexion.getEntityManager().createQuery(consulta);
        return query.getResultList();
    }
}
