package br.com.empresa.projeto.action.relatorio;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.itextpdf.text.Document;

import br.com.empresa.projeto.business.ExameFuncionarioBusiness;
import br.com.empresa.projeto.model.ExameFuncionario;

@Action("gerarRelatorio")
public class GerarRelatorioAction implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private ExameFuncionarioBusiness business = new ExameFuncionarioBusiness();
	private List<ExameFuncionario> exameFuncionarios = new ArrayList<>();
	private String tipo;
	private String dataInicial;
	private String dataFinal;

	public String execute() throws SQLException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("usuarioLogado") != null) {
			exameFuncionarios.addAll(business.getByData(dataInicial, dataFinal));
			if (exameFuncionarios.size() == 0) {
				return "empty";
			}
			if (tipo.equals("pdf")) {
				generatePdf();
			} else if (tipo.equals("html")) {
				return "html";
			}
			return "error";
		} else {
			return "failed";
		}
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<ExameFuncionario> getExameFuncionarios() {
		return exameFuncionarios;
	}

	public void setExameFuncionarios(List<ExameFuncionario> exameFuncionarios) {
		this.exameFuncionarios = exameFuncionarios;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getServletRequest() {
		return request;
	}

	public HttpServletResponse getServletResponse() {
		return response;
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

	private void generatePdf() throws SQLException {
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "inline; filename=" + "relatorio.pdf");
		RelatorioPDF pdf = new RelatorioPDF();
		Document documento = new Document();
		pdf.generate(documento, response, exameFuncionarios);
	}

}
