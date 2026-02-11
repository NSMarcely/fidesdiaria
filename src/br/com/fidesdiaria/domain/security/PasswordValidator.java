package br.com.fidesdiaria.domain.security;

public class PasswordValidator {
	public static boolean isValid(String password) {
		if(password.length() < 8) {
			return false;
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
		return upperCaseCount > 0 && digitCount > 0;
	}
}
