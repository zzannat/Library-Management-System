package com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Member;
import com.service.MemberServiceImpl;

import reactor.core.publisher.Mono;


@Controller
@RequestMapping("/members")
public class MemberViewController 
{

	private final  MemberServiceImpl memberService;

    public MemberViewController(MemberServiceImpl memberService) {
        this.memberService = memberService;
    }
    
    @GetMapping
    public String getAllBooks(Model model) {
        List<Member> members = memberService.getAll().collectList().block();
        model.addAttribute("members", members);
        return "memberList"; 
    }
    
    @GetMapping("/add")
    public String addMemberForm(Model model) {
        model.addAttribute("member", new Member()); 
        return "addMember"; 
    }
    @PostMapping("/add")
    public String addMember(@ModelAttribute Member member) {
    	memberService.save(member).block(); 
        return "redirect:/members"; 
    }
    
    @GetMapping("/edit/{id}")
    public String editMember(@PathVariable String id, Model model) {
    	Mono<Member> memberMono = memberService.getById(id);
    	Member member = memberMono.block(); 
        model.addAttribute("member", member);
        return "editMember"; 
    }
    
    @PostMapping("/edit/{id}")
    public String editMember(@PathVariable String id, @ModelAttribute Member member) {
    	memberService.update(id, member).block(); 
    	return "redirect:/members"; 
    }
    
    
    @PostMapping("/delete/{id}")
    public String deletePublisher(@PathVariable String id) {
    	memberService.delete(id).block(); 
    	return "redirect:/members";  
    }
    
}
