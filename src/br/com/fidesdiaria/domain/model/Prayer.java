package br.com.fidesdiaria.domain.model;
import java.time.LocalDate;

public class Prayer {
	private Long id;
	private String type;
	LocalDate fulfillment;
	
	public Prayer(String type) {
		this.type = type;
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

	public String getType() {
		return type;
	}
	
	

}
