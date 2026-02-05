package br.com.fidesdiaria.domain.repository;
import java.util.List;
import br.com.fidesdiaria.domain.model.Reading;

public interface ReadingRepository {
	void createReading(Reading reading);

	List<Reading> findAll();
}
