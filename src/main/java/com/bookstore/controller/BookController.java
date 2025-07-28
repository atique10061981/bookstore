// BookController
package com.bookstore.controller;
import com.bookstore.entity.Book;
import com.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping("/search")
    public List<Book> search(@RequestParam String keyword) {
        return bookService.searchBooks(keyword);
    }
}
