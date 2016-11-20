package Modelo;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;


import org.jdom2.output.XMLOutputter;
import org.jdom2.Document;
import org.jdom2.Element;

public class modeloXML {

	public modeloXML() {
		


	}
	public void crearDocumento(String titulo, String path, ArrayList<String> lista1, ArrayList<String> lista2){
			// root elements
			Element rootElement = new Element("chart");
			rootElement.setAttribute("caption", titulo);
			rootElement.setAttribute("exportEnabled", "1");
			rootElement.setAttribute("startinangle", "120");
			rootElement.setAttribute("showlabels", "0");
			rootElement.setAttribute("showlegend", "1");
			rootElement.setAttribute("enablemultislicing", "0");
			rootElement.setAttribute("slicingdistance", "15");
			rootElement.setAttribute("showpercentvalues", "1");
			rootElement.setAttribute("showpercentintooltip", "0");
			rootElement.setAttribute("theme", "ocean");
			
			for(int i=0;i<lista1.size();i++){
				Element set = new Element("set");
				set.setAttribute("label", lista2.get(i));
				set.setAttribute("value", lista1.get(i));
				rootElement.addContent(set);
			}

			// write the content into xml file
			Document doc=new Document(rootElement);
			XMLOutputter serializador=new XMLOutputter();
			XMLOutputter salida=new XMLOutputter();
			Writer wr=new StringWriter();
			try {
				serializador.output(doc, wr);
				System.out.println(wr.toString());
				salida.output(doc, new FileOutputStream(path+"file1.xml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			// Output to console for testing
			//StreamResult result = new StreamResult(System.out);


			System.out.println("File saved!");
	}
	public void crearTrabajo(String titulo, String path, ArrayList<String> lista1, ArrayList<String> lista2){
		Element rootElement = new Element("chart");
			rootElement.setAttribute("caption", titulo);
			rootElement.setAttribute("exportEnabled", "1");
			rootElement.setAttribute("plotgradientcolor", "");
			rootElement.setAttribute("bgcolor", "FFFFFF");
			rootElement.setAttribute("showplotborder", "0");
			rootElement.setAttribute("divlinecolor", "CCCCCC");
			rootElement.setAttribute("showvalues", "1");
			rootElement.setAttribute("showcanvasborder", "0");
			rootElement.setAttribute("canvasbordercolor", "CCCCCC");
			rootElement.setAttribute("canvasborderthickness", "1");
			rootElement.setAttribute("showyaxisvalues", "0");
			rootElement.setAttribute("showlegend", "1");
			rootElement.setAttribute("showshadow", "0");
			rootElement.setAttribute("labelsepchar", ": ");
			rootElement.setAttribute("basefontcolor", "000000");
			rootElement.setAttribute("labeldisplay", "AUTO");
			rootElement.setAttribute("numberscalevalue", "1000,1000,1000");
			rootElement.setAttribute("numberscaleunit", "K,M,B");
			rootElement.setAttribute("palettecolors", "#008ee4,#9b59b6,#6baa01,#e44a00,#f8bd19,#d35400,#bdc3c7,#95a5a6,#34495e,#1abc9c");
			rootElement.setAttribute("showborder", "0");
			
			for(int i=0;i<lista1.size();i++){
				Element set = new Element("set");
				set.setAttribute("label", lista2.get(i));
				set.setAttribute("value", lista1.get(i));
				rootElement.addContent(set);
			}
			// write the content into xml file
			Document doc=new Document(rootElement);
			XMLOutputter serializador=new XMLOutputter();
			XMLOutputter salida=new XMLOutputter();
			Writer wr=new StringWriter();
			try {
				serializador.output(doc, wr);
				System.out.println(wr.toString());
				salida.output(doc, new FileOutputStream(path+"file2.xml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}

}
