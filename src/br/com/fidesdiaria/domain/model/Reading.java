package br.com.fidesdiaria.domain.model;
import java.time.LocalDate;

public class Reading {
	String verse;
	String reflection;
	Long id;
	LocalDate fulfillment;
	
	public Reading (String verse, String reflection) {
		this.verse = verse;
		this.reflection = reflection;
		this.id = null;
		this.fulfillment = LocalDate.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFulfillment() {
		return fulfillment;
	}

	public void setFulfillment(LocalDate fulfillment) {
		this.fulfillment = fulfillment;
	}

	public String getVerse() {
		return verse;
	}

	public String getReflection() {
		return reflection;
	}
}
