package com.simploncloneweb.simplon_clone_web.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Config {
    private static EntityManager entityManager = null;
    static {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
         entityManager = entityManagerFactory.createEntityManager();
    }
    public static EntityManager getEntityManager(){
        return entityManager;
    }
}
