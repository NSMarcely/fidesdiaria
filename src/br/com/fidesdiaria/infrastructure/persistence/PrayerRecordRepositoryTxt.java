package br.com.fidesdiaria.infrastructure.persistence;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import br.com.fidesdiaria.domain.model.Prayer;
import br.com.fidesdiaria.domain.model.PrayerRecord;
import br.com.fidesdiaria.domain.repository.PrayerRecordRepository;

public class PrayerRecordRepositoryTxt implements PrayerRecordRepository {
	
	private final String prayerRecordFile = "prayer.txt";
	private final static Logger  logger = Logger
			.getLogger(PrayerRecordRepositoryTxt.class.getName());
	
	private final Map<Long, PrayerRecord> prayers;
	
	public PrayerRecordRepositoryTxt(Map<Long, PrayerRecord> prayers) {
		this.prayers = prayers;
	}
	
	@Override
	public void createPrayer(PrayerRecord prayerRecord) {
		this.prayers.put(prayerRecord.getPrayerId(), prayerRecord);
	}
	
	@Override
	public List<PrayerRecord> findAll(){
		return new ArrayList<>(this.prayers.values());
	}
	
	@Override
	public void read() {
		logger.info("Lendo o arquivo:" + this.prayerRecordFile);
		File prayerFile = new File(this.prayerRecordFile);
		
		if(!prayerFile.exists()) {
			logger.warning("O arquivo"+ prayerFile + "não pode ser localizado");
			return;
		}
		
		try(BufferedReader br = new BufferedReader(new FileReader(prayerFile))){
			String line;
			while((line = br.readLine())!= null) {
				String[] parts = line.split(";");
				Long userId = Long.parseLong(parts[0]);
				Long prayerId = Long.parseLong(parts[1]);
				Prayer type = Prayer.valueOf(parts[2]);
				LocalDate fulfillment = LocalDate.parse(parts[3]);
				PrayerRecord prayerRecord = new PrayerRecord(userId, type);
				prayerRecord.setPrayerId(prayerId);
				prayerRecord.setFulfillment(fulfillment);
				this.prayers.put(prayerId, prayerRecord);
			}
		}
		
		catch (Exception e) {
			logger.severe("Ao ler o arquivo ocorreu o erro:" + e);
		}
	}
	
	@Override
	public void write() {
		logger.info("Escrevendo no arquivo:" + this.prayerRecordFile);
		
		File prayerFile = new File(this.prayerRecordFile);
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(prayerFile))){
			for(PrayerRecord p : this.prayers.values()) {
				bw.write(p.getUserId() + ";" 
						+ p.getPrayerId() + ";" 
						+ p.getType() + ";"
						+ p.getFulfillment());
				bw.newLine();
				logger.fine("Oração escrita: " + p.getPrayerId() + " (ID do user: " + p.getUserId() 
				+ ", Tipo: " + p.getType() + ", Data: " + p.getFulfillment());
			}
		}
		catch (Exception e) {
			logger.severe("Ao tentar escrever no arquivo ocorreu o erro: " + e );
		}
	}
}

