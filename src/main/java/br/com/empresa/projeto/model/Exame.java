package br.com.empresa.projeto.model;

public class Exame {
	
	private Integer id;
	private String nome;
	
	public Exame(Integer id, String nome) {
		this.nome = nome;
		this.id = id;
	}
	public Exame(String nome) {
		this.nome = nome;
	}
	public Exame() {
		
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
		return "Exame [id=" + id + ", nome=" + nome + "]";
	}
	
}
