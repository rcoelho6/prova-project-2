package prova.project2.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "ClientService", targetNamespace = "http://service.project2.prova/")
public interface ClientService {
	
	@WebMethod(operationName = "addClient", action = "urn:AddClient")
	public String addClient(@WebParam(name = "json") String json);
	
	@WebMethod(operationName = "updateClient", action = "urn:UpdateClient")
	public String updateClient(@WebParam(name = "json") String json);
	
	@WebMethod(operationName = "deleteClient", action = "urn:DeleteClient")
	public String deleteClient(@WebParam(name = "json") String json);
	
	@WebMethod(operationName = "addCampnhaClient", action = "urn:AddCampnhaClient")
	public String addCampnhaClient(@WebParam(name = "json") String json);
	
	@WebMethod(operationName = "getClientCampanhas", action = "urn:GetClientCampanhas")
	public String getClientCampanhas(@WebParam(name = "json") String json);
	
	@WebMethod(operationName = "getPossibleCampanhas", action = "urn:GetPossibleCampanhas")
	public String getPossibleCampanhas(@WebParam(name = "json") String json);
	
}
