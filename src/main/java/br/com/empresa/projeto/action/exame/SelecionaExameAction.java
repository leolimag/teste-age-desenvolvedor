package br.com.empresa.projeto.action.exame;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import br.com.empresa.projeto.business.ExameBusiness;
import br.com.empresa.projeto.model.Exame;

@Action("selecionaExame")
public class SelecionaExameAction implements ServletRequestAware, ServletResponseAware {
	
	private ExameBusiness business = new ExameBusiness();
	private Exame exame = new  Exame();	
	private Integer id;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public String execute() throws SQLException {
		HttpSession session = request.getSession();
		if (session.getAttribute("usuarioLogado") != null) {
			exame = business.getById(id);
			return "success";
		} else {
			return "failed";
		}
	}
	
	public Exame getExame() {
		return this.exame;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
