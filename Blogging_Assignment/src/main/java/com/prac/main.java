package com.prac;

import javax.persistence.*;


public class main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-unit");
        EntityManager em = emf.createEntityManager();

        UserService us = new UserService(em);
        PostService ps = new PostService(em);
        CommentService cs = new CommentService(em);

        em.close();
        emf.close();
    }
}