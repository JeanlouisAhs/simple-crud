package com.example.simplecrud.services;

import com.example.simplecrud.entities.Book;
import com.example.simplecrud.repositories.BookRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Optional<Book> getBook(final Long id){
        return bookRepository.findById(id);
    }

    public Iterable<Book> getBooks(){
        return bookRepository.findAll();
    }

    public void deleteBook(final Long id){
        bookRepository.deleteById(id);
    }
    public Book saveBook(Book book){
        Book saveBook =  bookRepository.save(book);
        return saveBook;
    }
}
