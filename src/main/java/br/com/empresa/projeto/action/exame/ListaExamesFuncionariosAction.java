package br.com.empresa.projeto.action.exame;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import br.com.empresa.projeto.business.ExameFuncionarioBusiness;
import br.com.empresa.projeto.model.ExameFuncionario;

@Action("examesFuncionarios")
public class ListaExamesFuncionariosAction {
	
	private ExameFuncionarioBusiness business = new ExameFuncionarioBusiness();
	private List<ExameFuncionario> exameFuncionarios = new ArrayList<>();
	
	public String execute() throws SQLException {
		exameFuncionarios.addAll(business.getAll());
		return "success";
	}

	public List<ExameFuncionario> getExameFuncionarios() {
		return exameFuncionarios;
	}
	
}
