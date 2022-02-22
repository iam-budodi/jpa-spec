package org.jpa.service;

import org.jpa.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.jpa.model.Language.ENGLISH;
import static org.jpa.model.Util.date;

public class AuthorMain {
    public static void main(String[] args) {

        System.out.println("\n\n>>> Executing : " + Main.class.toString() + " <<<\n");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        AuthorService service = new AuthorService(em);
        Author author = new Author("Douglas", "Adams", "Adams is best known as the author of H2G2", date("11/03/1952"), 49, ENGLISH);

        // Creates and persists an author
        tx.begin();
        author = service.persistAuthor(author);
        tx.commit();
        Long id = author.getId();

        System.out.println("Author Persisted : " + author);

        // Finds the author
        author = service.findAuthor(id);

        System.out.println("Author Found     : " + author);

        // Removes the author
        tx.begin();
        service.removeAuthor(author);
        tx.commit();

        System.out.println("Author Removed");

        // Finds the author
        author = service.findAuthor(id);

        System.out.println("Author Not Found : " + author);

        em.close();
        emf.close();
    }
}
