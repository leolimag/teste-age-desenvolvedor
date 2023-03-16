package br.com.empresa.projeto.action.usuario;

import org.apache.struts2.convention.annotation.Action;

@Action("criaUsuario")
public class CriaUsuarioAction {
	
	private String email;
	private String senha;
	
	public String execute() {
		return "success";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
