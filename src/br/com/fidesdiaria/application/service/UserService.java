package br.com.fidesdiaria.application.service;
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
	
	
}
