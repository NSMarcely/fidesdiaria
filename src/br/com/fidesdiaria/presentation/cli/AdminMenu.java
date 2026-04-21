package br.com.fidesdiaria.presentation.cli;
import java.util.Scanner;
import br.com.fidesdiaria.application.service.AdministratorService;
import br.com.fidesdiaria.application.service.PrayerRecordService;
import br.com.fidesdiaria.application.service.ReadingService;
import br.com.fidesdiaria.application.service.SaintService;
import br.com.fidesdiaria.application.service.UserService;

public class AdminMenu extends UserMenu{
	
	private final AdministratorService administratorService;
	
	public AdminMenu(UserService userService, PrayerRecordService prayerRecordService,
			ReadingService readingService, SaintService saintService, AdministratorService administratorService) {
		super(userService, prayerRecordService, readingService, saintService);
		this.administratorService = administratorService;
	}
	
	public void displayAdminMenu(Long userId) {
		Scanner input = new Scanner(System.in);
		boolean finish = false;
		
		while(!finish) {
			super.showCommonUserOptions(userId);
			System.out.println("5- Registrar Santo do Dia."
					+ "\n6- Promover usuário a administrador"
					+ "\n7- Sair.");
			
			System.out.println("Opção: ");
			int option = input.nextInt();
			input.nextLine();
			
			if(option == 5) {
				System.out.println("__Registrar Santo__");
				System.out.println("Nome do Santo: ");
				String name = input.nextLine();
				System.out.println("Dia do Santo: ");
				int day = input.nextInt();
				input.nextLine();
				System.out.println("Mês do Santo: ");
				int month = input.nextInt();
				input.nextLine();
				super.getSaintService().registerDaySaint(name, day, month);
				System.out.println("Santo registrado com sucesso!");
			}
			
			else if(option == 6) {
				System.out.println("__Promover Usuário__");
				System.out.println("ID do usuário: ");
				Long id = input.nextLong();
				input.nextLine();
				this.administratorService.promoteToAdmin(id);
				System.out.println("O usário foi promovido com sucesso!");
			}
			
			else if(option == 7) {
				System.out.println("Saindo do sistema...");
				return;
			}
			
			else {
				super.processOptions(option, input, userId);
			}
		}
		input.close();
		
	}
	
}
