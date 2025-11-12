package com.sanearh.emailapi.controller;

import com.sanearh.emailapi.dto.EmailRequest;
import com.sanearh.emailapi.service.EmailService;
import com.sanearh.emailapi.util.FileValidator;
import jakarta.validation.Valid;
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

    @PostMapping(value = "/apply", consumes = "multipart/form-data")
    public ResponseEntity<String> apply(
            @Valid @ModelAttribute EmailRequest request,
            @RequestParam("cv") MultipartFile cv
    ) {

        FileValidator.validateCV(cv);

        emailService.sendApplicationEmail(
                request.getName(),
                request.getPhone(),
                request.getEmail(),
                cv
        );

        return ResponseEntity.status(302).header("Location", "http://localhost:5500/success.html").build();
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        emailService.sendTestEmail();
        return ResponseEntity.ok("E-mail enviado!");
    }
}
