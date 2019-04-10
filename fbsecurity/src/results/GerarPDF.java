/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package results;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

/**
 *
 * @author lipe_
 */
public class GerarPDF {

	int contador=0;


	Document pdf = new Document();

	Font perg = new Font(Font.FontFamily.COURIER, 15, Font.BOLD);
	Font resp = new Font(Font.FontFamily.COURIER, 15, Font.ITALIC);
	Font fontlink = new Font(Font.FontFamily.COURIER, 15, Font.UNDERLINE,BaseColor.BLUE);
	Font fontclassi = new Font(Font.FontFamily.COURIER, 15, Font.BOLD,BaseColor.RED);



	/////////CRIANDO PDF///////////////
	public void cria()
	{

		try { 

			System.out.println(contador);
			if(contador==0){
				PdfWriter.getInstance(pdf,new FileOutputStream("postagens.pdf"));
				pdf.open();
			}
			else{
				PdfWriter.getInstance(pdf,new FileOutputStream("postagens("+contador+").pdf"));
				pdf.open();
			}
		} catch (FileNotFoundException ex) {
			Logger.getLogger(GerarPDF.class.getName()).log(Level.SEVERE, null, ex);
		} catch (DocumentException ex) {
			Logger.getLogger(GerarPDF.class.getName()).log(Level.SEVERE, null, ex);
		}
	}      


	////////GRAVAR NO PDF//////////////
	public void grava(String usuario, String postagem, String link, String classifica)
	{         
		try {
			pdf.add(new Paragraph("Usuário: ",perg));
			pdf.add(new Phrase(usuario + " ",resp));
			pdf.add(new Paragraph("Postagem: ",perg));
			pdf.add(new Phrase(postagem + " ",resp));
			pdf.add(new Paragraph("Classificação da postagem: ",perg));
			pdf.add(new Phrase(classifica + " ",fontclassi));
			pdf.add(new Paragraph("Link da postagem: ",perg));
			Phrase phrase = new Phrase();
			Chunk chunk = new Chunk("http://fb.com/"+link,fontlink);
			chunk.setAnchor("http://fb.com/"+link);
			pdf.add(chunk);                      
			pdf.add(new Paragraph("---------------------------------------------------------",perg));
		} catch (DocumentException ex) {
			Logger.getLogger(GerarPDF.class.getName()).log(Level.SEVERE, null, ex);
		}       
	}

	public void abre()
	{
		pdf.close();
		try {
			if(contador==0)
				Desktop.getDesktop().open(new File("postagens.pdf"));
			else{
				Desktop.getDesktop().open(new File("postagens("+contador+").pdf"));
			}
			contador++;
		} catch (IOException ex) {
			Logger.getLogger(GerarPDF.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void fecha()
	{
		pdf.close();
	}


}
