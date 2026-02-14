package br.com.fidesdiaria.domain.model;

public enum UserType {
	COMMON("Comum"),
	ADMINISTRATOR("Administrador");
	
	private String description;
	
	private UserType(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
}
