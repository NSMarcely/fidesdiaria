package br.com.fidesdiaria.presentation.cli;
import java.util.Scanner;
import br.com.fidesdiaria.application.service.PrayerRecordService;
import br.com.fidesdiaria.application.service.ReadingService;
import br.com.fidesdiaria.application.service.SaintService;
import br.com.fidesdiaria.application.service.UserService;

public class UserMenu {
	
	private final UserService userService;
	private final PrayerRecordService prayerRecordService;
	private final ReadingService readingService;
	private final SaintService saintService;
	
	public UserMenu(UserService userService, PrayerRecordService prayerRecordService, ReadingService readingService, SaintService saintService) {
		this.userService = userService;
		this.prayerRecordService = prayerRecordService;
		this.readingService = readingService;
		this.saintService = saintService;
	}
	
	public void showCommonUserOptions(Long userId) {
		System.out.println("::Menu::\n");
		this.saintService.findDaySaint();
		this.userService.viewUserProfile(userId);
		System.out.println("1 - Registrar oração."
				+ "\n2- Registrar leitura bíblica."
				+ "\n3- Ver histórico de oração."
				+ "\n4- Ver histórico de leitura bíblica.");
	}
	
	public void processOptions(int option, Scanner input, Long userId) {
		switch(option){
		case 1:
			input.nextLine();
			this.prayerRecordService.viewTypesPrayer();
			System.out.println("Tipo: ");
			String type = input.nextLine();
			this.prayerRecordService.registerPrayerRecord(userId, type);
			break;
		
		case 2: 
			System.out.println("Versículo lido: ");
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
		default:
			System.out.println("Opção inválida.");
			break;
		}
	}
	
	public void displayCommonMenu(Long userId) {
		
		Scanner input = new Scanner(System.in);
		boolean finish = false;
		while(!finish) {
			this.showCommonUserOptions(userId);
			System.out.println("5- Sair.");
			System.out.println("Opção: ");
			int option = input.nextInt();
			if(option == 5) {
				System.out.println("Saindo do sistema...");
				return;
			}
			else {
				processOptions(option, input, userId);
			}
		}
		input.close();
	}
	
	public SaintService getSaintService() {
		return this.saintService;
	}
	
}
