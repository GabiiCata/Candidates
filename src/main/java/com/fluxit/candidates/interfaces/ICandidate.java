package com.fluxit.candidates.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.fluxit.candidates.models.Candidate;

public interface ICandidate extends CrudRepository<Candidate, Integer>{

}
