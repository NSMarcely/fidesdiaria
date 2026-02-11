package br.com.fidesdiaria.domain.security;

import br.com.fidesdiaria.domain.exception.InvalidPasswordException;

public class PasswordValidator {
	public static void valite(String password) {
		if(password == null || password.length() < 8) {
			throw new InvalidPasswordException("A senha deve conter no mínimo 8 carácteres.");
		}
		int upperCaseCount = 0;
		int digitCount = 0;
		for(char i :password.toCharArray()) {
			if(Character.isUpperCase(i)) {
				upperCaseCount +=1;
			}
			else if(Character.isDigit(i)) {
				digitCount += 1;
			}
		}
		if(upperCaseCount == 0) {
			throw new InvalidPasswordException("A senha deve conter ao menos um carácter maiúsculo.");
		}
		if(digitCount == 0) {
			throw new InvalidPasswordException("A senha deve conter ao menos um número");
		}
	}
}
