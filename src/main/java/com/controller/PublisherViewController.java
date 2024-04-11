package com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Publisher;
import com.service.PublisherServiceImpl;

import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/publishers")
public class PublisherViewController 
{
	private final  PublisherServiceImpl publisherService;

    public PublisherViewController(PublisherServiceImpl publisherService) {
        this.publisherService = publisherService;
    }
    
    @GetMapping
    public String getAllBooks(Model model) {
        List<Publisher> publishers = publisherService.getAll().collectList().block();
        model.addAttribute("publishers", publishers);
        return "publishersList"; 
    }
    
    @GetMapping("/add")
    public String addPublsherForm(Model model) {
        model.addAttribute("publisher", new Publisher()); 
        return "addPublisher"; 
    }

    @PostMapping("/add")
    public String addPublsher(@ModelAttribute Publisher publisher) {
    	publisherService.save(publisher).block(); // Save the new publisher
        return "redirect:/publishers"; // Redirect to the main publishers list
    }
    
    @GetMapping("/edit/{id}")
    public String editPublisher(@PathVariable String id, Model model) {
    	Mono<Publisher> publisherMono = publisherService.getById(id);
    	Publisher publisher = publisherMono.block(); 
        model.addAttribute("publisher", publisher);
        return "editPublisher"; 
    }
    
    @PostMapping("/edit/{id}")
    public String editPublisher(@PathVariable String id, @ModelAttribute Publisher publisher) {
    	publisherService.update(id, publisher).block(); 
    	return "redirect:/publishers"; 
    }
    
    
    @PostMapping("/delete/{id}")
    public String deletePublisher(@PathVariable String id) {
    	publisherService.delete(id).block(); 
    	return "redirect:/publishers";  
    }
    
}
