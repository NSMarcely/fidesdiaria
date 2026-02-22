package br.com.fidesdiaria.domain.security;

public class NameFormatter {
	public static String format(String inputName) {
		if(inputName.isBlank() || inputName == null) {
			throw new RuntimeException("Escampo não pode estar vazio");
		}
		String name = inputName.trim();
		String[] arrayName = name.split("\\s+");
		StringBuilder newName = new StringBuilder();
		for(String i : arrayName) {
			String formatter = i.substring(0, 1).toUpperCase() + i.substring(1).toLowerCase();
			newName.append(formatter).append(" ");
		}
		return arrayName.toString().trim();
	}
}
