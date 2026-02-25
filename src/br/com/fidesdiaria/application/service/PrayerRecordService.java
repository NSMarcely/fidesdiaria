package br.com.fidesdiaria.application.service;
import java.util.List;
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
	
	public void viewTypesPrayer() {
		List<String> prayers = Prayer.returnAllPrayerType();
		System.out.println("___________________________________");
		for(int i = 0; 1<=prayers.size(); i++) {
			System.out.printf("\n%d- %s", i+ 1,  prayers.get(i));
		}
		System.out.println("___________________________________");
	}
	
	public void prayerHistory(long prayerId) {
		System.out.println("|Histórico de Orações|");
		this.prayerRecordRepository.findAll().stream()
		.filter(prayer -> prayer.getUserId().equals(prayerId))
		.forEach(prayer -> System.out.println(prayer));
	}
}
