package entity;


import org.hibernate.Session;

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

    }
}
