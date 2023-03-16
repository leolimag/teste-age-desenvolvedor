package br.com.empresa.projeto.action.examefuncionario;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import br.com.empresa.projeto.business.ExameFuncionarioBusiness;
import br.com.empresa.projeto.exception.AdicionaExameException;
import br.com.empresa.projeto.model.ExameFuncionario;

@Action("editaRegistro")
public class EditaRegistroAction implements ServletRequestAware, ServletResponseAware {
	
	private ExameFuncionario exameFuncionario = new ExameFuncionario();
	private ExameFuncionarioBusiness business = new ExameFuncionarioBusiness();
	private Integer idExame;
	private Integer idFuncionario;
	private String data;
	private String dataAntiga;
	private String mensagem;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public String execute() throws SQLException {
		HttpSession session = request.getSession();
		if (session.getAttribute("usuarioLogado") != null) {
			exameFuncionario.setIdExame(idExame);
			exameFuncionario.setIdFuncionario(idFuncionario);
			exameFuncionario.setData(data);
			try {
				business.update(exameFuncionario, getDataAntiga());
			} catch (AdicionaExameException e) {
				setMensagem(e.getMessage());
				return "error";
			}
			return "success";
		} else {
			return "failed";
		}
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
	
	public String getDataAntiga() {
		return this.dataAntiga;
	}

	public void setDataAntiga(String dataAntiga) {
		this.dataAntiga = dataAntiga;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}
	
}
