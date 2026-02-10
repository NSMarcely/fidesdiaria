package br.com.fidesdiaria.application.service;
import br.com.fidesdiaria.domain.model.User;
import br.com.fidesdiaria.domain.repository.UserRepository;

public class UserService {
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void registerUser(String name, String password) {
		User newUse = new User(name, password);
		this.userRepository.createUser(newUse);
	}
	
	
}
