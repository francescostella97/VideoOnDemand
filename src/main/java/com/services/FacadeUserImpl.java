package com.services;

import com.model.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.SQLException;

public class FacadeUserImpl extends AbstractFacade<UserEntity> {

    public FacadeUserImpl(Class<UserEntity> entity) {
        super(entity);
    }

    public UserEntity findUser(String username, String password) throws SQLException {

        EntityManager entityManager = getEntityManager();
        TypedQuery<UserEntity> query = entityManager.createQuery("select u from UserEntity u where u.username = :usr and u.password = :pwd", UserEntity.class);
        UserEntity user = query.setParameter("usr", username).setParameter("pwd", password).getSingleResult();
        return user;
    }

}
