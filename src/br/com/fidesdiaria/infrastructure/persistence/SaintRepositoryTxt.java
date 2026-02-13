package br.com.fidesdiaria.infrastructure.persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import br.com.fidesdiaria.domain.model.Saint;
import br.com.fidesdiaria.domain.repository.SaintRepository;

public class SaintRepositoryTxt implements SaintRepository{
	public final Map<Long, Saint> saints;
	
	public SaintRepositoryTxt(Map<Long, Saint> saints) {
		this.saints = saints;
	}
	@Override
	public void creatDaySaint(Saint saint) {
		this.saints.put(saint.getId(), saint);
	}
	
	@Override
	public List<Saint> findAll(){
		return new ArrayList<>(this.saints.values());
	}
}
