package com.fernandosaviogo.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;  // o compilador não exige que a exeção seja tratada

	public ObjectNotFoundException(String msg) {
		super(msg);
	}
}
