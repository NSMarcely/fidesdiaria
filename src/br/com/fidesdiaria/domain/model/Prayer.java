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
	
	public static Prayer fromString(String input) {
		String lowerInput = input.toLowerCase()
		.replace(" ","")
		.replace("ã", "a")
		.replace("ó", "o")
		.replace("ç", "c");
		for(Prayer prayer : values()) {
			String lowerPrayerName = prayer.getPrayerName().toLowerCase()
			.replace(" ","")
			.replace("ã", "a")
			.replace("ó", "o")
			.replace("ç", "c");
			if(lowerPrayerName.equals(lowerInput)) {
				return prayer;
			}
		}
		throw new IllegalArgumentException("Não foi possivel indetificar a opição, tente: "
		+ String.join(",", returnAllPrayerType()) );
	}
	
	public String getPrayerName() {
		return this.prayerName;
	}

}
