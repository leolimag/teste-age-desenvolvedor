package br.com.empresa.projeto.model;

public class Exame {
	
	private Integer id;
	private String descricao;
	private String data;
	
	public Exame(Integer id, String descricao, String data) {
		this.descricao = descricao;
		this.data = data;
		this.id = id;
	}
	public Exame(String descricao, String data) {
		this.descricao = descricao;
		this.data = data;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Exame [id=" + id + ", descricao=" + descricao + ", data=" + data + "]";
	}
	
}
