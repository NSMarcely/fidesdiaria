package br.com.fidesdiaria.application.service;
import br.com.fidesdiaria.domain.model.Reading;
import br.com.fidesdiaria.domain.repository.ReadingRepository;

public class ReadingService {
	private final ReadingRepository readingRepository;
	
	public ReadingService(ReadingRepository readingRepository) {
		this.readingRepository = readingRepository;
	}
	
	public void registerReading(Long userId, String verse, String reflection) {
		Reading newReading = new Reading(userId, verse, reflection);
		this.readingRepository.createReading(newReading);
	}
	
	public void readingHistory(Long userId) {
		this.readingRepository.findAll().stream()
		.filter(reading -> reading.getUserId().equals(userId))
		.forEach(reading -> System.out.println(reading));
	}
}
