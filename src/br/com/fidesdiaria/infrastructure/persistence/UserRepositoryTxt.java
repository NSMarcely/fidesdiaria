package br.com.fidesdiaria.infrastructure.persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import br.com.fidesdiaria.domain.model.User;
import br.com.fidesdiaria.domain.repository.UserRepository;

public class UserRepositoryTxt implements UserRepository {
	private final Map<Long, User> users;
	private final AtomicLong userIdGenerator = new AtomicLong(1);
	
	public UserRepositoryTxt(Map<Long, User> users) {
		this.users= users;
	}
	
	@Override
	public void createUser(User user) {
		Long newUserId = this.userIdGenerator.getAndIncrement();
		user.setId(newUserId);
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
	
	@Override
	public void updateProgress(Long userId, int score) {
		User user = this.findById(userId).orElseThrow(() -> new RuntimeException("O usuário não foi encontrado."));
		user.getProgress().addScore(score);
		}
 
}
