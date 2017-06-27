package prova.project2.service;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import prova.project2.dao.ClientDAO;
import prova.project2.model.Client;
import prova.project2.parse.PJsonReader;
import prova.project2.parse.PJsonWriter;
import prova.project2.validate.Validate;

/**
 * 
 * Efective service class, the json is read or write with auxliar class inside this project
 * 
 * @author rcoelho
 *
 */
@WebService(targetNamespace = "http://service.project2.prova/", endpointInterface = "prova.project2.service.ClientService", portName = "ClientServiceImplPort", serviceName = "ClientServiceImplService")
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	Validate validate;
	
	@Autowired
	ClientDAO dao;
	
	@Autowired
	CampanhaWSService campanha;
	
	@Override
	public String addClient(String json) {
		PJsonReader reader = new PJsonReader(json);
		Client client = reader.getParsedClient();
		String result;
		if (validate.validateEmail(client)) {
			int id = dao.create(client);
			client.setClientId(id);
			result = "OK";
		}else{
			result = "E-mail alread exists";
		}		
		
		return (new PJsonWriter()).getParsedClient(client,result);
	}

	@Override
	public String updateClient(String json) {
		PJsonReader reader = new PJsonReader(json);
		Client client = reader.getParsedClient();
		String result;
		if (validate.validateEmail(client)) {
			dao.update(client);
			result = "OK";
		}else{
			result = "E-mail alread exists";
		}
		return (new PJsonWriter()).getParsedClient(client,result);
	}

	@Override
	public String deleteClient(String json) {
		PJsonReader reader = new PJsonReader(json);
		Client client = reader.getParsedClient();
		dao.delete(client);
		return (new PJsonWriter()).getParsedClient(client,"OK");		
	}
	
	public String addCampnhaClient(String json){
		PJsonReader reader = new PJsonReader(json);
		Client client = reader.getParsedClient();
		dao.addCampanha(client);
		return (new PJsonWriter()).getParsedClient(client,"OK");				
	}
	
	@Override
	public String getClientCampanhas(String json) {
		return campanha.getClientCampanhas(json);
	}
	
	@Override
	public String getPossibleCampanhas(String json) {
		return campanha.getPossibleCampanhas(json);
	}
	
	

}
