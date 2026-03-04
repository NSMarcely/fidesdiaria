package br.com.fidesdiaria;
import java.util.HashMap;
import java.util.Map;
import br.com.fidesdiaria.application.service.AdministratorService;
import br.com.fidesdiaria.application.service.PrayerRecordService;
import br.com.fidesdiaria.application.service.ReadingService;
import br.com.fidesdiaria.application.service.SaintService;
import br.com.fidesdiaria.application.service.UserService;
import br.com.fidesdiaria.domain.model.PrayerRecord;
import br.com.fidesdiaria.domain.model.Reading;
import br.com.fidesdiaria.domain.model.Saint;
import br.com.fidesdiaria.domain.model.User;
import br.com.fidesdiaria.domain.repository.PrayerRecordRepository;
import br.com.fidesdiaria.domain.repository.ReadingRepository;
import br.com.fidesdiaria.domain.repository.SaintRepository;
import br.com.fidesdiaria.domain.repository.UserRepository;
import br.com.fidesdiaria.infrastructure.persistence.PrayerRecordRepositoryTxt;
import br.com.fidesdiaria.infrastructure.persistence.ReadingRepositoryTxt;
import br.com.fidesdiaria.infrastructure.persistence.SaintRepositoryTxt;
import br.com.fidesdiaria.infrastructure.persistence.UserRepositoryTxt;
import br.com.fidesdiaria.presentation.cli.AdminMenu;
import br.com.fidesdiaria.presentation.cli.StartMenu;
import br.com.fidesdiaria.presentation.cli.UserMenu;

public class Main {
	public static void main(String[] args) {
		
		Map<Long, PrayerRecord> prayers = new HashMap<>();
		Map<Long, Reading> readings = new HashMap<>();
		Map<Long, Saint> saints = new HashMap<>();
		Map<Long, User> users = new HashMap<>();
		
		PrayerRecordRepository prayerRecordRepository = new PrayerRecordRepositoryTxt(prayers);
		ReadingRepository readingRepository = new ReadingRepositoryTxt(readings);
		SaintRepository saintRepository = new SaintRepositoryTxt(saints);
		UserRepository userRepository = new UserRepositoryTxt(users);
		
		AdministratorService administratorService = new AdministratorService(userRepository);
		PrayerRecordService prayerRecordService = new PrayerRecordService(prayerRecordRepository, userRepository);
		ReadingService readingService = new ReadingService(readingRepository, userRepository);
		SaintService saintService = new SaintService(saintRepository);
		UserService userService = new UserService(userRepository);
		
		UserMenu userMenu = new UserMenu(userService, prayerRecordService, readingService, saintService);
		AdminMenu adminMenu = new AdminMenu(userService, prayerRecordService, readingService, saintService, administratorService);
		StartMenu startMenu = new StartMenu(userService, adminMenu, userMenu);
			
		startMenu.displayMainMenu();
	}
}
