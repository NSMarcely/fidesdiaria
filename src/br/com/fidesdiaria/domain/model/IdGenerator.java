package br.com.fidesdiaria.domain.model;

public enum IdGenerator {
	USER,
	PRAYER,
	READING,
	SAINT;
	
	private Long accountant = 1L;
	private double limit = Math.pow(10, 9)-1;
	
	public Long nextId() {
		if(accountant == limit){
			throw new IllegalStateException("O limite" + accountant + "/" + limit + "foi atingido.");
		}
		return accountant++;
	}
	
}
