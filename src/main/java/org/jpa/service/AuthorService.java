package org.jpa.service;

import org.jpa.model.Author;

import javax.persistence.EntityManager;

public class AuthorService  {
    private EntityManager em;

    public AuthorService(EntityManager em) {
        this.em = em;
    }

    /**
     * @param author
     * Persists the book to the database
     */
    public Author persistAuthor(Author author) {
        System.out.println(em.getMetamodel().getEntities());
        em.persist(author);
        return author;
    }

    /**
     * @param id
     * @return
     * Finds the author from the database
     */
    public Author findAuthor(Long id) {
        return em.find(Author.class, id);
    }

    /**
     * @param author
     * Remove author from the database
     */
    public void removeAuthor(Author author) {
        em.remove(em.merge(author));
    }
}
