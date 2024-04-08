package com.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Member;
import com.repository.MemberRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service

@Transactional

@AllArgsConstructor
public class MemberServiceImpl implements IMemberService{
	@Autowired
	private MemberRepository memberRepository;

	public Flux<Member> getAll() 
	{

        return memberRepository.findAll().switchIfEmpty(Flux.empty());

	}
	
	public Mono<Member> getById(final String id) 
	{

        return memberRepository.findById(id);
	}
	
	 public Mono update(final String id, final Member member) 
	 {

         return memberRepository.save(member);

	 }
	
	 public Mono save(final Member member) 
	 {

         return memberRepository.save(member);

	 }
	 
	 public Mono delete(final String id) 
	 {

         final Mono<Member> dbMember = getById(id);

         if (Objects.isNull(memberRepository)) {

               return Mono.empty();

         }

         return getById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull).flatMap(MemberToBeDeleted -> memberRepository

                     .delete(MemberToBeDeleted).then(Mono.just(MemberToBeDeleted)));
	 }
}
