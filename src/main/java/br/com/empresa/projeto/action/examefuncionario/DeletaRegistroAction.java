package br.com.empresa.projeto.action.examefuncionario;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import br.com.empresa.projeto.business.ExameFuncionarioBusiness;
import br.com.empresa.projeto.model.ExameFuncionario;

@Action("deletaRegistro")
public class DeletaRegistroAction implements ServletRequestAware, ServletResponseAware {
	
	private Integer idExame;
	private Integer idFuncionario;
	private String data;
	private ExameFuncionarioBusiness business = new ExameFuncionarioBusiness();
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public String execute() throws SQLException {
		HttpSession session = request.getSession();
		if (session.getAttribute("usuarioLogado") != null) {
			ExameFuncionario exameFuncionario = new ExameFuncionario(idExame, idFuncionario, data);
			business.delete(exameFuncionario);
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
