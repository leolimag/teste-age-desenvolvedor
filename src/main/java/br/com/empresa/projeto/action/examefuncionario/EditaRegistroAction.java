package br.com.empresa.projeto.action.examefuncionario;

import java.sql.SQLException;
import java.time.LocalDate;

import org.apache.struts2.convention.annotation.Action;

import br.com.empresa.projeto.business.ExameFuncionarioBusiness;
import br.com.empresa.projeto.exception.AdicionaExameException;
import br.com.empresa.projeto.model.ExameFuncionario;

@Action("editaRegistro")
public class EditaRegistroAction {
	
	private ExameFuncionario exameFuncionario = new ExameFuncionario();
	private ExameFuncionarioBusiness business = new ExameFuncionarioBusiness();
	private Integer idExame;
	private Integer idFuncionario;
	private String data;
	private String dataAntiga;
	private String mensagem;

	public String execute() throws SQLException {
		exameFuncionario.setIdExame(idExame);
		exameFuncionario.setIdFuncionario(idFuncionario);
		exameFuncionario.setData(formatData(data));
		try {
			business.update(exameFuncionario, getDataAntiga());
		} catch (AdicionaExameException e) {
			setMensagem(e.getMessage());
			return "error";
		}
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
	
	public ExameFuncionario getExameFuncionario() {
		return exameFuncionario;
	}

	public void setExameFuncionario(ExameFuncionario exameFuncionario) {
		this.exameFuncionario = exameFuncionario;
	}
	
	public LocalDate getDataAntiga() {
		return formatData(dataAntiga);
	}

	public void setDataAntiga(String dataAntiga) {
		this.dataAntiga = dataAntiga;
	}

	public LocalDate formatData(String data) {
		LocalDate dataNova = LocalDate.parse(data);
		return dataNova;
	}
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
