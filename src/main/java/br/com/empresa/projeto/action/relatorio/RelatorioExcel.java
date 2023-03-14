package br.com.empresa.projeto.action.relatorio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.empresa.projeto.business.ExameFuncionarioBusiness;
import br.com.empresa.projeto.model.ExameFuncionario;

public class RelatorioExcel {

    private String[] colunas = {"Funcionário", "Exame", "Data"};
    private List<ExameFuncionario> exameFuncionarios =  new ArrayList<>();
    
    public void generate(ExameFuncionarioBusiness business) throws SQLException, IOException {
    	exameFuncionarios.addAll(business.getAll());
    	Workbook workbook = new XSSFWorkbook();
        CreationHelper createHelper = workbook.getCreationHelper();
        Sheet sheet = workbook.createSheet("Relatório");
        
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());
        
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        
        Row headerRow = sheet.createRow(0);
        
        for(int i = 0; i < colunas.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(colunas[i]);
            cell.setCellStyle(headerCellStyle);
        }
        
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
        
        int rowNum = 1;
        for(ExameFuncionario e : exameFuncionarios) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0)
                    .setCellValue(e.getNomeFuncionario());

            row.createCell(1)
                    .setCellValue(e.getNomeExame());

            Cell data = row.createCell(2);
            data.setCellValue(e.getData());
            data.setCellStyle(dateCellStyle);
            
            for(int i = 0; i < colunas.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // Write the output to a file
            FileOutputStream fileOut = new FileOutputStream("relatorio.xlsx");
            workbook.write(fileOut);
            fileOut.close();

            // Closing the workbook
            workbook.close();

        }

    }

}
