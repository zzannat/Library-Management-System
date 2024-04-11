package com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Book;
import com.service.BookServiceImpl;

import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/")
public class BookViewController {

	private final BookServiceImpl bookService;

    public BookViewController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    
    @GetMapping
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAll().collectList().block();
        model.addAttribute("books", books);
        return "booksList"; 
    }
    
    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book()); 
        return "addBook"; 
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.save(book).block(); // Save the new book
        return "redirect:/"; // Redirect to the main books list
    }

    
    
    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable String id, Model model) {
    	Mono<Book> bookMono = bookService.getById(id);
        Book book = bookMono.block(); 
        model.addAttribute("book", book);
        return "editBook"; 
    }
    
    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable String id, @ModelAttribute Book book) {
        bookService.update(id, book).block(); 
        return "redirect:/";
    }
    
    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable String id) {
        bookService.delete(id).block(); 
        return "redirect:/"; 
    }
    
}
