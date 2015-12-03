package com.springapp.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

        @Autowired
        private JavaMailSender mailSender;


        public void sendEmail(String to, String from, String subject, String body)
                throws Exception {
            System.out.println("I am here");
            MimeMessage message = mailSender.createMimeMessage();
            message.setRecipient(RecipientType.TO, new InternetAddress(to));
            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);
            message.setText(body);

            try {
                mailSender.send(message);
            }catch (MailException e){e.printStackTrace();}
        }

}

