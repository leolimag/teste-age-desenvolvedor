package br.com.empresa.projeto.action.relatorio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import br.com.empresa.projeto.business.ExameFuncionarioBusiness;
import br.com.empresa.projeto.model.ExameFuncionario;

@Action("gerarRelatorio")
public class GerarRelatorioAction {
	
	private ExameFuncionarioBusiness business = new ExameFuncionarioBusiness();
	private List<ExameFuncionario> exameFuncionarios = new ArrayList<>();
	private String tipo;
	
	public String execute() throws SQLException {
		exameFuncionarios.addAll(business.getAll());
		if (tipo.equals("pdf")) {
			return "pdf";
		} else if (tipo.equals("html")) {
			return "html";
		} else if (tipo.equals("excel")){
			return "excel";
		}
		return "error";
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<ExameFuncionario> getExameFuncionarios() {
		return exameFuncionarios;
	}

	public void setExameFuncionarios(List<ExameFuncionario> exameFuncionarios) {
		this.exameFuncionarios = exameFuncionarios;
	}
	
}
