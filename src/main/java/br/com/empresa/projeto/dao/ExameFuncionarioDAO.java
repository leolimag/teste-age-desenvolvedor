package br.com.empresa.projeto.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.empresa.projeto.connection.ConnectionFactory;
import br.com.empresa.projeto.model.ExameFuncionario;
import br.com.empresa.projeto.vo.ExameFuncionarioVO;

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
		try (PreparedStatement ps = this.con.prepareStatement("select f.id as id_funcionario, f.nome, e.nome as nomeExame, e.id as id_exame, ef.data from funcionarios f inner join exame_funcionario ef on f.id = ef.id_funcionario\r\n"
				+ " inner join exames e where e.id = ef.id_exame order by data desc")){
			ps.execute();
			this.con.commit();
			try(ResultSet result = ps.getResultSet()){
				while(result.next()) {
					LocalDate date = result.getDate("data").toLocalDate();
					String dateString = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					ExameFuncionario exameFuncionario = new ExameFuncionario(result.getInt("id_exame"), result.getInt("id_funcionario"), dateString, result.getString("nome"), result.getString("nomeExame"));
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
	
	public ExameFuncionario findById(Integer idExame, Integer idFuncionario, String data) throws SQLException {
		if (this.con.isClosed()) {
			this.con = connectionFactory.getConnection();
		}
		this.con.setAutoCommit(false);
		ExameFuncionario exameFuncionario = null;
		try (PreparedStatement ps = this.con.prepareStatement("select * from exame_funcionario where id_exame = ? and id_funcionario = ? and data = ?")) {
			ps.setInt(1, idExame);
			ps.setInt(2, idFuncionario);
			ps.setDate(3, Date.valueOf(data)); 
			ps.execute();
			this.con.commit();
			try(ResultSet result = ps.getResultSet()) {
				while(result.next()) {
					LocalDate date = result.getDate("data").toLocalDate();
					String dateString = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					exameFuncionario = new ExameFuncionario(result.getInt("id_exame"), result.getInt("id_funcionario"), dateString);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			this.con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return exameFuncionario;
	}
	
	public List<ExameFuncionario> findByDate(String dataInicial, String dataFinal) throws SQLException {
		if (this.con.isClosed()) {
			this.con = connectionFactory.getConnection();
		}
		List<ExameFuncionario> list = new ArrayList<>();
		this.con.setAutoCommit(false);
		try (PreparedStatement ps = this.con.prepareStatement("select e.id as id_exame, f.id as id_funcionario, f.nome, e.nome as nomeExame, ef.data from funcionarios f inner join exame_funcionario ef on f.id = ef.id_funcionario\r\n"
				+ " inner join exames e where e.id = ef.id_exame and ef.data >= ? and ef.data <= ? order by data desc")){
			ps.setDate(1, Date.valueOf(dataInicial));
			ps.setDate(2, Date.valueOf(dataFinal));
			ps.execute();
			this.con.commit();
			try(ResultSet result = ps.getResultSet()){
				while(result.next()) {
					LocalDate date = result.getDate("data").toLocalDate();
					String dateString = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					ExameFuncionario exameFuncionario = new ExameFuncionario(result.getInt("id_exame"), result.getInt("id_funcionario"), dateString, result.getString("nome"), result.getString("nomeExame"));
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
	
	public List<ExameFuncionarioVO> findFive(String dataInicial, String dataFinal) throws SQLException {
		if (this.con.isClosed()) {
			this.con = connectionFactory.getConnection();
		}
		List<ExameFuncionarioVO> list = new ArrayList<>();
		this.con.setAutoCommit(false);
		try (PreparedStatement ps = this.con.prepareStatement("select ef.id_exame, e.nome , count(*) as quantidade from exame_funcionario ef \r\n"
				+ "inner join exames e on ef.id_exame = e.id where ef.data >= ? \r\n"
				+ "and ef.data <= ? group by id_exame order by quantidade desc limit 5")){
			ps.setDate(1, Date.valueOf(dataInicial));
			ps.setDate(2, Date.valueOf(dataFinal));
			ps.execute();
			this.con.commit();
			try(ResultSet result = ps.getResultSet()){
				while(result.next()) {
					ExameFuncionarioVO exameFuncionario = new ExameFuncionarioVO(result.getInt("id_exame"), result.getInt("quantidade"), result.getString("nome"));
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
	
	public void update(ExameFuncionario exameFuncionario, String dataAntiga) throws SQLException {
		LocalDate date = toLocalDate(dataAntiga);
		if (this.con.isClosed()) {
			this.con = connectionFactory.getConnection();
		}
		this.con.setAutoCommit(false);
		try(PreparedStatement ps = this.con.prepareStatement("update exame_funcionario set data = ?  where id_exame = ? and id_funcionario = ? and data = ?")) {
			ps.setDate(1, Date.valueOf(exameFuncionario.getData()));
			ps.setInt(2, exameFuncionario.getIdExame());
			ps.setInt(3, exameFuncionario.getIdFuncionario());
			ps.setDate(4, Date.valueOf(date));
			ps.execute();
			this.con.commit();
			this.con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void delete(ExameFuncionario exameFuncionario) throws SQLException {
		LocalDate date = toLocalDate(exameFuncionario.getData());
		if (this.con.isClosed()) {
			this.con = connectionFactory.getConnection();
		}
		this.con.setAutoCommit(false);
		try(PreparedStatement ps = this.con.prepareStatement("delete from exame_funcionario where id_exame = ? and id_funcionario = ? and data = ?")) {
			ps.setInt(1, exameFuncionario.getIdExame());
			ps.setInt(2, exameFuncionario.getIdFuncionario());
			ps.setDate(3, Date.valueOf(date));
			ps.execute();
			this.con.commit();
			this.con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteByIdFuncionario(Integer id) throws SQLException {
		if (this.con.isClosed()) {
			this.con = connectionFactory.getConnection();
		}
		this.con.setAutoCommit(false);
		try(PreparedStatement ps = this.con.prepareStatement("delete from exame_funcionario where id_funcionario = ?")) {
			ps.setInt(1, id);
			ps.execute();
			this.con.commit();
			this.con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private LocalDate toLocalDate(String data) {
		String dataArray[] = data.split("/");
		LocalDate date = LocalDate.of(Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[1]), Integer.parseInt(dataArray[0]));
		return date;
	}

}
