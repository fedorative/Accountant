package com.me.accountant.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Seed {
    private static EntityManager em;

    public static void fillout(String[] args) {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("EmployeePU");
        em = emf.createEntityManager();

        createAccount("1001", "Koorosh", 1000d);
        createAccount("1002", "Zhinoos", 1200d);
        createAccount("1003", "Peyman", 1500d);

    }

    private static void createAccount(String number, String owner, Double balance) {
        em.getTransaction().begin();
        Account acc = new Account(number,owner,balance);
        em.persist(acc);
        em.getTransaction().commit();
    }
}
