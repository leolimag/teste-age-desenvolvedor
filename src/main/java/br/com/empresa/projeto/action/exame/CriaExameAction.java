package br.com.empresa.projeto.action.exame;

import java.sql.SQLException;

import org.apache.struts2.convention.annotation.Action;

@Action("criaExame")
public class CriaExameAction {
	
	public String execute() throws SQLException {
		return "success";
	}
}
