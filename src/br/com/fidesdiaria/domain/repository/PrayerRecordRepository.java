package br.com.fidesdiaria.domain.repository;
import java.util.List;
import br.com.fidesdiaria.domain.model.PrayerRecord;

public interface PrayerRecordRepository {
	void createPrayer(PrayerRecord prayerRecord);

	List<PrayerRecord> findAll();
}
