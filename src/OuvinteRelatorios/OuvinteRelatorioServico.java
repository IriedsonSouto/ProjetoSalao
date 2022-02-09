package OuvinteRelatorios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import JanelasRelatorio.JanelaCentralRelatorios;
import Programa.Colaborador;
import Programa.Servico;

public class OuvinteRelatorioServico implements ActionListener {

	private JanelaCentralRelatorios janela;
	
	public OuvinteRelatorioServico(JanelaCentralRelatorios janela){
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent click) {
					
		Document doc = new Document(PageSize.A4);
		
		try {
			OutputStream os = new FileOutputStream("relatorio_servicos.pdf");
			PdfWriter.getInstance(doc, os);
			
			doc.open();
			
			Paragraph paragra = new Paragraph("\nRelação de serviços.");
			paragra.setAlignment(Element.ALIGN_CENTER);
			paragra.setSpacingAfter(5);
			doc.add(paragra);
			
			PdfPTable tabela = new PdfPTable(2);
			PdfPCell cabecalho = new PdfPCell(new Paragraph("Serviços"));
			cabecalho.setBackgroundColor(BaseColor.LIGHT_GRAY);
			PdfPCell cabecalho2 = new PdfPCell(new Paragraph("Descrição"));
			cabecalho2.setBackgroundColor(BaseColor.LIGHT_GRAY);



			
			if (janela.getSla().getCadastros().getServicos() != null){
				tabela.addCell(cabecalho);
				tabela.addCell(cabecalho2);
				for (Servico serv: janela.getSla().getCadastros().getServicos()) {
					tabela.addCell(serv.getNome());
					tabela.addCell(serv.getDescricao());
				}
			}
			doc.add(tabela);
			Paragraph paragra2 = new Paragraph("Contato: beautysalaome@gmail.com");
			paragra2.setAlignment(Element.ALIGN_BOTTOM);
			paragra2.setAlignment(Element.ALIGN_RIGHT);
			doc.add(paragra2);
			doc.close();
				
		} catch (FileNotFoundException erro) {

			erro.printStackTrace();
		} catch (DocumentException erro) {

			erro.printStackTrace();
		} catch (IOException erro) {

			erro.printStackTrace();
		}
	}
}
