package com.recruitroot.app.book.library.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitroot.app.book.library.Repository.BookRepository;
import com.recruitroot.app.book.library.model.Book;

@Service()
public class BookService {
    

    @Autowired()
    private BookRepository bookRepository;

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public void removeBookByIsbn(String isbn){
        Optional<Book> book =  bookRepository.findByIsbn(isbn);
        book.ifPresent(bookRepository::delete);
    }

    public Optional<Book> searchByIsbn(String isbn){
        return bookRepository.findByIsbn(isbn);
    }

    public Optional<Book> searchByTitle(String title){
        return bookRepository.findByTitle(title);
    }

    public Optional<Book> searchByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }




}
