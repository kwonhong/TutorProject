package com.springapp.mvc.service;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class EmailService {
        private MailSender mailSender;
        private SimpleMailMessage emailTemplate;

        public void sendEmail(String to, String from, String subject, String body)
                throws MailException {
            SimpleMailMessage message = new SimpleMailMessage(this.emailTemplate);
            message.setTo(to);
            message.setFrom(from);
            message.setSubject(subject);
            message.setText(body);
            mailSender.send(message);
        }

        public void setMailSender(MailSender mailSender) {
            this.mailSender = mailSender;
        }
        public void setEmailTemplate(SimpleMailMessage emailTemplate) {
            this.emailTemplate = emailTemplate;
        }

    public static void sendMail(String email, String subject, String body){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mail.xml");

        EmailService mail = (EmailService) context.getBean("mailMail");
        mail.sendEmail("footyfixtoronto@gmail.com",""+email+"",""+subject+"",""+body+"");

    }

}

