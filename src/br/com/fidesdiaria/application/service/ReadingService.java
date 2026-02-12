package br.com.fidesdiaria.application.service;
import br.com.fidesdiaria.domain.model.Reading;
import br.com.fidesdiaria.domain.repository.ReadingRepository;
import br.com.fidesdiaria.domain.repository.UserRepository;

public class ReadingService {
	private final ReadingRepository readingRepository;
	private final UserRepository userRepository;
	
	public ReadingService(ReadingRepository readingRepository, UserRepository userRepository) {
		this.readingRepository = readingRepository;
		this.userRepository = userRepository;
	}
	
	public void registerReading(Long userId, String verse, String reflection) {
		short score = (short) (reflection.length() > 35 ? 10 : 5) ;
		Reading newReading = new Reading(userId, verse, reflection);
		this.readingRepository.createReading(newReading);
		this.userRepository.updateProgress(userId, score);
	}
	
	public void readingHistory(Long userId) {
		this.readingRepository.findAll().stream()
		.filter(reading -> reading.getUserId().equals(userId))
		.forEach(reading -> System.out.println(reading));
	}
}
