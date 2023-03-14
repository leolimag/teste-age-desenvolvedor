package br.com.empresa.projeto.action.relatorio;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.empresa.projeto.model.ExameFuncionario;

public class RelatorioPDF {

	public Document generate(Document document, HttpServletResponse response,
			List<ExameFuncionario> exameFuncionarios) {
		document = new Document();
		try {
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition", "inline; filename=" + "relatorio.pdf");
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();

			Paragraph title = new Paragraph(new Phrase(20F, "Relatório de Exames"));
			title.setAlignment(Element.ALIGN_CENTER);
			document.add(title);
			document.add(new Paragraph(" "));
			PdfPTable table = new PdfPTable(3);
			PdfPCell col1 = new PdfPCell(new Paragraph("Funcionário"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Exame"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Data"));
			col1.setHorizontalAlignment(Element.ALIGN_CENTER);
			col2.setHorizontalAlignment(Element.ALIGN_CENTER);
			col3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(col1);
			table.addCell(col2);
			table.addCell(col3);

			for (ExameFuncionario e : exameFuncionarios) {
				table.addCell(e.getNomeExame());
				table.addCell(e.getNomeFuncionario());
				table.addCell(e.getData());
			}

			document.add(table);

			document.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return document;
	}

}
