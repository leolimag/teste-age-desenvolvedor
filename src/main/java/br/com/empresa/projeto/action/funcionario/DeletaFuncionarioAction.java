package br.com.empresa.projeto.action.funcionario;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import br.com.empresa.projeto.business.FuncionarioBusiness;
import br.com.empresa.projeto.model.Funcionario;

@Action("deletaFuncionario")
public class DeletaFuncionarioAction implements ServletRequestAware, ServletResponseAware {
	
	private FuncionarioBusiness business = new FuncionarioBusiness();
	private Funcionario funcionario = new Funcionario();
	private Integer id;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public String execute() throws SQLException {
		HttpSession session = request.getSession();
		if (session.getAttribute("usuarioLogado") != null) {
			funcionario.setId(id);
			business.delete(funcionario);
			return "success";
		} else {
			return "failed";
		}
	}	
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario  = funcionario;
	}
	
	public Integer getId() {
		return this.id;
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
