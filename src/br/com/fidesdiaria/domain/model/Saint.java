package br.com.fidesdiaria.domain.model;

public class Saint {
	private Long id;
	private String name;
	private int day;
	private int month;
	
	public Saint(String name, int day, int month) {
		this.name = name;
		this.day = day;
		this.month = month;
		this.id = null;
	}
	
	public String toString() {
		return String.format("Nome: %s", this.name);
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getDay() {
		return this.day;
	}
	
	public int getMonth() {
		return this.month;
	}
}
