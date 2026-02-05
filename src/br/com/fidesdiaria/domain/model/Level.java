package br.com.fidesdiaria.domain.model;

public enum Level {
	INICIANTE("Iniciante", 0, 10),
	CONSTANTE("Constante", 11, 25),
	PERSEVERANTE("", 26, 48),
	FIDEL("Fidel", 49, 70),
	DEVOTO("Devoto", 71, 100),
	CONFIANTE("Confiante", 101, 150),
	FIRME_NA_FE("Firme na fé", 151, 200);
	
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
