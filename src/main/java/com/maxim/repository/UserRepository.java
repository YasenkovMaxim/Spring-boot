package com.maxim.repository;

import com.maxim.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public UserRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    public User findUserById(int id){
        User user = null;
       try(EntityManager entityManager = entityManagerFactory.createEntityManager()){
           user = entityManager.find(User.class, id);
       } catch (Exception e){
       }
       return user;
    }
}
