package OuvinteRelatorios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import JanelasRelatorio.JanelaCentralRelatorios;
import Programa.Colaborador;

public class OuvinteRelatorioColaboradores implements ActionListener {

	private JanelaCentralRelatorios janela;
	
	public OuvinteRelatorioColaboradores(JanelaCentralRelatorios janela){
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent click) {
					
		Document doc = new Document(PageSize.A4);
		
		try {
			OutputStream os = new FileOutputStream("relatorio_colaboradores.pdf");
			PdfWriter.getInstance(doc, os);
			
			doc.open();
			
			Paragraph paragra = new Paragraph("\nRelação de colaboradores");
			paragra.setAlignment(Element.ALIGN_CENTER);
			paragra.setSpacingAfter(5);
			doc.add(paragra);
			
			PdfPTable tabela = new PdfPTable(2);
			PdfPCell cabecalho = new PdfPCell(new Paragraph("Colaboradores"));
			cabecalho.setBackgroundColor(BaseColor.LIGHT_GRAY);
			PdfPCell cabecalho2 = new PdfPCell(new Paragraph("Email"));
			cabecalho2.setBackgroundColor(BaseColor.LIGHT_GRAY);
			PdfPCell cabecalho3 = new PdfPCell(new Paragraph("Telefone"));
			cabecalho3.setBackgroundColor(BaseColor.LIGHT_GRAY);


			
			if (janela.getSla().getCadastros().getColaboradores() != null){
				tabela.addCell(cabecalho);
				tabela.addCell(cabecalho2);
				for (Colaborador colab: janela.getSla().getCadastros().getColaboradores()) {
					tabela.addCell(colab.getNome());
					tabela.addCell(colab.getEmail());
					tabela.addCell(colab.getTelefone());
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
