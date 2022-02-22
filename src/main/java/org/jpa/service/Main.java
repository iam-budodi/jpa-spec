package org.jpa.service;

import org.jpa.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n\n>>> Executing : " + Main.class + " <<<\n");

        BookService bookService = new BookService();
        Book newBook = new Book(5000L, "H2G2", "Best IT Scifi Book", 12.5f, "1234-5678-5678", 247);

        // persist book
        Book book = bookService.persistBook(newBook);

        System.out.println("\n\n#### Book persisted: " + book);

        // find book
        book = bookService.findBook(book.getId());
        System.out.println("#### Book found: " + book);

        // raise book price
        book = bookService.raiseUnitCost(book.getId(), 12.5F);
        System.out.println("#### Book updated: " + book);

        // delete book
        bookService.removeBook(book.getId());

        // find book
        book = bookService.findBook(book.getId());
        System.out.println("#### Book not found: " + book);

        System.out.println("");
    }
}


