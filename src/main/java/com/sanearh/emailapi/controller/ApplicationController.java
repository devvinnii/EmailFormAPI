package com.sanearh.emailapi.controller;

import com.sanearh.emailapi.service.EmailService;
import com.sanearh.emailapi.util.FileValidator;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ApplicationController {

    private final EmailService emailService;

    public ApplicationController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping(value = "/apply", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> apply(
            @RequestPart("name") String name,
            @RequestPart("phone") String phone,
            @RequestPart("email") String email,
            @RequestPart("cv") MultipartFile cv
    ) {

        FileValidator.validateCV(cv);

        emailService.sendApplicationEmail(name, phone, email, cv);

        return ResponseEntity.ok(
                Map.of("status", "success", "message", "Currículo enviado com sucesso!")
        );
    }

    @PostMapping("/debug")
    public ResponseEntity<String> debug() {
        System.out.println("CHEGOU NO MÉTODO!");
        return ResponseEntity.ok("ok");
    }
}
