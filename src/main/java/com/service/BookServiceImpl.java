package com.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Book;
import com.repository.BookRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service

@Transactional

@AllArgsConstructor
public class BookServiceImpl implements IBookService 
{
	@Autowired
	private BookRepository bookRepository;

	public Flux<Book> getAll() 
	{

        return bookRepository.findAll().switchIfEmpty(Flux.empty());

	}
	
	public Mono<Book> getById(final String id) 
	{

        return bookRepository.findById(id);
	}
	
	 public Mono update(final String id, final Book book) 
	 {

         return bookRepository.save(book);

	 }
	
	 public Mono save(final Book book) 
	 {

         return bookRepository.save(book);

	 }
	 
	 public Mono delete(final String id) 
	 {

         final Mono<Book> dbBook = getById(id);

         if (Objects.isNull(dbBook)) {

               return Mono.empty();

         }

         return getById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull).flatMap(bookToBeDeleted -> bookRepository

                     .delete(bookToBeDeleted).then(Mono.just(bookToBeDeleted)));

	 }
	
}
