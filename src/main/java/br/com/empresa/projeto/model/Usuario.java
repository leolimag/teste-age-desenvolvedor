package br.com.empresa.projeto.model;

public class Usuario {
	
	private Integer id;
	private String email;
	private String senha;
	
	public Usuario(Integer id, String email, String senha) {
		this.id = id;
		this.email = email;
		this.senha = senha;
	}

	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public Usuario() {
		
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", senha=" + senha + "]";
	}
	
}
