package br.com.empresa.projeto.action.login;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import br.com.empresa.projeto.business.UsuarioBusiness;
import br.com.empresa.projeto.model.Usuario;

@Action("login")
public class LoginAction implements ServletRequestAware, ServletResponseAware {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String email;
	private String senha;
	private UsuarioBusiness business = new UsuarioBusiness();
	
	public String execute() throws SQLException {
		if (business.auth(business.getAll(), email, senha) != null) {
			Usuario usuario = business.auth(business.getAll(), email, senha);
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario);
			return "success";
		}
		return "failed";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
