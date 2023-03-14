package br.com.empresa.projeto.action.relatorio;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	private String anoInicial;
	private String anoFinal;
	
	public String execute() throws SQLException, IOException {
		exameFuncionarios.addAll(business.getByData(anoInicial, anoFinal));
		
		if (exameFuncionarios.size() == 0) {
			return "empty";
		}
		
		if (tipo.equals("pdf")) {
			generatePdf();
		} else if (tipo.equals("html")) {
			return "html";
		} else if (tipo.equals("excel")){
			generateExcel();
		}
		return "error";
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

	public String getAnoInicial() {
		return anoInicial;
	}

	public void setAnoInicial(String anoInicial) {
		this.anoInicial = anoInicial;
	}

	public String getAnoFinal() {
		return anoFinal;
	}

	public void setAnoFinal(String anoFinal) {
		this.anoFinal = anoFinal;
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
	
	private void generatePdf() throws SQLException {
		RelatorioPDF pdf = new RelatorioPDF();
		Document documento = new Document();
		pdf.generate(documento, this.getServletResponse(), exameFuncionarios);
	}

	private void generateExcel() throws SQLException, IOException {
		RelatorioExcel excel = new RelatorioExcel();
		excel.generate(business);
	}

	
}
