package br.com.fidesdiaria.domain.model;

public class User {
	private String name;
	private String password;
	private Long id;
	private Level level;

	public User(String name, String password) {
		this.name = name;
		this.password =  password;
		this.id = null;
		this.level = new Level();
	}
	
	public String getName() {
		return this.name;
	}

	public String getPassword() {
		return this.password;
	}
	
	public Level getLevel() {
		return this.level;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
