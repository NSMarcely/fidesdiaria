package br.com.fidesdiaria.infrastructure.persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import br.com.fidesdiaria.domain.model.Reading;
import br.com.fidesdiaria.domain.repository.ReadingRepository;

public class ReadingRepositoryTxt implements ReadingRepository {
	private final Map<Long, Reading> readings;
	
	public ReadingRepositoryTxt(Map<Long, Reading> readings) {
        this.readings = readings;
    }

	@Override
	public void createReading(Reading reading) {
		this.readings.put(reading.getReadingId(), reading);
	}
	
	@Override
	public List<Reading> findAll(){
		return new ArrayList<>(this.readings.values());
	}
	
}
