package br.com.empresa.projeto.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.empresa.projeto.connection.ConnectionFactory;
import br.com.empresa.projeto.model.Funcionario;
import br.com.empresa.projeto.model.FuncionarioDAO;

public class FuncionarioBusiness {
	
	private FuncionarioDAO dao;
	private Connection con;

	public FuncionarioBusiness() {
		try {
			this.con = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.dao = new FuncionarioDAO(this.con);
	} 
	
	public List<Funcionario> getAll() throws SQLException{
		return this.dao.findAll();
	}
	
	public void insert(Funcionario funcionario) throws SQLException {
		this.dao.insert(funcionario);
	}
	
	public void update(Funcionario funcionario) throws SQLException {
		this.dao.update(funcionario);
	}
	
	public void delete(Funcionario funcionario) throws SQLException {
		this.dao.delete(funcionario);
	}
	
}
