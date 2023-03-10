package br.com.empresa.projeto.business;

import java.sql.SQLException;
import java.util.List;

import br.com.empresa.projeto.exception.DeletaExameException;
import br.com.empresa.projeto.model.Exame;
import br.com.empresa.projeto.model.ExameDAO;
import br.com.empresa.projeto.model.ExameFuncionario;

public class ExameBusiness {
	
	private ExameDAO dao;

	public ExameBusiness() {
		this.dao = new ExameDAO();
	} 
	
	public List<Exame> getAll() throws SQLException{
		return this.dao.findAll();
	}
	
	public Exame getById(Integer id) throws SQLException{
		return this.dao.findById(id);
	}
	
	public void insert(Exame exame) throws SQLException {
		this.dao.insert(exame);
	}
	
	public void update(Exame exame) throws SQLException {
		this.dao.update(exame);
	}
	
	public void delete(Exame exame) throws SQLException {
		ExameFuncionarioBusiness business =  new ExameFuncionarioBusiness();
		List<ExameFuncionario> examefuncionarios = business.getAll();
		examefuncionarios.forEach(ef -> {
			if(ef.getIdExame() == exame.getId()) {
				throw new DeletaExameException("Não é possível apagar este exame, pois já foi realizado por um funcionário.");
			}
		});
		this.dao.delete(exame);
	}

}
