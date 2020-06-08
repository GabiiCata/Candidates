package com.fluxit.candidates.interfaceServices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.fluxit.candidates.models.Candidate;

@Repository
public interface ICandidateService {
	
	public List < Candidate > list ();
	public Optional < Candidate > listById ( int id );
	public int save ( Candidate c );
	public void delete ( int id );
	
}
