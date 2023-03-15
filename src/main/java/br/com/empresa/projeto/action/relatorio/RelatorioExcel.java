package br.com.empresa.projeto.action.relatorio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.empresa.projeto.model.ExameFuncionario;

public class RelatorioExcel {

	private String[] columns = { "Id - Funcionário", "Funcionário", "Id - Exame", "Exame", "Data" };

	public void generate(List<ExameFuncionario> exameFuncionarios) throws SQLException, IOException {

		Workbook workbook = new XSSFWorkbook();
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
		for (ExameFuncionario e : exameFuncionarios) {
			Row row = sheet.createRow(rowNum++);

			row.createCell(0).setCellValue(e.getIdFuncionario());
			row.createCell(1).setCellValue(e.getNomeFuncionario());
			row.createCell(2).setCellValue(e.getIdExame());
			row.createCell(3).setCellValue(e.getNomeExame());
			row.createCell(4).setCellValue(e.getData());

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
