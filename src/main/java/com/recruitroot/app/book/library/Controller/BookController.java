package com.recruitroot.app.book.library.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recruitroot.app.book.library.Service.BookService;
import com.recruitroot.app.book.library.model.Book;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController()
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Operation(summary = "Add a Book")
    @PostMapping("/")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book newBook = bookService.addBook(book);
        return ResponseEntity.ok(newBook);
    }

    @Operation(summary = "Search a Book")
    @GetMapping("/search")
    public ResponseEntity<Book> searchBook(
        @RequestParam(required = false) String title,
        @RequestParam(required = false) String isbn,
        @RequestParam(required = false) String author
    ) {

        Optional<Book> book = Optional.empty();
        if(isbn != null){
            book = bookService.searchByIsbn(isbn);
        }
       else if(title != null){
            book = bookService.searchByTitle(title);
        }
       else if(author != null){
            book = bookService.searchByAuthor(author);
        }

        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Get all Books")
    @GetMapping("/")
    public ResponseEntity<List<Book>> listAllBooks() {

        List<Book> books = bookService.findAll();
        return ResponseEntity.ok(books);
    }
    
    @Operation(summary = "Delete a Book")
    @DeleteMapping("/{isbn}")
    public ResponseEntity<String> removeBook(@PathVariable String isbn){
        bookService.removeBookByIsbn(isbn);
        return ResponseEntity.ok("Book has been Removed Successfully");
    } 
    


    
    
    
}