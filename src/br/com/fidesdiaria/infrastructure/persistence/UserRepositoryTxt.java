package br.com.fidesdiaria.infrastructure.persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import br.com.fidesdiaria.domain.model.User;
import br.com.fidesdiaria.domain.repository.UserRepository;

public class UserRepositoryTxt implements UserRepository {
	private final Map<Long, User> users;
	
	public UserRepositoryTxt(Map<Long, User> users) {
		this.users= users;
	}
	
	@Override
	public void createUser(User user) {
		this.users.put(user.getId(), user);
	}
	
	@Override
	
	public Optional<User> findById(Long id){
		return Optional.ofNullable(this.users.get(id));
	}
	
	@Override
	public List<User> findAll(){
		return new ArrayList<>(this.users.values());
	}

}
