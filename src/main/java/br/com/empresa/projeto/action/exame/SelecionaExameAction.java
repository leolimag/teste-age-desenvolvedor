package br.com.empresa.projeto.action.exame;

import java.sql.SQLException;

import org.apache.struts2.convention.annotation.Action;

import br.com.empresa.projeto.business.ExameBusiness;
import br.com.empresa.projeto.model.Exame;

@Action("selecionaExame")
public class SelecionaExameAction {
	
	private ExameBusiness business = new ExameBusiness();
	private Exame exame = new  Exame();	
	private Integer id;
	
	public String execute() throws SQLException {
		exame = business.getById(id);
		return "success";
	}
	
	public Exame getExame() {
		return this.exame;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
