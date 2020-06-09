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
import org.springframework.web.bind.annotation.PutMapping;
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
	
	private final String API_URL  = "/api/v1";
	
	
	// get candidate by id
	@GetMapping( API_URL + "/candidate/{id}")
	public Optional<Candidate> getCandidateById( @PathVariable int id) {
		return service.listById( id );
	}

	
	// get candidate list
	@GetMapping( API_URL + "/candidates" )
	Page<Candidate> candidatesPageable(Pageable pageable) {
		pageable = pageable.getPageSize() <= DEFAULT_PAGE_SIZE ? pageable : defaultPagination;
		return service.findAll( pageable );

	}
	
	// get candidate list filter by name
	@GetMapping( API_URL + "/candidates/{firstName}" )
	List<Candidate> candidatesPageableFilter(@PathVariable String firstName , Pageable pageable) {
		pageable = pageable.getPageSize() <= DEFAULT_PAGE_SIZE ? pageable : defaultPagination;
		return service.findAllByFirstName(firstName, pageable);
	}
	
	// delete candidate by id
	@DeleteMapping ( API_URL + "/candidate/{id}")
	public ResponseEntity deleteCandidateById( @PathVariable int id) {
		try {
			service.delete( id );
			return ResponseEntity.ok( "Candidate eliminated" );
		}catch (Exception e) {
			return new ResponseEntity<>("Candidate doesn't exist", HttpStatus.BAD_REQUEST);
		}
	}
	
	// create new candidate
	@PostMapping( API_URL + "/candidate")
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
	
	// update new candidate
		@PutMapping( API_URL + "/candidate/{id}")
		public Object updateCandidate ( @PathVariable int id , @RequestBody Candidate c )
		{
			try
			{
				if ( service.listById(id).isPresent() )
				{
					c.setId(id);
					service.save(c);
					return service.listById( c.getId() );
				}
				throw new Exception();
				
			}catch (Exception e) {
				return new ResponseEntity<>("Candidate not found", HttpStatus.BAD_REQUEST);
			}
		}
}
