package br.com.fidesdiaria.domain.model;

public class Prayer {
	private Long id;
	private String type;
	
	public Prayer(String type) {
		this.type = type;
		this.id = null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}
	
	

}
