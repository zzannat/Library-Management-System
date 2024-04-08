package com.service;



import com.model.Publisher;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPublisherService {
	Flux<Publisher> getAll();
	Mono<Publisher> getById(final String id);
	Mono update(final String id, final Publisher publisher);
	Mono save(final Publisher publisher);
	Mono delete(final String id);
}

