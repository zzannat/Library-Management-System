package com.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Publisher;
import com.repository.PublisherRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service

@Transactional

@AllArgsConstructor
public class PublisherServiceImpl implements IPublisherService 
{
	@Autowired
	private PublisherRepository publisherRepository;

	public Flux<Publisher> getAll() 
	{

        return publisherRepository.findAll().switchIfEmpty(Flux.empty());

	}
	
	public Mono<Publisher> getById(final String id) 
	{

        return publisherRepository.findById(id);
	}
	
	 public Mono update(final String id, final Publisher publisher) 
	 {

         return publisherRepository.save(publisher);

	 }
	
	 public Mono save(final Publisher publisher) 
	 {

         return publisherRepository.save(publisher);

	 }
	 
	 public Mono delete(final String id) 
	 {

         final Mono<Publisher> dbPublisher = getById(id);

         if (Objects.isNull(dbPublisher)) {

               return Mono.empty();

         }

         return getById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull).flatMap(publisherToBeDeleted -> publisherRepository

                     .delete(publisherToBeDeleted).then(Mono.just(publisherToBeDeleted)));
	 }
}
