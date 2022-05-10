package api.atlantis.service.impl.user;

import api.atlantis.utility.Translator;
import com.sun.mail.smtp.SMTPTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

import static api.atlantis.constant.EmailConstant.*;

@Service
public class EmailService {

    @Autowired
    private Environment env;
    public void sendNewPasswordEmail(String firstName, String password, String email) {

        Properties props = new Properties();
        props.put(SMTP_AUTH, "true");
        props.put(SMTP_STARTTLS_ENABLE, "true");
        props.put(SMTP_HOST, env.getProperty("mail.host"));
        props.put(SMTP_PORT, DEFAULT_PORT);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(env.getProperty("mail.username"), env.getProperty("mail.password"));
                    }
                });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(env.getProperty("mail.from-email")));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));

            message.setSubject(Translator.toLocale("EMAIL_SUBJECT"));

            String content = EMAIL_CONTENT;
            content = content.replace("{username}", firstName);
            content = content.replace("{pwd}", password);
            content = content.replace("{registerResetPwd}", Translator.toLocale("REGISTER_RESET_PWD"));
            content = content.replace("{thePasswordIs}", Translator.toLocale("THE_PASSWORD_IS"));

            message.setContent(content, "text/html; charset=UTF-8");

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


}
