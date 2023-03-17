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

import br.com.empresa.projeto.business.ExameBusiness;
import br.com.empresa.projeto.model.Exame;

@Action("exames")
public class ListaExamesAction implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private ExameBusiness business = new ExameBusiness();
	private List<Exame> exames = new ArrayList<>();
	@SuppressWarnings("unused")
	private Integer numeroExames;

	public String execute() throws SQLException {
		HttpSession session = request.getSession();
		if (session.getAttribute("usuarioLogado") != null) {
			exames.addAll(business.getAll());
			return "success";
		} else {
			return "failed";
		}
	}

	public List<Exame> getExames() {
		return this.exames;
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

	public Integer getNumeroExames() {
		return exames.size();
	}

	public void setNumeroExames(Integer numeroExames) {
		this.numeroExames = numeroExames;
	}

}
