package staff.information;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;

public class MailTest {

    final String username = "nasirbashak007@gmail.com"; // enter your mail id
    final String password = "#Nasir@1997";// enter ur password

    public void sendMail(String emailTo, String otp, String name) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("nasirbashak007@gmail.com")); // same email id
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("nasirbashak001@gmail.com"));//emailTo// whome  have to send mails that person id 

            message.setSubject("OTP to reset your login credentials");
            message.setText("Dear " + name + " ,"
                    + "\n\n This email was sent from Staff Information Application, Sir MVIT Bangalore.\n "
                    + "Use this One Time Password (OTP) " + otp + " to reset your password.\n"
                    + "Don't share this OTP with anyone else!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {

        new MailTest().sendMail("", "12345dygfjv", "Nasir");

    }
}
