package br.com.fidesdiaria.infrastructure.persistence;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;
import br.com.fidesdiaria.domain.model.IdGenerator;
import br.com.fidesdiaria.domain.model.User;
import br.com.fidesdiaria.domain.model.UserType;
import br.com.fidesdiaria.domain.repository.UserRepository;

public class UserRepositoryTxt implements UserRepository {
	private final String userFile = "user.txt";
	private static final Logger logger = Logger.getLogger(UserRepositoryTxt.class.getName());
	private final Map<Long, User> users;
	
	public UserRepositoryTxt(Map<Long, User> users) {
		this.users= users;
	}
	/*public static void admincheck() {
		if()
	}*/
	
	@Override
	public void createUser(User user) {
		Long newUserId = IdGenerator.USER.nextId();
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
	
	@Override
	public void read() {
		logger.info("Lendo o arquivo: " + this.userFile);
		File userFile = new File(this.userFile); 
		if(!userFile.exists()) {
			logger.warning("O arquivo "+ this.userFile +  " não pode ser encontrado.");
			return;
		}
		try(BufferedReader br = new BufferedReader(new FileReader(userFile))){
			String line;
			while((line = br.readLine()) != null) {
				String[] parts = line.split(";");
				String name = parts[0];
				String password = parts[1];
				UserType type = UserType.valueOf(parts[2]);
				Long id = Long.parseLong(parts[3]);
				int score = Integer.parseInt(parts[4]);
				User user =  new User(name, password);
				user.getProgress().setScore(score);
				user.setId(id);
				user.setType(type);
				this.createUser(user);
				logger.fine("Leitura do usuário: " + name + " (ID: " + id + ", Tipo: " + type + ")");
			}
		}
		catch (Exception e) {
			logger.severe("Ao tentar ler o arquivo ocorreu um erro: " + e );
		}
	}
	
	@Override
	public void write() {
		logger.info("Escrevendo no arquivo: " + this.userFile);
		File userFile = new File(this.userFile);

		try(BufferedWriter bw = new BufferedWriter(new FileWriter(userFile))){
			for(User u : this.users.values()) {
				bw.write(u.getName() + ";"
						+ u.getPassword() + ";"
						+ u.getType() + ";"
						+ u.getId() + ";"
						+ u.getProgress().getScore());
				bw.newLine();
				logger.fine("Usuário escrito: " + u.getName() + " (ID: " + u.getId() 
				+ ", Tipo: " + u.getType() + ")");
				
			}
		}
		catch (Exception e) {
			logger.severe("Ao tentar escrever no arquivo ocorreu o erro: " + e );
		}
	}
 
}
