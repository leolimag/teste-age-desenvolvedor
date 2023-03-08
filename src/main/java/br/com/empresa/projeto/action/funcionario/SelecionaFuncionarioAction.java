package br.com.empresa.projeto.action.funcionario;

import java.sql.SQLException;

import org.apache.struts2.convention.annotation.Action;

import br.com.empresa.projeto.business.FuncionarioBusiness;
import br.com.empresa.projeto.model.Funcionario;

@Action("selecionaFuncionario")
public class SelecionaFuncionarioAction {
	
	private FuncionarioBusiness business = new FuncionarioBusiness();
	private Funcionario funcionario = new  Funcionario();	
	private Integer id;
	
	public String execute() throws SQLException {
		funcionario = business.getById(id);
		return "success";
	}
	
	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
