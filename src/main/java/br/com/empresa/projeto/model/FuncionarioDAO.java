package br.com.empresa.projeto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
	
	private Connection con;	
	
	public FuncionarioDAO(Connection con) {
		this.con = con;
	}
	
	public void insert(Funcionario funcionario) throws SQLException {
		this.con.setAutoCommit(false);
		try (PreparedStatement ps = this.con.prepareStatement("insert into exames (nome) values (?) ")){
			ps.setString(1, funcionario.getNome());
			ps.execute();
			this.con.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	public List<Funcionario> findAll() throws SQLException {
		List<Funcionario> list = new ArrayList<>();
		this.con.setAutoCommit(false);
		try (PreparedStatement ps = this.con.prepareStatement("select * from funcionarios")){
			ps.execute();
			this.con.commit();
			try(ResultSet result = ps.getResultSet()){
				while(result.next()) {
					Funcionario funcionario = new Funcionario(result.getString("nome"));
					list.add(funcionario);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	public void update(Funcionario funcionario) throws SQLException {
		this.con.setAutoCommit(false);
		try(PreparedStatement ps = this.con.prepareStatement("update funcionarios set nome = ? where id = ?")) {
			ps.setString(1, funcionario.getNome());
			ps.setInt(2, funcionario.getId());
			ps.execute();
			this.con.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void delete(Funcionario funcionario) throws SQLException {
		this.con.setAutoCommit(false);
		try(PreparedStatement ps = this.con.prepareStatement("delete from funcionarios where id = ?")) {
			ps.setInt(1, funcionario.getId());
			ps.execute();
			this.con.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
