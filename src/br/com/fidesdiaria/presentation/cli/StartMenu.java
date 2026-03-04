package br.com.fidesdiaria.presentation.cli;
import java.util.Scanner;
import br.com.fidesdiaria.application.service.UserService;
import br.com.fidesdiaria.domain.model.User;
import br.com.fidesdiaria.domain.model.UserType;

public class StartMenu {
	
	private final UserService userService;
	private final AdminMenu adminMenu;
	private final UserMenu userMenu;
	
	public StartMenu(UserService userService, AdminMenu adminMenu, UserMenu userMenu) {
		this.userService = userService;
		this.adminMenu = adminMenu;
		this.userMenu = userMenu;
	}
	
	public void displayMainMenu() {
		
		Scanner input = new Scanner(System.in);
		boolean finish = false;
		
		while(!finish) {
			System.out.println("___FidesDiária___\n");
			System.out.println("1- Registra-se."
					+ "\n2- Logar-se."
					+ "\n3- Sair do sistema.");
			System.out.println("Opção: ");
			int option = input.nextInt();
			input.nextLine();
			switch(option){
			case 1:
				System.out.println("Nome: ");
				String name = input.nextLine();
				System.out.println("Senha: ");
				String password = input.nextLine();
				this.userService.registerUser(name, password);
				System.out.println("\nO registro foi feito com sucesso!\n");
				break;
			case 2: 
				System.out.println("Nome: ");
				String userName = input.nextLine();
				System.out.println("Senha: ");
				String userPassword = input.nextLine();
				User user = this.userService.loginUser(userName, userPassword);
				if(user.getType() == UserType.ADMINISTRATOR) {
					System.out.printf("\nBem-vindo(a) %s ao seu Perfil\n", user.getName());
					this.adminMenu.displayAdminMenu(user.getId());
				}
				else {
					System.out.printf("\nBem-vindo(a) %s ao seu Perfil\n", user.getName());
					this.userMenu.displayCommonMenu(user.getId());
				}
				break;
			case 3: 
				System.out.println("Saindo do sitema...");
				return;
				
			default:
				System.out.println("Opção inválida.");
			}
		}
		input.close();
	}
}
