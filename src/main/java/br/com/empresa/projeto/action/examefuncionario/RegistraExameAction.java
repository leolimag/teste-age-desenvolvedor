package br.com.empresa.projeto.action.examefuncionario;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import br.com.empresa.projeto.business.ExameFuncionarioBusiness;
import br.com.empresa.projeto.exception.AdicionaExameException;
import br.com.empresa.projeto.model.ExameFuncionario;

@Action("registraExame")
public class RegistraExameAction implements ServletRequestAware, ServletResponseAware {
	
	private ExameFuncionarioBusiness efBusiness = new ExameFuncionarioBusiness();
	private ExameFuncionario exameFuncionario = new ExameFuncionario();
	private Integer exame;
	private Integer funcionario;
	private String data;
	private String mensagem;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public String execute() throws SQLException {
		HttpSession session = request.getSession();
		if (session.getAttribute("usuarioLogado") != null) {
			exameFuncionario.setIdExame(exame);
			exameFuncionario.setIdFuncionario(funcionario);
			exameFuncionario.setData(data);
			try {
				efBusiness.insert(exameFuncionario);
			} catch (AdicionaExameException e) {
				setMensagem(e.getMessage());
				return "error";
			}
			return "success";
		} else {
			return "failed";
		}
	}

	public Integer getExame() {
		return exame;
	}

	public void setExame(Integer exame) {
		this.exame = exame;
	}

	public Integer getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Integer funcionario) {
		this.funcionario = funcionario;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
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
