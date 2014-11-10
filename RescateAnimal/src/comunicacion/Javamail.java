package comunicacion;


//se importan lo elementos necesarios para el correcto funcionamiento de la clase
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//clase basada en c�digo tomado de internet
//clase javamail
//hace capaz el env�o de correos electr�nicos

public class Javamail {
	private final Properties properties = new Properties();
	private Session session;
	
	
	/*
m�todo init
Establece las propiedades del servidor desde el cual se enviar�n correos
	 */
	
	private void init() {
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.port", 587);
		properties.put("mail.smtp.mail.sender", "animalrecuepoo@gmail.com");//Ingresar el correo emisor
		properties.put("mail.smtp.password", "rescaterescate"); //Ingresar contrase�a de correo
		properties.put("mail.smtp.user", "animalrecuepoo@gmail.com");//Ingresar el correo emisor
		properties.put("mail.smtp.auth", "true");
		session = Session.getDefaultInstance(properties);
	}
	
	
	/*
funci�n send
se encarga de iniciar la conecci�n con el servidor y enviar el correo
recibe el correo de destino,asunto y mensaje, en forma de string
retorna boolean
	 */
	public boolean send(String destino,String asunto, String mensaje) {
		init();
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
			message.setSubject(asunto); //establece el asunto
			message.setText(mensaje); //establece el cuerpo del mensaje
			Transport t = session.getTransport("smtp");
			t.connect((String) properties.get("mail.smtp.user"), (String) properties.get("mail.smtp.password"));
			t.sendMessage(message, message.getAllRecipients());
			t.close();
			System.out.println("Enviado");
			return true;
		} 
		
		catch (MessagingException e) {
			System.out.println("Fallido");
			return false;
		}
	}
	
	/*funcion enviarCorreo
se encarga de ejecutar la funci�n send y devolver el resultado en forma de boolean
recibe el correo de destino,asunto y mensaje, en forma de string
retorna boolean
	 */
	public boolean enviarCorreo(String destinatario,String asunto,String mensaje){
		boolean result = send(destinatario,asunto,mensaje);
		return result;
	}
}
