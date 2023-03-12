package br.com.empresa.projeto.business;

import java.sql.SQLException;
import java.util.List;

import br.com.empresa.projeto.exception.AdicionaExameException;
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
		
		public ExameFuncionario getById(Integer idExame, Integer idFuncionario, String data) throws SQLException{
			return this.dao.findById(idExame, idFuncionario, data);
		}
		
		public void insert(ExameFuncionario exameFuncionario) throws SQLException {
			List<ExameFuncionario> exameFuncionarios = this.dao.findAll();
			exameFuncionarios.forEach(ef -> {
				if(ef.getData().equals(exameFuncionario.getData()) && ef.getIdFuncionario() == exameFuncionario.getIdFuncionario() && ef.getIdExame() == exameFuncionario.getIdExame()) {
					throw new AdicionaExameException("Já há um exame marcado nesta data para este funcionário. Tente novamente.");
				}
			});;
			this.dao.insert(exameFuncionario);
		}
		
		public void update(ExameFuncionario exameFuncionario, String dataAntiga) throws SQLException {
			List<ExameFuncionario> exameFuncionarios = this.dao.findAll();
			exameFuncionarios.forEach(ef -> {
				if(ef.getData().equals(exameFuncionario.getData()) && ef.getIdFuncionario() == exameFuncionario.getIdFuncionario() && ef.getIdExame() == exameFuncionario.getIdExame()) {
					throw new AdicionaExameException("Já há um exame marcado nesta data para este funcionário. Tente novamente.");
				}
			});;
			this.dao.update(exameFuncionario, dataAntiga);
		}
		
		public void delete(ExameFuncionario exameFuncionario) throws SQLException {
			this.dao.delete(exameFuncionario);
		}

}
