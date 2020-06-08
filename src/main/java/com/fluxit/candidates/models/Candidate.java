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
	private String name; 
	private String lastName;
	private Date birth;
	private String address;
	private int phone;
	private String email;

	public Candidate() {	}
	
	public Candidate(int id, String name, String lastName, Date birth, String address, int phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.birth = birth;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

}
