package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Publisher;
import com.service.PublisherServiceImpl;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/api/publishers")

@AllArgsConstructor

@RestController
public class PublisherController 
{
	private final PublisherServiceImpl publisherService;
	
	@Autowired
	public PublisherController(PublisherServiceImpl publisherService) 
	{
		this.publisherService = publisherService;
	}
	
		// Get all publishers
		@GetMapping("/")
	    public Flux<Publisher> getAll() 
		{
	          System.out.println("All the Publishers information");
	          return publisherService.getAll();
	    }

		//Get by Id
		@GetMapping("{id}")
	    public Mono<Publisher> getById(@PathVariable("id") final String id) 
		{
	          System.out.println("One Publisher information based for the given ID");

	          return publisherService.getById(id);
	    }
		
		@PostMapping

	    public Mono save(@RequestBody final Publisher publisher) {

	          System.out.println("Added publisher Info "+ publisher.getName() + " - " + publisher.getStreetAddress()

	          + " - " + publisher.getCity() + " - " + publisher.getState()+ " - " + publisher.getPostalCode()+ " - " + publisher.getCountry());

	          return publisherService.save(publisher);

	    }
		
		@CrossOrigin
		@PutMapping("{id}")
	    public Mono updateById(@PathVariable("id") final String id, @RequestBody final Publisher publisher) {

	          System.out.println("Updating an publisher Info");

	          return publisherService.update(id,publisher);
	    }
		

	    @DeleteMapping("{id}")

	    public Mono delete(@PathVariable final String id) {

	          System.out.println("An publisher Info deleted");

	          return publisherService.delete(id);

	    }
		
}
