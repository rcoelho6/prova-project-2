package prova.project2.parse;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

import prova.project2.model.Client;

/**
 * Write the json to comunicate between endpoints. It use the default client model there contains in this project
 * 
 * 
 * 
 * @author rcoelho
 *
 */
public class PJsonWriter {
	JsonObjectBuilder objectBuilder;
	
	public PJsonWriter() {
		this.objectBuilder = Json.createObjectBuilder();
	}
	
	private boolean isBuilderSet() {
		return (this.objectBuilder!=null);
	}
	
	public void setInt(String key, Integer value) {
		if (isBuilderSet()) {
			this.objectBuilder.add(key,value);
		}else{
			System.out.println("Json paser not created");
		}
	}
	
	public void setString(String key, String value) {
		if (isBuilderSet()) {
			this.objectBuilder.add(key,value);
		}else{
			System.out.println("Json paser not created");
		}
	}
	
	public void setDate(String key, Date value) {
		if (isBuilderSet()) {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			this.objectBuilder.add(key,format.format(value));
		}else{
			System.out.println("Json paser not created");
		}
	}
	
	public String getJson() {
		if (isBuilderSet()) {
			return this.objectBuilder.build().toString();
		}else{
			System.out.println("Json paser not created");
		}
		return null;
	}
	
	/**
	 * The main method that generate the json
	 * 
	 * @param client
	 * @return
	 */
	public String getParsedClient(Client client){
		return this.getParsedClient(client,null);
	}
	
	/**
	 * 
	 * The main method that generate the json, to call the method is not necessary to send returnMsg
	 * 
	 * @param client
	 * @param returnMsg
	 * @return
	 */
	public String getParsedClient(Client client,String returnMsg){
		this.setInt("clientId",client.getClientId());
		this.setString("email",client.getEmail());
		this.setString("idteam",client.getIdteam());
		this.setString("name",client.getName());
		this.setDate("nascimento",client.getNascimento());
		this.setInt("campanhaId",client.getCampanhaId());
		this.setString("returnMsg",returnMsg);
		
		return this.getJson();
	}
}