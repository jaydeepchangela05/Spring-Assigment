package com.demo.springboot.cruddemo.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.cruddemo.entity.ParentChild;
import com.demo.springboot.cruddemo.service.ParentChildService;

@RestController
@RequestMapping("/api")
public class ParentChildRestController {
	
	private ParentChildService parentChildService;
	
	public Logger LOGGER = LoggerFactory.getLogger(ParentChildRestController.class);
	
	@Autowired
	public ParentChildRestController(ParentChildService theParentChildService) {
		parentChildService = theParentChildService;
	}
	
	@GetMapping("/parent-children")
	public  ResponseEntity<List<ParentChild>> findAll() {
		
		LOGGER.info("Get All Data Of ParentChildern Table");
		
		return new ResponseEntity<>(parentChildService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/parent-children/{parentChildId}")
	public ResponseEntity<ParentChild> getParentChildren(@PathVariable int parentChildId) {
		
		ParentChild theParentChildren = parentChildService.findById(parentChildId);
		
		if (theParentChildren == null) {
			throw new RuntimeException("Parent id not found - " + parentChildId);
		}
		
		LOGGER.info("Get One ParentChildern Data From Table " + parentChildId);
		
		return new ResponseEntity<>(theParentChildren, HttpStatus.OK);
	}
	
	@PostMapping("/parent-children")
	public ResponseEntity<ParentChild> addParentChildren(@RequestBody ParentChild theParentChildren) {
		
		theParentChildren.setId(0);
		
		parentChildService.save(theParentChildren);
		
		LOGGER.info("Create New ParentChildren");
		
		return new ResponseEntity<>(theParentChildren, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/parent-children")
	public ResponseEntity<ParentChild> updateParentChildren(@RequestBody ParentChild theParentChildren) {
		
		parentChildService.save(theParentChildren);
		
		LOGGER.info("Update Parent-Children Table And Id Is" + theParentChildren.getId());
		
		return new ResponseEntity<>(theParentChildren, HttpStatus.OK);
	}
	
	@DeleteMapping("/parent-children/{parentChildId}")
	public ResponseEntity<String> deleteParentChildren(@PathVariable int parentChildId) {
		
		ParentChild theParentChildren = parentChildService.findById(parentChildId);
		
		if (theParentChildren == null) {
			throw new RuntimeException("Parent id not found - " + parentChildId);
		}
		
		parentChildService.deleteById(parentChildId);
		
		LOGGER.info("Delete Parent-Children And Id Is" + parentChildId);
		
		return new ResponseEntity<>("Parent is deleted id is -"+ parentChildId, HttpStatus.OK);
	}
	
	
}
