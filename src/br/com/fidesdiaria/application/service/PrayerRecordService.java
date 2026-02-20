package br.com.fidesdiaria.application.service;
import br.com.fidesdiaria.domain.model.Prayer;
import br.com.fidesdiaria.domain.model.PrayerRecord;
import br.com.fidesdiaria.domain.repository.PrayerRecordRepository;
import br.com.fidesdiaria.domain.repository.UserRepository;

public class PrayerRecordService {
	private final PrayerRecordRepository prayerRecordRepository;
	private final UserRepository userRepository;
	
	public PrayerRecordService(PrayerRecordRepository prayerRecordRepository, UserRepository userRepository) {
		this.prayerRecordRepository = prayerRecordRepository;
		this.userRepository = userRepository;
	}
	
	public void registerPrayerRecord(Long userid, String type) {
		short score = 5;
		Prayer prayerType = Prayer.fromString(type);
		PrayerRecord prayerRecord = new PrayerRecord(userid, prayerType);
		this.prayerRecordRepository.createPrayer(prayerRecord);
		this.userRepository.updateProgress(userid, score);
	}
}
