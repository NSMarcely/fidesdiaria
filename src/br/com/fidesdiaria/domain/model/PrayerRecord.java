package br.com.fidesdiaria.domain.model;
import java.time.LocalDate;

public class PrayerRecord {
	private Long userId;
	private Long prayerId;
	private LocalDate fulfillment;
	
	public PrayerRecord(Long userId, Long prayerId) {
		this.userId = userId;
		this.prayerId = prayerId;
		this.fulfillment = LocalDate.now();
	}

	public Long getUserId() {
		return userId;
	}

	public Long getPrayerId() {
		return prayerId;
	}

	public LocalDate getFulfillment() {
		return fulfillment;
	}
	
}
