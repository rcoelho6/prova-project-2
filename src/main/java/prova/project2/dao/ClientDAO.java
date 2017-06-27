package prova.project2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import prova.project2.model.Client;

@Repository
public class ClientDAO {
	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;

	private String CREATE = "insert into client values (?,?,?,?,?);";
	private String DELETE = "delete from client where clientId = ?";
	private String RETRIEVE = "select clientId, name, email, nascimento, idTeam from client";
	private String UPDATE = "update client"+
							"   set name = ?"+
							"     , email = ?"+
							"     , nascimento = ?"+
							"     , idTeam = ?"+
							" where clientID = ?";
	private String ADDCAMPANHA = "insert into cliente_campanha values (?,?);";
								
	/* Because the new version of MySQL doens´t work well with sequences*/
	private String NEXT = "select max(clientId)+1 nextval from client";
	
	@PostConstruct
	private void setJdbcTemplate() {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private Integer getNextClientId() {
		String sql = this.NEXT;
		return jdbcTemplate.query(sql,new NextvalMapper()).get(0);
	}
	
	public Integer create(Client client){
		String sql = this.CREATE;
		Integer newId = getNextClientId();
		jdbcTemplate.update(sql,newId,client.getName(),client.getEmail(),client.getNascimento(),client.getIdteam());
		return newId;
	}
	
	public void addCampanha(Client client){
		String sql = this.ADDCAMPANHA;
		jdbcTemplate.update(sql,client.getClientId(),client.getCampanhaId());
	}
	
	public Client retrieve(Integer clientId){
		String sql = this.RETRIEVE+" where campanhaId = ?";
		Client client = jdbcTemplate.query(sql, new Object[]{clientId}, new ClientMapper()).get(0);
		return client;
	}
	
	public List<Client> retrieveByEmail(String email){
		String sql = this.RETRIEVE+" where email = ?";
		List<Client> client = jdbcTemplate.query(sql, new Object[]{email}, new ClientMapper());
		return client;
	}
	
	public void update(Client client){
		String sql = this.UPDATE;
		jdbcTemplate.update(sql,client.getName(),client.getEmail(),client.getNascimento(),client.getIdteam(),client.getClientId());
	}
	
	public void delete(Client client){
		String sql = this.DELETE;
		jdbcTemplate.update(sql,client.getClientId());
	}
	
	
	
	public class NextvalMapper implements RowMapper<Integer> {
		public Integer mapRow(ResultSet rs, int rownum) throws SQLException {
			return rs.getInt("nextval");
		}
	}
	
	public class ClientMapper implements RowMapper<Client> {
		public Client mapRow(ResultSet rs, int rownum) throws SQLException {
			Client client = new Client();
			client.setClientId(rs.getInt("clientId"));
			client.setEmail(rs.getString("email"));
			client.setIdteam(rs.getString("idTeam"));
			client.setName(rs.getString("name"));
			client.setNascimento(rs.getDate("nascimento"));
			return client;
		}
	}
}
