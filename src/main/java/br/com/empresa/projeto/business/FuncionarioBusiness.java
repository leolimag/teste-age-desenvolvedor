package br.com.empresa.projeto.business;

import java.sql.SQLException;
import java.util.List;

import br.com.empresa.projeto.model.Funcionario;
import br.com.empresa.projeto.model.FuncionarioDAO;

public class FuncionarioBusiness {
	
	private FuncionarioDAO dao;

	public FuncionarioBusiness() {
		this.dao = new FuncionarioDAO();
	} 
	
	public List<Funcionario> getAll() throws SQLException{
		return this.dao.findAll();
	}
	
	public Funcionario getById(Integer id) throws SQLException{
		return this.dao.findById(id);
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
