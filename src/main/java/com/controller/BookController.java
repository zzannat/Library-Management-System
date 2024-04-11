package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.model.Book;
import com.service.BookServiceImpl;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/api/books")

//@AllArgsConstructor


public class BookController 
{
	@Autowired
	private BookServiceImpl bookService;
	
	// Get all Books
	@CrossOrigin
	@GetMapping("/")
    public Flux<Book> getAll() 
	{
          System.out.println("All the Books information");
          return bookService.getAll();
    }
	
	//Get by Id
	@CrossOrigin
	@GetMapping("{id}")
    public Mono<Book> getById(@PathVariable("id") final String id) 
	{

          System.out.println("One book information based for the given ID");

          return bookService.getById(id);

    }
	
	
	
	@PostMapping

    public Mono save(@RequestBody final Book book) {

          System.out.println("Added book Info "+ book.getAuthor() + " - " + book.getTitle()

          + " - " + book.getAuthor() + " - " + book.getPrice());

          return bookService.save(book);

    }
	
	@CrossOrigin
	@PutMapping("{id}")
    public Mono updateById(@PathVariable("id") final String id, @RequestBody final Book book) {

          System.out.println("Updating an employee Info");

          return bookService.update(id, book);
    }
	

    @DeleteMapping("{id}")

    public Mono delete(@PathVariable final String id) {

          System.out.println("An employee Info deleted");

          return bookService.delete(id);

    }
	
	
	
}
