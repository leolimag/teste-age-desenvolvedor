package br.com.empresa.projeto.action.relatorio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

@Action("relatorio")
public class CriarRelatorioAction implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;

	public String execute() {
		HttpSession session = request.getSession();
		if (session.getAttribute("usuarioLogado") != null) {
			return "success";
		} else {
			return "failed";
		}
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
