package br.com.empresa.projeto.business;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import br.com.empresa.projeto.model.ExameFuncionario;
import br.com.empresa.projeto.model.ExameFuncionarioDAO;

public class ExameFuncionarioBusiness {
		
		private ExameFuncionarioDAO dao;

		public ExameFuncionarioBusiness() {
			this.dao = new ExameFuncionarioDAO();
		} 
		
		public List<ExameFuncionario> getAll() throws SQLException{
			return this.dao.findAll();
		}
		
		public ExameFuncionario getById(Integer idExame, Integer idFuncionario, LocalDate data) throws SQLException{
			return this.dao.findById(idExame, idFuncionario, data);
		}
		
		public void insert(ExameFuncionario exameFuncionario) throws SQLException {
			this.dao.insert(exameFuncionario);
		}
		
		public void update(ExameFuncionario exameFuncionario, LocalDate dataAntiga) throws SQLException {
			this.dao.update(exameFuncionario, dataAntiga);
		}
		
		public void delete(ExameFuncionario exameFuncionario) throws SQLException {
			this.dao.delete(exameFuncionario);
		}

}
