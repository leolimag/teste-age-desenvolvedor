package br.com.empresa.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.empresa.projeto.connection.ConnectionFactory;
import br.com.empresa.projeto.model.Funcionario;

public class FuncionarioDAO {
	
	private Connection con;	
	private ConnectionFactory connectionFactory;
	
	public FuncionarioDAO() {
		this.connectionFactory = new ConnectionFactory();
		this.con = connectionFactory.getConnection();
	}
	
	public void insert(Funcionario funcionario) throws SQLException {
		if (this.con.isClosed()) {
			this.con = connectionFactory.getConnection();
		}
		this.con.setAutoCommit(false);
		try (PreparedStatement ps = this.con.prepareStatement("insert into funcionarios (nome) values (?) ")){
			ps.setString(1, funcionario.getNome());
			ps.execute();
			this.con.commit();
			this.con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public List<Funcionario> findAll() throws SQLException {
		if (this.con.isClosed()) {
			this.con = connectionFactory.getConnection();
		}
		List<Funcionario> list = new ArrayList<>();
		this.con.setAutoCommit(false);
		try (PreparedStatement ps = this.con.prepareStatement("select * from funcionarios")){
			ps.execute();
			this.con.commit();
			try(ResultSet result = ps.getResultSet()){
				while(result.next()) {
					Funcionario funcionario = new Funcionario(result.getInt("id"), result.getString("nome"));
					list.add(funcionario);
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
	
	public Funcionario findById(Integer id) throws SQLException {
		if (this.con.isClosed()) {
			this.con = connectionFactory.getConnection();
		}
		this.con.setAutoCommit(false);
		Funcionario funcionario = null;
		try (PreparedStatement ps = this.con.prepareStatement("select * from funcionarios where id = ?")){
			ps.setInt(1, id);
			ps.execute();
			this.con.commit();
			try(ResultSet result = ps.getResultSet()){
				while(result.next()) {
					funcionario = new Funcionario(result.getInt("id"), result.getString("nome"));
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			this.con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return funcionario;
	}
	
	public void update(Funcionario funcionario) throws SQLException {
		if (this.con.isClosed()) {
			this.con = connectionFactory.getConnection();
		}
		this.con.setAutoCommit(false);
		try(PreparedStatement ps = this.con.prepareStatement("update funcionarios set nome = ? where id = ?")) {
			ps.setString(1, funcionario.getNome());
			ps.setInt(2, funcionario.getId());
			ps.execute();
			this.con.commit();
			this.con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void delete(Funcionario funcionario) throws SQLException {
		if (this.con.isClosed()) {
			this.con = connectionFactory.getConnection();
		}
		this.con.setAutoCommit(false);
		try(PreparedStatement ps = this.con.prepareStatement("delete from funcionarios where id = ?")) {
			ps.setInt(1, funcionario.getId());
			ps.execute();
			this.con.commit();
			this.con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
