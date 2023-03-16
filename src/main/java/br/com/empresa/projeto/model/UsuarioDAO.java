package br.com.empresa.projeto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.empresa.projeto.connection.ConnectionFactory;

public class UsuarioDAO {
	
	private Connection con;	
	private ConnectionFactory connectionFactory;
	
	public UsuarioDAO() {
		this.connectionFactory = new ConnectionFactory();
		this.con = connectionFactory.getConnection();
	}
	
	public List<Usuario> findAll() throws SQLException {
		if (this.con.isClosed()) {
			this.con = connectionFactory.getConnection();
		}
		List<Usuario> list = new ArrayList<>();
		this.con.setAutoCommit(false);
		try (PreparedStatement ps = this.con.prepareStatement("select * from usuarios")){
			ps.execute();
			this.con.commit();
			try(ResultSet result = ps.getResultSet()){
				while(result.next()) {
					Usuario usuario = new Usuario(result.getInt("id"), result.getString("email"), result.getString("senha"));
					list.add(usuario);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			this.con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	public void insert(Usuario usuario) throws SQLException {
		if (this.con.isClosed()) {
			this.con = connectionFactory.getConnection();
		}
		this.con.setAutoCommit(false);
		try (PreparedStatement ps = this.con.prepareStatement("insert into usuarios (email, senha) values (?, ?) ")){
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getSenha());
			ps.execute();
			this.con.commit();
			this.con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
