package com.softserve.edu.lv251.entity;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Shmidt on 11.07.2017.
 */
public class App {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("my-pu");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        entityManager.close();
        entityManagerFactory.close();
    }
}
