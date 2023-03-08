package br.com.empresa.projeto.action.funcionario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import br.com.empresa.projeto.business.FuncionarioBusiness;
import br.com.empresa.projeto.model.Funcionario;

@Action("funcionarios")
public class ListaFuncionariosAction{
	
	private FuncionarioBusiness business = new FuncionarioBusiness(); 
	private List<Funcionario> funcionarios = new ArrayList<>();
	
	public String execute() throws SQLException {
		funcionarios.addAll(business.getAll());
		return "success";
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
}
