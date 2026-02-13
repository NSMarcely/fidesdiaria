package br.com.fidesdiaria.infrastructure.persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.fidesdiaria.domain.model.PrayerRecord;
import br.com.fidesdiaria.domain.repository.PrayerRecordRepository;

public class PrayerRecordRepositoryTxt implements PrayerRecordRepository {
	private final Map<Long, PrayerRecord> prayers;
	
	public PrayerRecordRepositoryTxt(Map<Long, PrayerRecord> prayers) {
		this.prayers = prayers;
	}
	
	@Override
	public void createPrayer(PrayerRecord prayerRecord) {
		
	}
	
	@Override
	public List<PrayerRecord> findAll(){
		return new ArrayList<>(this.prayers.values());
	}
}
