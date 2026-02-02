package br.com.fidesdiaria.domain.model;

public class Saint {
	private String name;
	private int day;
	private int month;
	
	public Saint(String name, int day, int month) {
		this.name = name;
		this.day = day;
		this.month = month;
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
