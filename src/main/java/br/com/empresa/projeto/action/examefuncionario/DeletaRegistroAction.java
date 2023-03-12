package br.com.empresa.projeto.action.examefuncionario;

import java.sql.SQLException;

import org.apache.struts2.convention.annotation.Action;

import br.com.empresa.projeto.business.ExameFuncionarioBusiness;
import br.com.empresa.projeto.model.ExameFuncionario;

@Action("deletaRegistro")
public class DeletaRegistroAction {
	
	private Integer idExame;
	private Integer idFuncionario;
	private String data;
	private ExameFuncionarioBusiness business = new ExameFuncionarioBusiness();
	
	public String execute() throws SQLException {
		ExameFuncionario exameFuncionario = new ExameFuncionario(idExame, idFuncionario, data);
		business.delete(exameFuncionario);
		return "success";
	}

	public Integer getIdExame() {
		return idExame;
	}

	public void setIdExame(Integer idExame) {
		this.idExame = idExame;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}
