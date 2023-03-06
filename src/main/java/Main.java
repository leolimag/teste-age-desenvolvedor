import java.sql.Connection;
import java.sql.SQLException;

import br.com.empresa.projeto.connection.ConnectionFactory;
import br.com.empresa.projeto.model.Exame;
import br.com.empresa.projeto.model.ExameDAO;

public class Main {

	public static void main(String[] args) {
		try (Connection con = new ConnectionFactory().getConnection()){
			Exame exame = new Exame("exame 7", "13/11/2020");
			ExameDAO dao = new ExameDAO(con);
			dao.findAll().forEach(System.out::println);
			//dao.insert(exame);
			System.out.println("\ninserção realizada com sucesso\n");
			dao.findAll().forEach(System.out::println);
			System.out.println("\nexclusão realizada com sucesso\n");
			exame.setId(6);
			dao.delete(exame);
			dao.findAll().forEach(System.out::println);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
