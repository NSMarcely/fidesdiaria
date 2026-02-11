package br.com.fidesdiaria.application.service;
import br.com.fidesdiaria.domain.exception.InvalidAuthenticationException;
import br.com.fidesdiaria.domain.model.User;
import br.com.fidesdiaria.domain.repository.UserRepository;
import br.com.fidesdiaria.domain.security.PasswordValidator;

public class UserService {
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void registerUser(String name, String password) {
		PasswordValidator.valite(password);
		User newUse = new User(name, password);
		this.userRepository.createUser(newUse);
	}
	
	public void loginUser(String name, String password) {
		User searchUser = this.userRepository.findAll().stream()
		.filter(user -> user.getName().equals(name))
		.findFirst()
		.orElseThrow(() -> new InvalidAuthenticationException("Nome do usário não foi encontrado."));
		
		if(!searchUser.getPassword().equals(password)) {
			throw new InvalidAuthenticationException("Senha incorreta.");
		}
		System.out.println("Bem-vindo(a)" + searchUser.getName());
	}
}
