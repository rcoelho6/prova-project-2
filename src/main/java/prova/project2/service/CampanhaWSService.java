package prova.project2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import prova.project.service.CampanhaService;
import prova.project.service.CampanhaServiceImplService;

@Service
public class CampanhaWSService {
	
	String serviceAddress;
	
	CampanhaService service;
	
	public CampanhaWSService() {
		CampanhaServiceImplService impl = new CampanhaServiceImplService();
		this.service = impl.getCampanhaServiceImplPort();		
	}
	
	public String getPossibleCampanhas(String json) {
		return this.service.retreiveByTeam(json);
	}
	
	public String getClientCampanhas(String json) {
		return this.service.retreiveByClient(json);
	}
}
