package br.com.empresa.projeto.action.examefuncionario;

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
import br.com.empresa.projeto.business.FuncionarioBusiness;
import br.com.empresa.projeto.model.Exame;
import br.com.empresa.projeto.model.Funcionario;

@Action("listaExamesFuncionarios")
public class ListaExamesFuncionariosRegistroAction implements ServletRequestAware, ServletResponseAware {
	
	private List<Exame> exames = new ArrayList<>();
	private List<Funcionario> funcionarios = new ArrayList<>();
	private ExameBusiness eBusiness = new ExameBusiness();
	private FuncionarioBusiness fBusiness = new FuncionarioBusiness();
	private HttpServletRequest request;
	private HttpServletResponse response;

	
	public String execute() throws SQLException {
		HttpSession session = request.getSession();
		if (session.getAttribute("usuarioLogado") != null) {
			exames.addAll(eBusiness.getAll());
			funcionarios.addAll(fBusiness.getAll());
			return "success";
		} else {
			return "failed";
		}
	}

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
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
