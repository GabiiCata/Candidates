package com.fluxit.candidates.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fluxit.candidates.interfaceServices.ICandidateService;
import com.fluxit.candidates.models.Candidate;


@Controller
@RequestMapping
public class RequestController {

	@Autowired
	private ICandidateService service;
	
	
	@GetMapping("/list")
	public String list ( Model model )
	{
		List<Candidate> candidates = service.list();
		model.addAttribute("candidates",candidates);
		
		return "index";
	}
}
