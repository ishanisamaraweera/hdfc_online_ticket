package com.example.otrs.Service;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

/**
 *
 @author ishani.s
 */
@Service
public class EmailSenderService {
    public void sendEmail(String to, String subject, String body) {
        // Sender's email ID and password need to be mentioned
        final String from = "ishani.s@hdfc.lk";
        final String password = "ishu@1007";
        String host = "192.168.10.50";

        // Set up the mail server properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "25");props.put("mail.smtp.connectiontimeout", "10000");
        props.put("mail.smtp.timeout", "10000");


        // Get the Session object and authenticate
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);

            // Set From: header field
            message.setFrom(new InternetAddress(from));

            // Set To: header field
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject(subject);

            // Set the body of the email
            message.setText(body);

            // Send message
            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

