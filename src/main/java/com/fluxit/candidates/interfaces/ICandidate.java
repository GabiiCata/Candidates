package com.fluxit.candidates.interfaces;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.fluxit.candidates.models.Candidate;

public interface ICandidate extends PagingAndSortingRepository<Candidate, Integer>{
	List<Candidate> findAllByFirstName(String firstName, Pageable pageable);
}
