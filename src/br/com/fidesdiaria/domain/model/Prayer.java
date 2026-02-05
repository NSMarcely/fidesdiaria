package br.com.fidesdiaria.domain.model;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public enum Prayer {
	
	MORNING("Manhã"),
	NIGHT("Noite"),
	AFTERNOON("Tarde"),
	MARIAN_ROSARY("Terço Mariano"),
	DIVINE_MERCY("Terço da Divina Misericórdia");
	
	private String prayerName;
	
	private Prayer(String prayerName) {
		this.prayerName = prayerName;
	}
	
	public static List<String> returnAllPrayerType() {
		return Arrays.stream(values())
				.map(Prayer::getPrayerName)
				.collect(Collectors.toList());
	}
	
	public String getPrayerName() {
		return this.prayerName;
	}

}
