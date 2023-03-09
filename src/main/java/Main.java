import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.empresa.projeto.connection.ConnectionFactory;
import br.com.empresa.projeto.model.ExameFuncionario;
import br.com.empresa.projeto.model.ExameFuncionarioDAO;

public class Main {

	public static void main(String[] args) {
		try (Connection con = new ConnectionFactory().getConnection()){
			ExameFuncionarioDAO dao = new ExameFuncionarioDAO();
			LocalDate.now();
			ExameFuncionario e = new ExameFuncionario(14, 3, LocalDate.parse("2010-10-10"));
			//dao.insert(e);
			//dao.delete(e);
			dao.findAll().forEach(System.out::println);
//			System.out.println(data);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
