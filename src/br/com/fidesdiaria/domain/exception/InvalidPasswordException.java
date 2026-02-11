package br.com.fidesdiaria.domain.exception;

public class InvalidPasswordException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public InvalidPasswordException(String menssage) {
		super(menssage);
	}
}
