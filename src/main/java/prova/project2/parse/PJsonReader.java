package prova.project2.parse;

import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import prova.project2.model.Client;

/**
 * 
 * Read the json sent between endpoints. It use the default client model there contains in this project
 * 
 * @author rcoelho
 *
 */
public class PJsonReader {
	
	private JsonObject personObject;
	
	
	public PJsonReader(String json) {
		if (json!=null&&!"".equals(json)) {
			JsonReader reader = Json.createReader(new StringReader(json));
			this.personObject = reader.readObject();
		}else{
			System.out.println("Json paser not created");
		}
	}
	
	private boolean isParserSet() {
		return (this.personObject!=null);
	}
	
	public Integer getInt(String key) {
		if (isParserSet()) {
			if(personObject.containsKey(key)) {
				return personObject.getInt(key);
			}else{
				return null;
			}
		}else{
			System.out.println("Json paser not created");
		}
		return null;
	}
	public String getString(String key) {
		if (isParserSet()) {
			if(personObject.containsKey(key)) {
				return personObject.getString(key);
			}else{
				return null;
			}
		}else{
			System.out.println("Json paser not created");
		}
		return null;
	}
	public Date getDate(String key) {
		if (isParserSet()) {
			try {
				if(personObject.containsKey(key)) {
					String sdate = personObject.getString(key);
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					Date date = format.parse(sdate);
					return date;
				}else{
					return null;
				}
			} catch (ParseException e) {
				System.out.println("Json date in wrong format");
				e.printStackTrace();
			}
		}else{
			System.out.println("Json paser not created");
		}
		return null;
	}

	/**
	 * Since you input a json string on the constructor of this class, it will return a model populate with json
	 * 
	 * @return
	 */
	public Client getParsedClient(){
		Client client = new Client();
		client.setClientId(this.getInt("clientId"));
		client.setEmail(this.getString("email"));
		client.setIdteam(this.getString("idteam"));
		client.setName(this.getString("name"));
		client.setNascimento(this.getDate("nascimento"));
		client.setCampanhaId(this.getInt("campanhaId"));
		return client;
	}
}

