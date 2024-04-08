package com.service;



import com.model.Member;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMemberService {
	Flux<Member> getAll();
	Mono<Member> getById(final String id);
	Mono update(final String id, final Member member);
	Mono save(final Member member);
	Mono delete(final String id);
}
