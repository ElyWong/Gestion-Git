/**
 * 
 */
package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author Miguel Duarte
 *
 */
public final class GenerarBitacoraPDF {
	
	private static Consultas consultas = new Consultas();
	private static ResultSet rSet;
	
	private GenerarBitacoraPDF() {}
	
	public static String crearDocumento(ResultSet rs, ArrayList<String> analistas, String path, String fecha) throws FileNotFoundException, DocumentException, SQLException {
		String filename = "bitacora";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		filename += formatter.format(new Date()) + ".pdf";
		path += File.separator + "reportes" + File.separator + filename;
		
		System.err.println(path);
		
		Document document = new Document(PageSize.LETTER.rotate());
		PdfWriter.getInstance(document, new FileOutputStream(path));
	    document.open();
	    
	    Paragraph titulo = new Paragraph("Bitácora", 
	    		FontFactory.getFont("arial", 18, Font.BOLD, BaseColor.BLACK));
	    
	    titulo.setAlignment(Element.ALIGN_CENTER);
	    titulo.setSpacingAfter(25);
	    titulo.setSpacingBefore(25);
	    
	    Paragraph fechaInicio = new Paragraph("Fecha de inicio de bitácora: " + fecha);
	    Paragraph fechaTermino = new Paragraph("Fecha de término de bitácora: " + formatter.format(new Date()));
	    
	    PdfPTable table = new PdfPTable(10);
	    Font font = FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLACK);
	    
	    table.addCell(new Paragraph("Fecha", font));
        table.addCell(new Paragraph("Boleta", font));
        table.addCell(new Paragraph("Alumno", font));
        table.addCell(new Paragraph("Hora de Impresión", font));
        table.addCell(new Paragraph("Trámite", font));
        table.addCell(new Paragraph("Analista Impresión", font));
        table.addCell(new Paragraph("Estatus", font));
        table.addCell(new Paragraph("Folio", font));
        table.addCell(new Paragraph("Hora de Entrega", font));
        table.addCell(new Paragraph("Analista Entrega", font));
        
        int i=0;
        while(rs.next()) {
        	table.addCell(rs.getString("Fecha"));
        	table.addCell(rs.getString("Boleta"));
        	table.addCell(rs.getString("Alumno"));
        	table.addCell(rs.getString("Impresion"));
        	table.addCell(rs.getString("Solicitud"));
        	table.addCell(analistas.get(i++));
        	table.addCell(rs.getString("Estatus"));
        	table.addCell(rs.getString("Folio"));
        	table.addCell(rs.getString("Entrega"));
        	rSet = consultas.obtenerAnalistaEntrega(rs.getString("Analista"));
        	if(rSet.next()) {
        		table.addCell(rSet.getString(1));
        	} else {
        		table.addCell("");
        	}
        }
      
        float[] medidaCeldas = {2.0f, 2.0f, 3.0f, 1f, 3.0f, 3.0f, 1.5f, 1.5f, 1f, 3.0f};
        table.setWidths(medidaCeldas);
        table.setSpacingAfter(20);
        table.setSpacingBefore(20);
        table.setWidthPercentage(100);
      
        document.add(titulo);
        document.add(fechaInicio);
        document.add(fechaTermino);
	    document.add(table);
	    document.close();
		return filename;
	}
	
	public static String crearReporte(ResultSet rs, ArrayList<String> analistas, String path, String fecha, String idAnalista) throws FileNotFoundException, DocumentException, SQLException {
		String filename = "reporte_";
		filename += idAnalista + "_" + fecha + ".pdf";
		path += "\\reportes\\" + filename;
		
		Document document = new Document(PageSize.LETTER.rotate());
		PdfWriter.getInstance(document, new FileOutputStream(path));
	    document.open();
	    
	    Paragraph titulo = new Paragraph("Reporte", 
	    		FontFactory.getFont("arial", 18, Font.BOLD, BaseColor.BLACK));
	    
	    titulo.setAlignment(Element.ALIGN_CENTER);
	    titulo.setSpacingAfter(25);
	    titulo.setSpacingBefore(25);
	    
	    Paragraph nombreAnalista = new Paragraph("Nombre del analista: " + analistas.get(0));
	    Paragraph fechaReporte = new Paragraph("Fecha: " + fecha);
	    
	    PdfPTable table = new PdfPTable(6);
	    Font font = FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLACK);
	    
        table.addCell(new Paragraph("Boleta", font));
        table.addCell(new Paragraph("Alumno", font));
        table.addCell(new Paragraph("Hora", font));
        table.addCell(new Paragraph("Trámite", font));
        table.addCell(new Paragraph("Estatus", font));
        table.addCell(new Paragraph("Folio", font));
       
        while(rs.next()) {
        	table.addCell(rs.getString("Boleta"));
        	table.addCell(rs.getString("Alumno"));
        	table.addCell(rs.getString("Hora"));
        	table.addCell(rs.getString("Solicitud"));
        	table.addCell(rs.getString("Estatus"));
        	table.addCell(rs.getString("Folio"));
        }
      
        float[] medidaCeldas = {2.0f, 3.0f, 1f, 3.0f, 1.5f, 1.5f};
        table.setWidths(medidaCeldas);
        table.setSpacingAfter(20);
        table.setSpacingBefore(20);
        table.setWidthPercentage(100);
      
        document.add(titulo);
        document.add(nombreAnalista);
        document.add(fechaReporte);
	    document.add(table);
	    document.close();
		return filename;
	}

}
