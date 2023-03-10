package br.com.empresa.projeto.action.examefuncionario;

import org.apache.struts2.convention.annotation.Action;

import br.com.empresa.projeto.model.ExameFuncionario;

@Action("selecionaRegistro")
public class SelecionaRegistroAction {
	
	private ExameFuncionario exameFuncionario = new ExameFuncionario();
	private Integer idExame;
	private Integer idFuncionario;
	private String data;
	
	public String execute() {
		return "success";
	}

	public ExameFuncionario getExameFuncionario() {
		return exameFuncionario;
	}

	public void setExameFuncionario(ExameFuncionario exameFuncionario) {
		this.exameFuncionario = exameFuncionario;
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
