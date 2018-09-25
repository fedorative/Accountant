package com.me.accountant.controllers;

import com.me.accountant.entities.Account;
import com.me.accountant.helpers.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/test")
public class MainController extends HttpServlet {
    private static final String PERSISTENCE_UNIT_NAME = "accounts";
    private static EntityManagerFactory factory;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter printWriter = res.getWriter();
        printWriter.print("This is me, I'm OK!");

        Account account01 = new Account("010001", "Ahmad Ali", 120.00);


        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        em.persist(account01);
        em.getTransaction().commit();

        em.close();
    }
}
