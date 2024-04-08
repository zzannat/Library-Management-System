package com.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Book;



@Repository
public interface BookRepository extends  ReactiveMongoRepository<Book, String>{

}
