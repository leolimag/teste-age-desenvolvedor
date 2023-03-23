package br.com.empresa.projeto.business;

import java.sql.SQLException;
import java.util.List;

import br.com.empresa.projeto.dao.ExameDAO;
import br.com.empresa.projeto.exception.DeletaExameException;
import br.com.empresa.projeto.exception.InsereExameException;
import br.com.empresa.projeto.model.Exame;
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
		Exame ex = this.dao.findByName(exame.getNome());
		if (ex != null) {
			throw new InsereExameException("Já há registrado um exame com este nome.");
		}
		this.dao.insert(exame);
	}
	
	public void update(Exame exame) throws SQLException {
		this.dao.update(exame);
	}
	
	public void delete(Exame exame) throws SQLException {
		ExameFuncionarioBusiness business =  new ExameFuncionarioBusiness();
		List<ExameFuncionario> exameFuncionarios = business.getByIdExame(exame.getId());
		if (exameFuncionarios.size() > 0) {
			throw new DeletaExameException("Não é possível apagar este exame, pois já foi realizado por um funcionário.");
		}
		this.dao.delete(exame);
	}

}
