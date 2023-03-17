package br.com.empresa.projeto.action.exame;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import br.com.empresa.projeto.business.ExameFuncionarioBusiness;
import br.com.empresa.projeto.model.ExameFuncionario;

@Action("examesFuncionarios")
public class ListaExamesFuncionariosAction implements ServletRequestAware, ServletResponseAware {
	
	private ExameFuncionarioBusiness business = new ExameFuncionarioBusiness();
	private List<ExameFuncionario> exameFuncionarios = new ArrayList<>();
	private HttpServletRequest request;
	private HttpServletResponse response;
	@SuppressWarnings("unused")
	private Integer numeroExamesFuncionarios;
	
	public String execute() throws SQLException {
		HttpSession session = request.getSession();
		if (session.getAttribute("usuarioLogado") != null) {
			exameFuncionarios.addAll(business.getAll());
			return "success";
		} else {
			return "failed";
		}
	}

	public List<ExameFuncionario> getExameFuncionarios() {
		return exameFuncionarios;
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

	public Integer getNumeroExamesFuncionarios() {
		return exameFuncionarios.size();
	}

	public void setNumeroExamesFuncionarios(Integer numeroExamesFuncionarios) {
		this.numeroExamesFuncionarios = numeroExamesFuncionarios;
	}
	
}
