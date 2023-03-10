package br.com.empresa.projeto.action.examefuncionario;

import java.sql.SQLException;
import java.time.LocalDate;

import org.apache.struts2.convention.annotation.Action;

import br.com.empresa.projeto.business.ExameFuncionarioBusiness;
import br.com.empresa.projeto.exception.AdicionaExameException;
import br.com.empresa.projeto.model.ExameFuncionario;

@Action("registraExame")
public class RegistraExameAction {
	
	private ExameFuncionarioBusiness efBusiness = new ExameFuncionarioBusiness();
	private ExameFuncionario exameFuncionario = new ExameFuncionario();
	private Integer exame;
	private Integer funcionario;
	private String data;
	private String mensagem;
	
	public String execute() throws SQLException {
		exameFuncionario.setIdExame(exame);
		exameFuncionario.setIdFuncionario(funcionario);
		exameFuncionario.setData(formatData());
		try {
			efBusiness.insert(exameFuncionario);
		} catch (AdicionaExameException e) {
			setMensagem(e.getMessage());
			return "error";
		}
		return "success";
	}

	public Integer getExame() {
		return exame;
	}

	public void setExame(Integer exame) {
		this.exame = exame;
	}

	public Integer getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Integer funcionario) {
		this.funcionario = funcionario;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public LocalDate formatData() {
		LocalDate dataNova = LocalDate.parse(this.data);
		return dataNova;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
