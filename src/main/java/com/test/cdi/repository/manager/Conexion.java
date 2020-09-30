package com.test.cdi.repository.manager;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author pedro
 */
@ApplicationScoped
public class Conexion {

    private static final String NAME_BD = "UsersDB";
    private final static EntityManagerFactory FACTORY_ENTITY_MANGER = Persistence.createEntityManagerFactory(NAME_BD);

    private EntityManager entityManager;


    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = FACTORY_ENTITY_MANGER.createEntityManager();
        }
        return entityManager;
    }

}
