package br.com.fidesdiaria.domain.model;

public class Level {
	private String name;
	private int value;
	private int score;
	private int limit;
	
	public Level () {
		this.name = "Iniciante";
		this.value = 0;
		this.score = 0;
		this.limit = 100;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
}
