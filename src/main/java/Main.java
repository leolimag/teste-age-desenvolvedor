import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.empresa.projeto.business.ExameFuncionarioBusiness;
import br.com.empresa.projeto.model.ExameFuncionario;

public class Main {

	private static String[] columns = { "Funcionário", "Exame", "Data" };
	private static List<ExameFuncionario> exames = new ArrayList<>();
	private static ExameFuncionarioBusiness business = new ExameFuncionarioBusiness();

	// Initializing employees data to insert into the excel file

	public static void main(String[] args) throws IOException, InvalidFormatException {
		try {
			List<ExameFuncionario> lista = business.getAll();
			for (ExameFuncionario ef : lista) {
				exames.add(new ExameFuncionario(ef.getData(), ef.getNomeFuncionario(), ef.getNomeExame()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file
		CreationHelper createHelper = workbook.getCreationHelper();

		Sheet sheet = workbook.createSheet("Relatório");

		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 12);

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		Row headerRow = sheet.createRow(0);

		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}

		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

		int rowNum = 1;
		for (ExameFuncionario e : exames) {
			Row row = sheet.createRow(rowNum++);

			row.createCell(0).setCellValue(e.getNomeFuncionario());

			row.createCell(1).setCellValue(e.getNomeExame());

			Cell dateOfBirthCell = row.createCell(2);
			dateOfBirthCell.setCellValue(e.getData());
			dateOfBirthCell.setCellStyle(dateCellStyle);

		}

		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}

		FileOutputStream fileOut = new FileOutputStream("relatorio.xlsx");
		workbook.write(fileOut);
		fileOut.close();

		workbook.close();
	}

}
