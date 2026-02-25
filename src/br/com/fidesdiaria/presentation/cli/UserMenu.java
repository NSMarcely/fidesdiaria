package br.com.fidesdiaria.presentation.cli;
import java.util.Scanner;
import br.com.fidesdiaria.application.service.PrayerRecordService;
import br.com.fidesdiaria.application.service.ReadingService;
import br.com.fidesdiaria.application.service.UserService;

public class UserMenu {
	private final UserService userService;
	private final PrayerRecordService prayerRecordService;
	private final ReadingService readingService;
	public UserMenu(UserService userService, PrayerRecordService prayerRecordService, ReadingService readingService) {
		this.userService = userService;
		this.prayerRecordService = prayerRecordService;
		this.readingService = readingService;
	}
	
	public void view(Long userId) {
		Scanner input = new Scanner(System.in);
		boolean finish = false;
		while(!finish) {
			this.userService.viewUserProfile(userId);
			System.out.println("1 - Registrar oração."
					+ "\n2- Registrar leitura bíblica."
					+ "\n3- Ver histórico de oração."
					+ "\n4- Ver histórico de leitura bíblica."
					+ "\n5- Sair.");
			int option = input.nextInt();
			input.nextLine();
			switch(option){
			case 1:
				this.prayerRecordService.viewTypesPrayer();
				System.out.println("Tipo:");
				String type = input.nextLine();
				this.prayerRecordService.registerPrayerRecord(userId, type);
				break;
			
			case 2: 
				System.out.println("Versículo lido:");
				String verse = input.nextLine();
				System.out.println("Reflexão: ");
				String reflection = input.nextLine();
				this.readingService.registerReading(userId, verse, reflection);
				break;
			case 3:
				this.prayerRecordService.prayerHistory(userId);
				break;
			case 4:
				this.readingService.readingHistory(userId);
				break;
			case 5:
				System.out.println("Saindo do sistema...");
				return;
			default:
				System.out.println("Opção inválida.");
				break;
			}
		}
		input.close();
	}
}
