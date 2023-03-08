package br.com.empresa.projeto.action.funcionario;

import java.sql.SQLException;

import org.apache.struts2.convention.annotation.Action;

import br.com.empresa.projeto.business.FuncionarioBusiness;
import br.com.empresa.projeto.model.Funcionario;

@Action("deletaFuncionario")
public class DeletaFuncionarioAction {
	
	private FuncionarioBusiness business = new FuncionarioBusiness();
	private Funcionario funcionario = new Funcionario();
	private Integer id;
	
	public String execute() throws SQLException {
		funcionario.setId(id);
		business.delete(funcionario);
		return "success";
	}	
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario  = funcionario;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

}
