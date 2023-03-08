import java.sql.Connection;
import java.sql.SQLException;

import br.com.empresa.projeto.business.ExameBusiness;
import br.com.empresa.projeto.business.FuncionarioBusiness;
import br.com.empresa.projeto.connection.ConnectionFactory;
import br.com.empresa.projeto.model.Exame;
import br.com.empresa.projeto.model.Funcionario;

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
			int c = 0;
			//exameBusiness.update(exame);
			//exameBusiness.delete(exame);
			while(c  < 5) {
				exameBusiness.insert(exame);
				c++;
			}
			
			exameBusiness.getAll().forEach(System.out::println);
			
			//testando crud funcionario
			Funcionario f = new Funcionario("bia");
			Funcionario f2 = new Funcionario("leo");
			FuncionarioBusiness fbusiness = new FuncionarioBusiness();
			//fbusiness.insert(f);
			//fbusiness.delete(f);
			f.setId(3);
			f2.setId(1);
			//fbusiness.update(f);
			//fbusiness.update(f2);
			fbusiness.getAll().forEach(e -> System.out.println(e));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
