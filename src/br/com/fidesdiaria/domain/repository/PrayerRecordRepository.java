package br.com.fidesdiaria.domain.repository;
import java.util.List;
import br.com.fidesdiaria.domain.model.Prayer;

public interface PrayerRecordRepository {
	void createPrayer(Prayer prayer);

	List<Prayer> findAll();
}
