package Modelo;
import java.util.Properties;
import java.sql.SQLException;
import java.util.ArrayList;

import pool.TestPool;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Correo {
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
	public Correo() {
		tp= new TestPool();
	}
	String usu, pass, correo, newPass;
	TestPool tp;
	modeloXML modelo=new modeloXML();
	public boolean verificarCorreo(String correo){
		ArrayList<String> respuesta=new ArrayList<String>();
		
		try {
			respuesta=tp.ejecutar("select password from usuario where email = '"+correo+"'");
			if(!respuesta.isEmpty()){
				enviarCorreo(correo, respuesta.get(0));
			}
			else{
				return false;
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public void enviarCorreo(String correo, String contra){
		final String username = "documentosescom@gmail.com";
		final String password = "compromiso1234";
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");
 
		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		try {
			generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
		generateMailMessage.setSubject("noreply");
		String emailBody = "Su contraseña registrada en el sistema es: " + contra + "<br><br> Saludos, <br>Sistema para generación de documentos ESCOM";
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");
 
		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
 
		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", username,password);
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
