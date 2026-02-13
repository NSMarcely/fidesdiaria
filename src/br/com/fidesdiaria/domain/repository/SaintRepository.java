package br.com.fidesdiaria.domain.repository;
import java.util.List;
import br.com.fidesdiaria.domain.model.Saint;

public interface SaintRepository {
	void creatDaySaint(String name, int day, int month);
	
	List<Saint> findAll();
}