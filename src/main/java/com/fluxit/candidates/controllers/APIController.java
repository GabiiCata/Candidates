package com.fluxit.candidates.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fluxit.candidates.interfaceServices.ICandidateService;
import com.fluxit.candidates.models.Candidate;

@RestController
@SuppressWarnings("rawtypes")
public class APIController {

	@Autowired
	private ICandidateService service;
	
	private final int DEFAULT_PAGE_SIZE = 10;
	Pageable defaultPagination = PageRequest.of ( 0 , DEFAULT_PAGE_SIZE );
	
	
	@GetMapping("/candidate/{id}")
	public Optional<Candidate> getCandidateById( @PathVariable int id) {
		return service.listById( id );
	}
	
	@GetMapping("/candidates")
	public List<Candidate> getCandidatesList( ) {
		return service.list();
	}
	

	@GetMapping( "/listpageable" )
	Page<Candidate> candidatesPageable(Pageable pageable) {
		pageable = pageable.getPageSize() <= DEFAULT_PAGE_SIZE ? pageable : defaultPagination;
		return service.findAll( pageable );

	}
	
	@GetMapping( "/listpageable/{name}" )
	List<Candidate> candidatesPageableFilter(@PathVariable String name , Pageable pageable) {
		pageable = pageable.getPageSize() <= DEFAULT_PAGE_SIZE ? pageable : defaultPagination;
		return service.findAllByName(name, pageable);
	}
	
	
	@DeleteMapping ("/candidate/{id}")
	public ResponseEntity deleteCandidateById( @PathVariable int id) {
		try {
			service.delete( id );
			return ResponseEntity.ok( "Candidate eliminated" );
		}catch (Exception e) {
			return new ResponseEntity<>("Candidate doesn't exist", HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PostMapping("/candidate")
	public Object addCandidate ( @RequestBody Candidate c )
	{
		try
		{
			service.save(c);
			return service.listById( c.getId() );
		}catch (Exception e) {
			return new ResponseEntity<>("Error adding new candidate", HttpStatus.BAD_REQUEST);
		}
	}
}
