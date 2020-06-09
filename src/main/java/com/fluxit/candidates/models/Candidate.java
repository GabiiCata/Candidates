package com.fluxit.candidates.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "candidate")
public class Candidate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String firstName; 
	private String lastName;
	private Date birth;
	private Long DNI;
	private String address;
	private int phone;
	private String email;

	 
	
	

}
