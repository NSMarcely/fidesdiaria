package br.com.fidesdiaria.domain.model;
import java.time.LocalDate;

public class Reading {
	Long userId;
	String verse;
	String reflection;
	Long readingId;
	LocalDate fulfillment;
	
	public Reading (Long userId, String verse, String reflection) {
		this.userId = userId;
		this.verse = verse;
		this.reflection = reflection;
		this.readingId = IdGenerator.READING.nextId();
		this.fulfillment = LocalDate.now();
	}
	
	public String toString() {
		return String.format("\nID: %s"
				+ "\nVersículo: %s"
				+ "\nReflexão: %s"
				+ "\nData: %tD", this.readingId, this.verse, this.reflection, this.fulfillment);
	}
	
	public Long getUserId() {
		return this.userId;
	}

	public LocalDate getFulfillment() {
		return fulfillment;
	}

	public String getVerse() {
		return verse;
	}
	
	public Long getReadingId() {
		return this.readingId;
	}
	
	public void setReadingId(Long readingId) {
		this.readingId = readingId;
	}
	
	public String getReflection() {
		return reflection;
	}
}
