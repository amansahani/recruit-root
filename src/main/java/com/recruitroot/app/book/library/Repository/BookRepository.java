package com.recruitroot.app.book.library.Repository;

import org.springframework.stereotype.Repository;
import com.recruitroot.app.book.library.model.Book;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



@Repository()
public interface BookRepository extends JpaRepository<Book, String> {

    Optional<Book> findById(String id);
    Optional<Book> findByTitle(String title);
    Optional<Book> findByIsbn(String isbn);
    Optional<Book> findByAuthor(String author);
    
}
