package br.com.fidesdiaria.domain.model;

public class User {
	private Long id;
	private String name;
	private String password;
	private UserProgress progress;
	private UserType type;

	public User(String name, String password) {
		this.name = name;
		this.password =  password;
		this.id = null;
		this.progress = new UserProgress();
		this.type = UserType.COMMON;
	}
	
	public String getName() {
		return this.name;
	}

	public String getPassword() {
		return this.password;
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

	public UserProgress getProgress() {
		return progress;
	}
	
	public UserType getType() {
		return type;
	}
}
