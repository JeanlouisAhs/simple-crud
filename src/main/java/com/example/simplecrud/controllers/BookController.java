package com.example.simplecrud.controllers;

import com.example.simplecrud.entities.Book;
import com.example.simplecrud.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;


    /**
     * Create - Add new Book
     * @param book
     * @return
     */
    @PostMapping("/book")
    public Book createBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    /**
     *Read - Get one Book
     * @param id
     * @return Book
     */
    @GetMapping("/book/{id}")
    public Optional<Book> saveBook(@PathVariable("id") final Long id){
        Optional<Book> book = bookService.getBook(id);
        if (book.isPresent()) {
            return bookService.getBook(id);
        }else {
            return null;
        }
    }

    /**
     *Read - Get All Books
     * @return Books List
     */
    @GetMapping("/books")
    public Iterable<Book> getBooks(){
        return bookService.getBooks();
    }

    /**
     * Update an existing Book
     * @param id
     * @param book
     * @return
     */
    @PutMapping("/book/{id}")
    public Book updateBook(@PathVariable("id") final Long id, @RequestBody Book book){
        Optional<Book> e = bookService.getBook(id);
        if (e.isPresent()) {
            Book currentBook = e.get();

            String author =  book.getAuthor() ;
            if (author != null) {
                currentBook.setAuthor(author);
            }

            String description = book.getDescription();
            if (description != null) {
                currentBook.setDescription(description);
            }

            String yearOfPublication = book.getYearOfPublication();
            if (yearOfPublication != null) {
                currentBook.setYearOfPublication(yearOfPublication);
            }

            bookService.saveBook(currentBook);
            return currentBook;

        }else {
            return null;
        }
    }

    @DeleteMapping("book/{id}")
    public void deleteBook(@PathVariable("id") final Long id){
        bookService.deleteBook(id);
    }

}
