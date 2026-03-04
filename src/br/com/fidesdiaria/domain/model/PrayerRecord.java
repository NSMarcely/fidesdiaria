package br.com.fidesdiaria.domain.model;
import java.time.LocalDate;

public class PrayerRecord {
	private Long userId;
	private Prayer type;
	private Long PrayerId;
	private LocalDate fulfillment;
	
	public PrayerRecord(Long userId, Prayer type) {
		this.userId = userId;
		this.type = type;
		this.PrayerId = IdGenerator.PRAYER.nextId();
		this.fulfillment = LocalDate.now();
	}
	
	public String toString() {
		return String.format("\nID: %d"
				+ "\nTipo: %s"
				+ "\nData: %tD", this.PrayerId, this.type.getPrayerName(), this.fulfillment);
	}
	public Long getUserId() {
		return this.userId;
	}

	public Prayer getType() {
		return this.type;
	}
	
	public Long getPrayerId() {
		return this.PrayerId;
	}
	
	public void setPrayerId(Long id) {
		this.PrayerId = id;
	}
	
	public LocalDate getFulfillment() {
		return this.fulfillment;
	}
	
}
