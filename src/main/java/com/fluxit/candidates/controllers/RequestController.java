package com.fluxit.candidates.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/new")
	public String add( Model model )
	{
		model.addAttribute( "candidate" , new Candidate() );
		
		return "form";
	}
	
	
	@PostMapping("/save")
	public String save (@Valid Candidate c, Model model)
	{
		service.save(c);
		return "redirect:/list";
	}
	
	@GetMapping("/edit/{id}")
	public String edit ( @PathVariable int id,  Model model)
	{
		Optional <Candidate> candidate = service.listById( id );
		model.addAttribute("candidate", candidate);
		return "form";
	}
	
	@GetMapping("/delete/{id}")
	public String delete ( @PathVariable int id,  Model model)
	{
		service.delete(id);
		return "redirect:/list";
	}
	
}
