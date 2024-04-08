package com.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Member;



@Repository
public interface MemberRepository extends  ReactiveMongoRepository<Member, String>{

}
