package br.com.empresa.projeto.model;

public class Funcionario {
	
	private Integer id;
	private String nome;
	
	public Funcionario(Integer id, String nome) {
		this.nome = nome;
		this.id = id;
	}
	public Funcionario(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Funcionário [id=" + id + ", nome=" + nome + "]";
	}
	
}
