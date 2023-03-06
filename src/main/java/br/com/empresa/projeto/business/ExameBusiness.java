package br.com.empresa.projeto.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.empresa.projeto.connection.ConnectionFactory;
import br.com.empresa.projeto.model.Exame;
import br.com.empresa.projeto.model.ExameDAO;

public class ExameBusiness {
	
	private ExameDAO dao;
	private Connection con;

	public ExameBusiness() {
		try {
			this.con = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.dao = new ExameDAO(this.con);
	} 
	
	public List<Exame> getAll() throws SQLException{
		return this.dao.findAll();
	}
	
	public void insert(Exame exame) throws SQLException {
		this.dao.insert(exame);
	}
	
	public void update(Exame exame) throws SQLException {
		this.dao.update(exame);
	}
	
	public void delete(Exame exame) throws SQLException {
		this.dao.delete(exame);
	}
	
}
