package br.com.empresa.projeto.business;

import java.sql.SQLException;
import java.util.List;

import br.com.empresa.projeto.dao.UsuarioDAO;
import br.com.empresa.projeto.model.Usuario;

public class UsuarioBusiness {
	
	private UsuarioDAO dao;

	public UsuarioBusiness() {
		this.dao = new UsuarioDAO();
	}
	
	public List<Usuario> getAll() throws SQLException{
		return this.dao.findAll();
	}
	
	public Usuario auth(List<Usuario> usuarios, String email, String senha) throws SQLException {
		for (Usuario usuario : usuarios) {
			if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
				return usuario;
			}
		}
		return null;
	}

	public void insert(Usuario usuario) throws SQLException {
		this.dao.insert(usuario);
	}
}
