package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Member;
import com.service.MemberServiceImpl;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/api/members")

@AllArgsConstructor

@RestController
public class MemberController {
	
	private final MemberServiceImpl memberService;
	
	@Autowired
	public MemberController(MemberServiceImpl memberService) 
	{
		this.memberService = memberService;
	}
	

	
	// Get all members
	@GetMapping("/")
    public Flux<Member> getAll() 
	{
          System.out.println("All the Members information");
          return memberService.getAll();
    }

	//Get by Id
	@GetMapping("{id}")
    public Mono<Member> getById(@PathVariable("id") final String id) 
	{
          System.out.println("One Member information based for the given ID");

          return memberService.getById(id);
    }
	
	@PostMapping

    public Mono save(@RequestBody final Member member) {

		System.out.println("Added Member Info " + member.getName() + " - " + member.getStreetAddress()
        + " - " + member.getCity() + " - " + member.getState() + " - " + member.getPostalCode()
        + " - " + member.getCountry() + " - " + member.getMembershipType() 
        + " - " + member.getMembershipDate() + " - " + member.getExpiryDate());

          return memberService.save(member);

    }
	
	@PutMapping("{id}")
    public Mono updateById(@PathVariable("id") final String id, @RequestBody final Member member) {

          System.out.println("Updating a Member Info");

          return memberService.update(id,member);
    }
		
	
	@DeleteMapping("{id}")

    public Mono delete(@PathVariable final String id) {

          System.out.println("A publisher Info has been deleted");

          return memberService.delete(id);

    }
			
}
