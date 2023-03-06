import java.sql.Connection;
import java.sql.SQLException;

import br.com.empresa.projeto.business.ExameBusiness;
import br.com.empresa.projeto.connection.ConnectionFactory;
import br.com.empresa.projeto.model.Exame;

public class Main {

	public static void main(String[] args) {
		try (Connection con = new ConnectionFactory().getConnection()){
			//testando crud exames
			Exame exame = new Exame("exame 10", "30/11/2020");
			ExameBusiness exameBusiness = new ExameBusiness();
			exameBusiness.getAll().forEach(System.out::println);
			//exameBusiness.insert(exame);
			System.out.println("\ninserção realizada com sucesso\n");
			exameBusiness.getAll().forEach(System.out::println);
			System.out.println("\nexclusão realizada com sucesso\n");
			exame.setId(8);
			//exameBusiness.update(exame);
			exameBusiness.delete(exame);
			exameBusiness.getAll().forEach(System.out::println);
			
			//testando crud funcionario
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
