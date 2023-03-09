package br.com.empresa.projeto.action.examefuncionario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import br.com.empresa.projeto.business.ExameBusiness;
import br.com.empresa.projeto.business.FuncionarioBusiness;
import br.com.empresa.projeto.model.Exame;
import br.com.empresa.projeto.model.Funcionario;

@Action("listaExamesFuncionarios")
public class ListaExamesFuncionariosRegistroAction {
	
	private List<Exame> exames = new ArrayList<>();
	private List<Funcionario> funcionarios = new ArrayList<>();
	private ExameBusiness eBusiness = new ExameBusiness();
	private FuncionarioBusiness fBusiness = new FuncionarioBusiness();

	
	public String execute() throws SQLException {
		exames.addAll(eBusiness.getAll());
		funcionarios.addAll(fBusiness.getAll());
		return "success";
	}

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
}
