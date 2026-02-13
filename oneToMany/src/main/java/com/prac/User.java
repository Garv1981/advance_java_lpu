package com.prac;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class User {

    // Create EMF once (Important)
    static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public static void main(String[] args) {

        insertCarAndEngine();
        findByCarId(1);
        deleteEngine(1);

        emf.close();
    }

    public static void insertCarAndEngine() {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Engine e = new Engine();
        e.setType("V8");
        e.setFuelType("Petrol");
        e.setMileage(12);
        e.setCc(3000);

        Car c = new Car();
        c.setBrand("BMW");
        c.setModel("M5");
        c.setModelYear("2022");
        c.setPrice(20000000);

        c.setEngine(e);

        et.begin();
        em.persist(c);   // Cascade saves engine automatically
        et.commit();

        System.out.println("Car and Engine inserted successfully!");

        em.close();
    }

    public static void findByCarId(int id) {

        EntityManager em = emf.createEntityManager();

        Car c = em.find(Car.class, id);
        System.out.println("Fetched Car:");
        System.out.println(c);

        em.close();
    }

    public static void deleteEngine(int engineId) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        // Break relationship first
        String jpql =
                "update Car c set c.engine = null where c.engine.id = :eid";

        Query query = em.createQuery(jpql);
        query.setParameter("eid", engineId);
        query.executeUpdate();

        Engine e = em.find(Engine.class, engineId);

        if (e != null) {
            em.remove(e);
            System.out.println("Engine deleted successfully!");
        }

        et.commit();
        em.close();
    }
}
