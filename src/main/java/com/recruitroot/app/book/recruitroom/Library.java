package com.recruitroot.app.book.recruitroom;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void removeBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                System.out.println("Book removed: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not found with ISBN: " + isbn);
    }

    public void searchBook(String search) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(search) || book.getIsbn().equals(search)) {
                System.out.println("Book found: " + book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void listAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}
