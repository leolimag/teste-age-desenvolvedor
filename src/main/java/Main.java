import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import br.com.empresa.projeto.soap.WebServiceFuncionarioImpl;
import jakarta.xml.ws.Endpoint;

public class Main {

	public static void main(String[] args) throws IOException, InvalidFormatException, SQLException {
		WebServiceFuncionarioImpl service = new WebServiceFuncionarioImpl();
		Endpoint.publish("http://localhost:8086/api/funcionario", service);
		System.out.println("serviço publicado");
	}

}
