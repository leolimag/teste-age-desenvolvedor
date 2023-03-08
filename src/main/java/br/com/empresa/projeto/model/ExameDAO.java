package br.com.empresa.projeto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.empresa.projeto.connection.ConnectionFactory;

public class ExameDAO {
	
	private Connection con;	
	private ConnectionFactory connectionFactory;
	
	public ExameDAO() {
		this.connectionFactory = new ConnectionFactory();
		this.con = connectionFactory.getConnection();
	}
	
	public void insert(Exame exame) throws SQLException {
		this.con.setAutoCommit(false);
		try (PreparedStatement ps = this.con.prepareStatement("insert into exames (descricao, data) values (?, ?) ")){
			ps.setString(1, exame.getDescricao());
			ps.setString(2, exame.getData());
			ps.execute();
			this.con.commit();
			this.con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public List<Exame> findAll() throws SQLException {
		List<Exame> list = new ArrayList<>();
		this.con.setAutoCommit(false);
		try (PreparedStatement ps = this.con.prepareStatement("select * from exames")){
			ps.execute();
			this.con.commit();
			try(ResultSet result = ps.getResultSet()){
				while(result.next()) {
					Exame exame = new Exame(result.getInt("id"), result.getString("descricao"), result.getString("data"));
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
		this.con.setAutoCommit(false);
		Exame exame = null;
		try (PreparedStatement ps = this.con.prepareStatement("select * from exames where id = ?")){
			ps.setInt(1, id);
			ps.execute();
			this.con.commit();
			try(ResultSet result = ps.getResultSet()){
				while(result.next()) {
					exame = new Exame(result.getInt("id"), result.getString("descricao"), result.getString("data"));
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
		this.con.setAutoCommit(false);
		try(PreparedStatement ps = this.con.prepareStatement("update exames set descricao = ?, data = ? where id = ?")) {
			ps.setString(1, exame.getDescricao());
			ps.setString(2, exame.getData());
			ps.setInt(3, exame.getId());
			ps.execute();
			this.con.commit();
			this.con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void delete(Exame exame) throws SQLException {
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
