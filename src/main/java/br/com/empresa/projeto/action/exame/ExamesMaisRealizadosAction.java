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
import br.com.empresa.projeto.vo.ExameFuncionarioVO;

@Action("examesMaisRealizados")
public class ExamesMaisRealizadosAction implements ServletRequestAware, ServletResponseAware {

	private ExameFuncionarioBusiness business = new ExameFuncionarioBusiness();
	private List<ExameFuncionarioVO> exameFuncionarios = new ArrayList<>();
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String dataInicial;
	private String dataFinal;
	
	public String execute() throws SQLException {
		HttpSession session = request.getSession();
		if (session.getAttribute("usuarioLogado") != null) {
			exameFuncionarios.addAll(business.getFive(dataInicial, dataFinal));
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

	public List<ExameFuncionarioVO> getExameFuncionarios() {
		return exameFuncionarios;
	}

	public void setExameFuncionarios(List<ExameFuncionarioVO> exameFuncionarios) {
		this.exameFuncionarios = exameFuncionarios;
	}

	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}
	
}
