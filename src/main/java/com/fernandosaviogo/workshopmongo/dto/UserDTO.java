package com.fernandosaviogo.workshopmongo.dto;

import java.io.Serializable;

import com.fernandosaviogo.workshopmongo.domain.User;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String email;
	
	// Metodo construtor vazio
	public UserDTO() {
		
	}
	
	// Metodo construtor sobrecarregado
	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}
	
	// Metodos Gets e Sets
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
