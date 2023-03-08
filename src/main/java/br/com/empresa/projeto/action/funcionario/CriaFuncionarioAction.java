package br.com.empresa.projeto.action.funcionario;

import java.sql.SQLException;

import org.apache.struts2.convention.annotation.Action;

@Action("criaFuncionario")
public class CriaFuncionarioAction {
	
	public String execute() throws SQLException {
		return "success";
	}
}
