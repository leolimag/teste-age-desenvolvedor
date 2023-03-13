package br.com.empresa.projeto.action.exame;

import java.sql.SQLException;

import org.apache.struts2.convention.annotation.Action;

import br.com.empresa.projeto.business.ExameBusiness;
import br.com.empresa.projeto.model.Exame;

@Action("editaExame")
public class EditaExameAction {
	
	private ExameBusiness business = new ExameBusiness();
	private Exame exame = new Exame();
	private Integer id;
	private String nome;
	
	public String execute() throws SQLException {
		exame.setId(id);
		exame.setNome(nome);
		business.update(exame);
		return "success";
	}	
	
	public Exame getExame() {
		return exame;
	}
	
	public void setExame(Exame exame) {
		this.exame  = exame;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
