package com.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class AbstractFacade<T> {

    private Class<T> entity;
    AbstractFacade(Class<T> entity){
        this.entity = entity;
    }


    public EntityManager getEntityManager(){
        return Persistence.createEntityManagerFactory("lab").createEntityManager();
    }

    /*
    *   CRUD methods
    *   find - update - remove - create - findAll
    */

    public T find(Object key){
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        T myObject = em.find(entity, key);
        transaction.commit();
        em.close();
        return myObject;
    }

    public List<T> findAll(){
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        CriteriaQuery<T> c = em.getCriteriaBuilder().createQuery(entity);
        Root<T> from = c.from(entity);
        c.select(from);
        List<T> resultList = em.createQuery(c).getResultList();
        transaction.commit();
        em.close();
        return resultList;
    }

    public T create(T object){
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        object = entityManager.merge(object);
        transaction.commit();
        entityManager.close();
        return object;
    }

    public void remove(T object){
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        object = entityManager.merge(object);
        entityManager.remove(object);
        transaction.commit();
        entityManager.close();
    }

    public void update(T object){
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(object);
        transaction.commit();
        entityManager.close();
    }

    public void remove(Long id) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        T t = entityManager.find(entity, id);
        entityManager.remove(t);

        transaction.commit();
        entityManager.close();
        //todo
    }
}
