package br.com.empresa.projeto.action.exame;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import br.com.empresa.projeto.business.ExameBusiness;
import br.com.empresa.projeto.model.Exame;

@Action("exames")
public class ListaExamesAction {
	
	private ExameBusiness business = new ExameBusiness();
	private List<Exame> exames = new ArrayList<>();
	
	public String execute() throws SQLException {
		exames.addAll(business.getAll());
		return "success";
	}
	
	public List<Exame> getExames() {
		return this.exames;
	}
	

}
