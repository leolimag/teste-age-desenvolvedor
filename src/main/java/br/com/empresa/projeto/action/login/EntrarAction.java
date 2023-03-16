package br.com.empresa.projeto.action.login;

import org.apache.struts2.convention.annotation.Action;

@Action("entrar")
public class EntrarAction {
	
	public String execute() {
		return "success";
	}

}
