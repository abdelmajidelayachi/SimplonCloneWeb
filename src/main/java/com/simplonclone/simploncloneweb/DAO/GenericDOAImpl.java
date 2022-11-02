package com.simplonclone.simploncloneweb.DAO;

import com.simplonclone.simploncloneweb.config.Config;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Map;

public class  GenericDOAImpl<T> implements IGenericDOA<T> {

    @Override
    public T get(Class<T> tClass, Integer id) {
        EntityManager entityManager = Config.getEntityManager();
        try{
           return entityManager.find(tClass,id);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean save(T object) {
        EntityManager entityManager = Config.getEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(object);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(T object) {
        EntityManager entityManager = Config.getEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(object);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteId(Class<T> tClass,int id) {
        EntityManager entityManager = Config.getEntityManager();
        try{
            entityManager.getTransaction().begin();
            T object = entityManager.find(tClass,id);
            entityManager.remove(object);
            entityManager.getTransaction().commit();
            return true;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<T> getAll(Class<T> tClass,T object) {
        EntityManager entityManager = Config.getEntityManager();
        try{

            entityManager.getTransaction().begin();
            TypedQuery<T> query = entityManager.createQuery("SELECT a FROM "+tClass.getSimpleName()+" a",tClass);
            List<T> list = query.getResultList();
            entityManager.getTransaction().commit();
            return list;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<T> query(String hsql, Map<String, Object> params) {
        return null;
    }
}
