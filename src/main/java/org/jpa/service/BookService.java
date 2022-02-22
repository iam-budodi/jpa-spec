package org.jpa.service;

import org.jpa.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BookService {
    /**
     * @param em
     * Initializes Entity Manager
     */
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookPU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();

    /**
     * @param book
     * Persists the book to the database
     */
    public Book persistBook(Book book) {
        tx.begin();
        em.persist(book);
        tx.commit();
        return book;
    }

    /**
     * @param id
     * @return
     * Finds the book from the database
     */
    public Book findBook(Long id) {
        return em.find(Book.class, id);
    }

    public Book raiseUnitCost(Long id, Float raise) {
        Book book = em.find(Book.class, id);
        if (book != null) {
            tx.begin();
            book.setUnitCost(book.getUnitCost() + raise);
            tx.commit();
        }
        return book;
    }

    public void removeBook(Long id) {
        tx.begin();
        em.remove(em.getReference(Book.class, id));
        tx.commit();
//        Book book = em.find(Book.class, id);
//        if (book != null) em.remove(book);
    }
}
