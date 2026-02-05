package br.com.fidesdiaria.domain.model;
import java.time.LocalDate;

public class PrayerRecord {
	private Long userId;
	private Prayer type;
	private LocalDate fulfillment;
	
	public PrayerRecord(Long userId, Prayer type) {
		this.userId = userId;
		this.type = type;
		this.fulfillment = LocalDate.now();
	}

	
	public Long getUserId() {
		return this.userId;
	}

	public Prayer getType() {
		return this.type;
	}

	public LocalDate getFulfillment() {
		return this.fulfillment;
	}
	
}
