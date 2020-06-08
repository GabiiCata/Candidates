package com.fluxit.candidates.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fluxit.candidates.interfaceServices.ICandidateService;
import com.fluxit.candidates.models.Candidate;

@RestController
public class APIController {

	@Autowired
	private ICandidateService service;
	
	@GetMapping("/candidate/{id}")
	public Optional<Candidate> getCandidateById( @PathVariable int id) {
		return service.listById( id );
	}
	
	@GetMapping("/candidates")
	public List<Candidate> getCandidatesList( ) {
		return service.list();
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping ("/candidate/{id}")
	public ResponseEntity deleteCandidateById( @PathVariable int id) {
		try {
			service.delete( id );
			return ResponseEntity.ok( "Candidate eliminated" );
		}catch (Exception e) {
			return new ResponseEntity<>("Candidate doesn't exist", HttpStatus.BAD_REQUEST);
		}
	}
}
