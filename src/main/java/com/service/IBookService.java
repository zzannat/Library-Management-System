package com.service;



import com.model.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBookService 
{
	Flux<Book> getAll();
	Mono<Book> getById(final String id);
	Mono update(final String id, final Book book);
	Mono save(final Book book);
	Mono delete(final String id);
	
}