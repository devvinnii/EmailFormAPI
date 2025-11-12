package com.sanearh.emailapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailRequest {

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @NotBlank(message = "Telefone é obrigatório")
    private String phone;

    @Email(message = "E-mail inválido")
    @NotBlank(message = "E-mail é obrigatório")
    private String email;
}
