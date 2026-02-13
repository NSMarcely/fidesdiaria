package br.com.fidesdiaria.domain.model;

public enum Level {
	BEGINNER("Iniciante", 0, 10),
	CONSTANT("Constante", 11, 25),
	PERSEVERANT("Perseverante", 26, 70),
	DEVOTED("Devoto", 71, 150),
	STEADFAST_IN_FAITH("Firme na fé", 151, 200);
	
	private final String description;
	private final int minScore;
	private final int maxScore;
	
	private Level(String description, int minScore, int maxScore) {
		this.description = description;
		this.minScore = minScore;
		this.maxScore = maxScore;
	}
	
	public static Level returnLevel (int userScore) {
		for(Level level : values()) {
			if(userScore >= level.minScore && userScore <= level.maxScore) {
				return level;
			}
		}
		throw new IllegalArgumentException("Erro: pontos invalidos" + userScore);
	}
	
	
	public String getDescription() {
		return this.description;
	}
	
	public int getMinScore() {
		return this.minScore;
	}
	
	public int getMaxScore() {
		return this.maxScore;
	}
}
