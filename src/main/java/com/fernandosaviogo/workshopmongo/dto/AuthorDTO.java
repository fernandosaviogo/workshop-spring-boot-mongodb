package com.fernandosaviogo.workshopmongo.dto;

import java.io.Serializable;

import com.fernandosaviogo.workshopmongo.domain.User;

public class AuthorDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	
	// Metodo construtor vazio
	public AuthorDTO() {
		
	}
	
	// Metodo construtor
	public AuthorDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
	}
	
	// Metodos Gets e Sets
	public String getID() {
		return id;
	}

	public void setID(String iD) {
		id = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
