package prova.project2.model;

import java.util.Date;

public class Client {
	Integer clientId;
	String name;
	String email;
	Date nascimento;
	String idteam;
	Integer CampanhaId;
	public Integer getCampanhaId() {
		return CampanhaId;
	}
	public void setCampanhaId(Integer campanhaId) {
		CampanhaId = campanhaId;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public String getIdteam() {
		return idteam;
	}
	public void setIdteam(String idteam) {
		this.idteam = idteam;
	}
}
