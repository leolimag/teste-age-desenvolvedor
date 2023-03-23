package br.com.empresa.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.empresa.projeto.connection.ConnectionFactory;
import br.com.empresa.projeto.model.Exame;

public class ExameDAO {
	
	private Connection con;	
	private ConnectionFactory connectionFactory;
	
	public ExameDAO() {
		this.connectionFactory = new ConnectionFactory();
		this.con = connectionFactory.getConnection();
	}
	
	public void insert(Exame exame) throws SQLException {
		if (this.con.isClosed()) {
			this.con = connectionFactory.getConnection();
		}
		this.con.setAutoCommit(false);
		try (PreparedStatement ps = this.con.prepareStatement("insert into exames (nome) values (?) ")){
			ps.setString(1, exame.getNome());
			ps.execute();
			this.con.commit();
			this.con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public List<Exame> findAll() throws SQLException {
		if (this.con.isClosed()) {
			this.con = connectionFactory.getConnection();
		}
		List<Exame> list = new ArrayList<>();
		try (PreparedStatement ps = this.con.prepareStatement("select * from exames")){
			ps.execute();
			try(ResultSet result = ps.getResultSet()){
				while(result.next()) {
					Exame exame = new Exame(result.getInt("id"), result.getString("nome"));
					list.add(exame);
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
	
	public Exame findById(Integer id) throws SQLException {
		if (this.con.isClosed()) {
			this.con = connectionFactory.getConnection();
		}
		Exame exame = null;
		try (PreparedStatement ps = this.con.prepareStatement("select * from exames where id = ?")){
			ps.setInt(1, id);
			ps.execute();
			try(ResultSet result = ps.getResultSet()){
				while(result.next()) {
					exame = new Exame(result.getInt("id"), result.getString("nome"));
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			this.con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return exame;
	}
	
	public void update(Exame exame) throws SQLException {
		if (this.con.isClosed()) {
			this.con = connectionFactory.getConnection();
		}
		this.con.setAutoCommit(false);
		try(PreparedStatement ps = this.con.prepareStatement("update exames set nome = ? where id = ?")) {
			ps.setString(1, exame.getNome());
			ps.setInt(2, exame.getId());
			ps.execute();
			this.con.commit();
			this.con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void delete(Exame exame) throws SQLException {
		if (this.con.isClosed()) {
			this.con = connectionFactory.getConnection();
		}
		this.con.setAutoCommit(false);
		try(PreparedStatement ps = this.con.prepareStatement("delete from exames where id = ?")) {
			ps.setInt(1, exame.getId());
			ps.execute();
			this.con.commit();
			this.con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
