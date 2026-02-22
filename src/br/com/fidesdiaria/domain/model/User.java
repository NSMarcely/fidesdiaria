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
	
	public String toString() {
		return String.format("\nNome: %s, Nível: %s, ID: %d, tipo: %s"
				, this.name, this.progress.getLevelDescription(), this.id, this.type);
	}
	
	public String toUserView() {
		return String.format("\nNome: %s"
				+ "\nNível: %s (Pontos: %d)"
				+ "\nID: %d"
				+ "\nTipo: %s"
				, this.name, this.progress.getLevelDescription(), this.progress.getScore(), this.id, this.type);
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

	public void setType(UserType type) {
		this.type = type;
	}
	
}
