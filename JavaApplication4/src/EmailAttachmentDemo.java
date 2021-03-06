import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
 
public class EmailAttachmentDemo {
    public static void main(String[] args) {
		System.out.println("STARTING.....");
        EmailAttachmentDemo demo = new EmailAttachmentDemo();
        demo.sendEmail();
    }
 
    public void sendEmail() {
        String from = "luisgustavogomes@outlook.com.br";
        String to = "luis.gomes@tbsa.com.br";
        String subject = "Java Message";
        String bodyText = "This is a important message with attachment";
        String filename = "message.pdf";
 
        //Properties properties = new Properties();
        Properties properties = System.getProperties();
 
        properties.put("mail.stmp.host", "<ipaddress>");
        properties.put("mail.smtp.port", "<port>");
        Session session = Session.getDefaultInstance(properties, null);
 
        try {
 
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setSentDate(new Date());
 
 
            //
            // Set the email message text.
            //
            MimeBodyPart messagePart = new MimeBodyPart();
            messagePart.setText(bodyText);
            //
            // Set the email attachment file
            //
            MimeBodyPart attachmentPart = new MimeBodyPart();
            FileDataSource fileDataSource = new FileDataSource(filename) {
                //@Override
                @Override
                public String getContentType() {
                    return "application/octet-stream";
                }
            };
            attachmentPart.setDataHandler(new DataHandler(fileDataSource));
            attachmentPart.setFileName(filename);
 
 
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messagePart);
            multipart.addBodyPart(attachmentPart);
 
            message.setContent(multipart);
 
 
			Transport t = session.getTransport("smtp");
            Transport.send(message);
 
 
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}