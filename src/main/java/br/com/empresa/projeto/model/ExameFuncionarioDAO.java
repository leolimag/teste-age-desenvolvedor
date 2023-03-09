package br.com.empresa.projeto.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.empresa.projeto.connection.ConnectionFactory;

public class ExameFuncionarioDAO {

	private Connection con;	
	private ConnectionFactory connectionFactory;
	
	public ExameFuncionarioDAO() {
		this.connectionFactory = new ConnectionFactory();
		this.con = connectionFactory.getConnection();
	}
	
	public List<ExameFuncionario> findAll() throws SQLException {
		if (this.con.isClosed()) {
			this.con = connectionFactory.getConnection();
		}
		List<ExameFuncionario> list = new ArrayList<>();
		this.con.setAutoCommit(false);
		try (PreparedStatement ps = this.con.prepareStatement("select f.id as id_funcionario, f.nome, e.descricao, e.id as id_exame, ef.data from funcionarios f inner join exame_funcionario ef on f.id = ef.id_funcionario\r\n"
				+ " inner join exames e where e.id = ef.id_exame")){
			ps.execute();
			this.con.commit();
			try(ResultSet result = ps.getResultSet()){
				while(result.next()) {
					LocalDate data = result.getDate("data").toLocalDate();
					ExameFuncionario exameFuncionario = new ExameFuncionario(result.getInt("id_exame"), result.getInt("id_funcionario"), data, result.getString("nome"), result.getString("descricao"));
					list.add(exameFuncionario);
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
	
	
	public void insert(ExameFuncionario exameFuncionario) throws SQLException {
		if (this.con.isClosed()) {
			this.con = connectionFactory.getConnection();
		}
		this.con.setAutoCommit(false);
		try (PreparedStatement ps = this.con.prepareStatement("insert into exame_funcionario values (?, ?, ?) ")){
			ps.setInt(1, exameFuncionario.getIdExame());
			ps.setInt(2, exameFuncionario.getIdFuncionario());
			ps.setDate(3, Date.valueOf(exameFuncionario.getData()));
			ps.execute();
			this.con.commit();
			this.con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
//	public void update(ExameFuncionario exameFuncionario) throws SQLException {
//		if (this.con.isClosed()) {
//			this.con = connectionFactory.getConnection();
//		}
//		this.con.setAutoCommit(false);
//		try(PreparedStatement ps = this.con.prepareStatement("update exame_funcionario set data = ?  where id_exame = ?, id_funcionario = ?, data = ?")) {
//			ps.setString(1, exameFuncionario.getDescricao());
//			ps.setString(2, exameFuncionario.getData());
//			ps.setInt(3, exameFuncionario.getId());
//			ps.execute();
//			this.con.commit();
//			this.con.close();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
	
	public void delete(ExameFuncionario exameFuncionario) throws SQLException {
		if (this.con.isClosed()) {
			this.con = connectionFactory.getConnection();
		}
		this.con.setAutoCommit(false);
		try(PreparedStatement ps = this.con.prepareStatement("delete from exame_funcionario where id_exame = ? and id_funcionario = ? and data = ?")) {
			ps.setInt(1, exameFuncionario.getIdExame());
			ps.setInt(2, exameFuncionario.getIdFuncionario());
			ps.setDate(3, Date.valueOf(exameFuncionario.getData()));
			ps.execute();
			this.con.commit();
			this.con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
}
