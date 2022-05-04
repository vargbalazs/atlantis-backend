package api.atlantis.service.impl.user;

import com.sun.mail.smtp.SMTPTransport;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

import static api.atlantis.constant.EmailConstant.*;

@Service
public class EmailService {

//    private Session getEmailSession() {
//        Properties properties = System.getProperties();
//        properties.put(SMTP_HOST, MAILTRAP_SMTP_SERVER);
//        properties.put(SMTP_AUTH, true);
//        properties.put(SMTP_PORT, DEFAULT_PORT);
//        properties.put(SMTP_STARTTLS_ENABLE, true);
//        properties.put(SMTP_STARTTLS_REQUIRED, true);
//
//        return Session.getInstance(properties, null);
//    }
//
//    private Message createEmail(String firstName, String password, String email) throws MessagingException {
//        Message message = new MimeMessage(getEmailSession());
//        message.setFrom(new InternetAddress(FROM_EMAIL));
//        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email, false));
//        message.setSubject(EMAIL_SUBJECT);
//        message.setText("Hello " + firstName + ", \n \n Your new account password is: " + password + "\n \n " +
//                "The support team");
//        message.setSentDate(new Date());
//        message.saveChanges();
//
//        return message;
//    }
//
//    public void sendNewPasswordEmail(String firstName, String password, String email) throws MessagingException {
//        Message message = createEmail(firstName, password, email);
//        SMTPTransport smtpTransport = (SMTPTransport) getEmailSession().getTransport(SIMPLE_MAIL_TRANSFER_PROTOCOL);
//        smtpTransport.connect(MAILTRAP_SMTP_SERVER, USERNAME, PASSWORD);
//        smtpTransport.sendMessage(message, message.getAllRecipients());
//        smtpTransport.close();
//    }

    public void sendNewPasswordEmail(String firstName, String password, String email) {

        Properties props = new Properties();
        props.put(SMTP_AUTH, "true");
        props.put(SMTP_STARTTLS_ENABLE, "true");
        props.put(SMTP_HOST, MAILTRAP_SMTP_SERVER);
        props.put(SMTP_PORT, DEFAULT_PORT);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(USERNAME, PASSWORD);
                    }
                });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(FROM_EMAIL));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));

            message.setSubject(EMAIL_SUBJECT);
            message.setText("Hello " + firstName + ", \n \n Your new account password is: " + password + "\n \n " +
                "The support team");

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


}
