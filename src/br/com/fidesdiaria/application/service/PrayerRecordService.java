package br.com.fidesdiaria.application.service;
import br.com.fidesdiaria.domain.model.Prayer;
import br.com.fidesdiaria.domain.model.PrayerRecord;
import br.com.fidesdiaria.domain.repository.PrayerRecordRepository;

public class PrayerRecordService {
	private final PrayerRecordRepository prayerRecordRepository;
	
	public PrayerRecordService(PrayerRecordRepository prayerRecordRepository) {
		this.prayerRecordRepository = prayerRecordRepository;
	}
	
	public void resgisterPrayerRecord(Long userid, String type) {
		Prayer prayerType = Prayer.fromString(type);
		PrayerRecord prayerRecord = new PrayerRecord(userid, prayerType);
		this.prayerRecordRepository.createPrayer(prayerRecord);
	}
}
