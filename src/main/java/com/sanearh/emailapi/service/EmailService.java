package com.sanearh.emailapi.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${app.hiring.to}")
    private String destino;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendApplicationEmail(String name, String phone, String email, MultipartFile cv) {

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper =
                    new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(destino);
            helper.setSubject("Novo currículo - " + name);

            String body = """
                    Dados do candidato
                    Nome: %s
                    Telefone: %s
                    Email: %s
                    
                    Currículo em anexo.
                    """.formatted(name, phone, email);

            helper.setText(body);

            helper.addAttachment(cv.getOriginalFilename(),
                    new ByteArrayResource(cv.getBytes()));

            mailSender.send(message);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar email: " + e.getMessage());
        }
    }
}
