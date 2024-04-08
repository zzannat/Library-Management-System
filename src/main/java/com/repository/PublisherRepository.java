package com.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.model.Publisher;



public interface PublisherRepository extends  ReactiveMongoRepository<Publisher, String>{

}
