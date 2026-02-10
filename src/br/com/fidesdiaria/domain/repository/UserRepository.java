package br.com.fidesdiaria.domain.repository;
import br.com.fidesdiaria.domain.model.User;
import java.util.Optional;
import java.util.List;


public interface UserRepository {
	void createUser(User user);
	
	Optional<User> findById(Long id);
	
	List<User> findAll();
	
	void updateProgress(Long userId, int score);
}
