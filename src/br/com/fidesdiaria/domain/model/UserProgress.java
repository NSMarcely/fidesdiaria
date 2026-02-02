package br.com.fidesdiaria.domain.model;

public class UserProgress {
	private Long userId;
	private int score;
	
	public UserProgress(Long userId) {
		this.userId = userId;
		this.score = 0;
	}
	
	public void addScore(int ponts) {
		if(ponts < 0) {
			throw new IllegalArgumentException("Erro: o usário deve ter apenas pontos igual ou acima de 0.");
		}
		this.score += ponts;
	}
	
	public Level getLevel() {
		 Level level = Level.returnLevel(this.score);
		 return level;
	}
	
	public String toString() {
		return String.format("Pontos:%d", this.score);
	}
	
	 public int getScore() {
		 return this.score;
	 }
	 
	 public void setScore(int score) {
		 this.score = score;
	 }
	 
	 public Long getUserId() {
		 return this.userId;
	 }
	
}
