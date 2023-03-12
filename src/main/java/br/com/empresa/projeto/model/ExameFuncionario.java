package br.com.empresa.projeto.model;

public class ExameFuncionario {
	
	private Integer idExame;
	private Integer idFuncionario;
	private String data;
	private String nomeFuncionario;
	private String descricao;
	
	public ExameFuncionario() {
	}
	
	public ExameFuncionario(Integer idExame, Integer idFuncionario, String data) {
		this.idExame = idExame;
		this.idFuncionario = idFuncionario;
		this.data = data;
	}
	
	public ExameFuncionario(Integer idExame, Integer idFuncionario, String data, String nomeFuncionario, String descricao) {
		this.idExame = idExame;
		this.idFuncionario = idFuncionario;
		this.data = data;
		this.nomeFuncionario = nomeFuncionario;
		this.descricao = descricao;
	}
	
	public Integer getIdExame() {
		return idExame;
	}
	
	public void setIdExame(Integer idExame) {
		this.idExame = idExame;
	}
	
	public Integer getIdFuncionario() {
		return idFuncionario;
	}
	
	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return "ExameFuncionario [idExame=" + idExame + ", idFuncionario=" + idFuncionario + ", data=" + data
				+ ", nomeFuncionario=" + nomeFuncionario + ", descricao=" + descricao + "]";
	}

}
