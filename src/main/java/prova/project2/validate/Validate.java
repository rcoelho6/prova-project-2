package prova.project2.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prova.project2.dao.ClientDAO;
import prova.project2.model.Client;

@Service
public class Validate {
	
	@Autowired
	ClientDAO dao;
	
	public boolean validateEmail(Client client){
		return (dao.retrieveByEmail(client.getEmail()).size()==0);
	}
	
}
