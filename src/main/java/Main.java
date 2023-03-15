import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import br.com.empresa.projeto.action.relatorio.RelatorioExcel;
import br.com.empresa.projeto.business.ExameFuncionarioBusiness;
import br.com.empresa.projeto.model.ExameFuncionario;

public class Main {

	private static List<ExameFuncionario> exames = new ArrayList<>();
	private static ExameFuncionarioBusiness business = new ExameFuncionarioBusiness();

	public static void main(String[] args) throws IOException, InvalidFormatException, SQLException {
		exames.addAll(business.getAll());
		RelatorioExcel excel = new RelatorioExcel();
		excel.generate(exames);
	}

}
