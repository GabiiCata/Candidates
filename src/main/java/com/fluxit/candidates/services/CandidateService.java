package com.fluxit.candidates.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fluxit.candidates.interfaceServices.ICandidateService;
import com.fluxit.candidates.interfaces.ICandidate;
import com.fluxit.candidates.models.Candidate;

@Service
public class CandidateService implements ICandidateService{
	
	@Autowired
	private ICandidate data;

	@Override
	public List<Candidate> list() {
		return ( 	List < Candidate > ) data.findAll();
	}

	@Override
	public Optional<Candidate> listById(int id) {
		return data.findById( id );
	}

	@Override
	public int save(Candidate c) {
		
		Candidate candidate = data.save( c );
		
		if ( ! (candidate == null) ) 
		
			return 1;
		
		return 0;
	}

	@Override
	public void delete(int id) {
		data.deleteById( id );
		
	}

	@Override
	public Page<Candidate> findAll(Pageable pageable)
	{
		return data.findAll( pageable );
	}

	
	@Override
	public List<Candidate> findAllByFirstName( String firstName, Pageable pageable)
	{
		return data.findAllByFirstName( firstName , pageable );
	}
}
