package com.sanearh.emailapi.util;

import com.sanearh.emailapi.exception.FileValidationException;
import org.springframework.web.multipart.MultipartFile;

public class FileValidator {

    private static final long MAX_SIZE = 5 * 1024 * 1024; // 5MB

    public static void validateCV(MultipartFile file) {

        if (file.isEmpty()) {
            throw new FileValidationException("O arquivo está vazio.");
        }

        if (file.getSize() > MAX_SIZE) {
            throw new FileValidationException("Tamanho máximo permitido é 5MB.");
        }

        String name = file.getOriginalFilename().toLowerCase();

        if (!name.endsWith(".pdf") && !name.endsWith(".doc") && !name.endsWith(".docx")) {
            throw new FileValidationException("Arquivo inválido. Envie um PDF/DOC/DOCX.");
        }
    }
}
