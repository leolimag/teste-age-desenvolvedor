package br.com.empresa.projeto.action.exame;

import java.sql.SQLException;

import org.apache.struts2.convention.annotation.Action;

import br.com.empresa.projeto.business.ExameBusiness;
import br.com.empresa.projeto.model.Exame;

@Action("adicionaExame")
public class AdicionaExameAction {
	
	private ExameBusiness business = new ExameBusiness();
	private Exame exame = new Exame();
	private String descricao;
	private String data;
	
	public String execute() throws SQLException {
		exame.setDescricao(descricao);
		exame.setData(data);
		business.insert(exame);
		return "success";
	}	
	
	public Exame getExame() {
		return exame;
	}
	
	public void setExame(Exame exame) {
		this.exame  = exame;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
