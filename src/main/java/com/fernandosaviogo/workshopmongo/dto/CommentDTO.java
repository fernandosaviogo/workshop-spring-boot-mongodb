package com.fernandosaviogo.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String text;
	private Date date;
	private AuthorDTO author;
	
	// Metodo construtor vazio
	public CommentDTO() {
		
	}
	
	// Metodo construtor
	public CommentDTO(String text, Date date, AuthorDTO author) {
		super();
		this.text = text;
		this.date = date;
		this.author = author;
	}
	
	// Metodos Gets e Sets
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

}
