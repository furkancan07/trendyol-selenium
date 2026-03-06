package org.rf.utils;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.io.File;
import java.util.Properties;

public class MailUtil {

    private static final Dotenv dotenv = Dotenv.load();

    public static void sendPdfMail(String pdfPath) {
        String from = dotenv.get("MAIL_FROM");
        String password = dotenv.get("MAIL_PASSWORD");
        String to = dotenv.get("MAIL_TO");
        String host = dotenv.get("MAIL_SMTP_HOST");
        int port = Integer.parseInt(dotenv.get("MAIL_SMTP_PORT"));

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Ürün Bilgileri PDF");

            // PDF eki
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText("Ürün bilgileri PDF ekte yer almaktadır.");

            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(new File(pdfPath));

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);
            Transport.send(message);

            System.out.println("Mail gönderildi: " + to);

        } catch (Exception e) {
            System.out.println("Mail gönderme hatası: " + e.getMessage());
        }
    }

}
