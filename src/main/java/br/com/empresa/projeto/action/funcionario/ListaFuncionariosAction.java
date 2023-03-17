package br.com.empresa.projeto.action.funcionario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import br.com.empresa.projeto.business.FuncionarioBusiness;
import br.com.empresa.projeto.model.Funcionario;

@Action("funcionarios")
public class ListaFuncionariosAction implements ServletRequestAware, ServletResponseAware {
	
	private FuncionarioBusiness business = new FuncionarioBusiness(); 
	private List<Funcionario> funcionarios = new ArrayList<>();
	private HttpServletRequest request;
	private HttpServletResponse response;
	@SuppressWarnings("unused")
	private Integer numeroFuncionarios;
	
	public String execute() throws SQLException {
		HttpSession session = request.getSession();
		if (session.getAttribute("usuarioLogado") != null) {
			funcionarios.addAll(business.getAll());
			return "success";
		} else {
			return "failed";
		}
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
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

	public Integer getNumeroFuncionarios() {
		return funcionarios.size();
	}

	public void setNumeroFuncionarios(Integer numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}
	
}
