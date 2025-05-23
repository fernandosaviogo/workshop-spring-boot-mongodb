package com.fernandosaviogo.workshopmongo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fernandosaviogo.workshopmongo.dto.AuthorDTO;

@Document  // Indica que a classe corresponde a uma coleção no MongoDB
public class Post implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id  // Indica a chave
	private String id;
	private Date date;
	private String title;
	private String body;
	private AuthorDTO author;
	
	// Metodo construtor vazio
	public Post() {
		
	}
	
	// Metodo construtor
	public Post(String id, Date date, String title, String body, AuthorDTO author) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = author;
	}
	
	// Metodos Gets e Sets
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	
	// Metodo hashCode
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	// Metodo equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}

}
