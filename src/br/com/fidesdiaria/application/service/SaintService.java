package br.com.fidesdiaria.application.service;
import java.time.LocalDate;
import java.util.List;
import br.com.fidesdiaria.domain.model.Saint;
import br.com.fidesdiaria.domain.repository.SaintRepository;

public class SaintService {
	public final SaintRepository saintRepository;

	public SaintService(SaintRepository saintRepository) {
		this.saintRepository = saintRepository;
	}
	
	public void registerDaySaint(String name, int day, int month) {
		Saint newSaint = new Saint(name, day, month);
		this.saintRepository.creatDaySaint(newSaint);
	}
	
	public void findDaySaint() {
		LocalDate today = LocalDate.now();
		List<Saint> saints = this.saintRepository.findAll().stream()
		.filter(saint -> saint.getDay() == today.getDayOfMonth() && saint.getMonth() == today.getMonthValue())
		.toList();
		if(saints.isEmpty()) {
			System.err.println("Nenhum Santo encontrado");
		}
		else {
			System.out.println("Santos de hoje:");
			saints.forEach(s -> System.out.println(s));
		}
	}
}
