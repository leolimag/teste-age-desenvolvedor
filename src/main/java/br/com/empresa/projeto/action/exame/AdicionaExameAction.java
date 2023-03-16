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

@Action("adicionaExame")
public class AdicionaExameAction implements ServletRequestAware, ServletResponseAware {

	private ExameBusiness business = new ExameBusiness();
	private Exame exame = new Exame();
	private String nome;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public String execute() throws SQLException {
		HttpSession session = request.getSession();
		if (session.getAttribute("usuarioLogado") != null) {
			exame.setNome(nome);
			business.insert(exame);
			return "success";
		} else {
			return "failed";
		}
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
