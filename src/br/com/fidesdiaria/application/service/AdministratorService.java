package br.com.fidesdiaria.application.service;
import br.com.fidesdiaria.domain.model.User;
import br.com.fidesdiaria.domain.model.UserType;
import br.com.fidesdiaria.domain.repository.UserRepository;

public class AdministratorService {
	private final UserRepository userRepository;
	
	public AdministratorService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void promoteToAdmin(Long userId) {
		User userFound =this.userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("Usuário não indetificado."));
		
		if(userFound.getType() == UserType.ADMINISTRATOR) {
			throw new RuntimeException("O usuário já é administrador.");
		}
		userFound.setType(UserType.ADMINISTRATOR);
		System.out.printf("O usuário %s foi promovido com sucesso!", userFound.getName());
	}
}

