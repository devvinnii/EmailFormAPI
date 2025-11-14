# EmailFormAPI

API desenvolvida em Java Spring Boot para receber formulários de candidatura contendo nome, telefone, e-mail e currículo anexado, enviando as informações para um endereço configurado via SMTP (Gmail).  

---

## Projeto

Esta API permite que qualquer site ou aplicação front-end envie um formulário contendo dados e um arquivo (currículo).  
Os dados são validados e enviados por e-mail de forma segura, utilizando JavaMailSender e um serviço de e-mail (Gmail com senha de app).

---

## Funcionalidades

- Recebimento de dados via multipart/form-data  
- Validação automática dos campos (nome, e-mail, telefone)  
- Validação do arquivo enviado (extensão, tamanho, conteúdo)  
- Envio de e-mail com o currículo anexado  
- Tratamento global de erros com respostas padronizadas  
- Arquitetura modular baseada em camadas  
- Facilmente integrável com qualquer front-end  

---

## Tecnologias Utilizadas

- Java 17+  
- Spring Boot 3+  
- Spring Web  
- JavaMailSender  
- Jakarta Bean Validation  
- Lombok  
- SMTP Gmail (com senha de app)

---

## Como Funciona

1. O cliente envia um POST para `/api/apply` com nome, e-mail, telefone e arquivo.  
2. O DTO valida automaticamente os campos obrigatórios.  
3. O arquivo é validado antes do envio (formato permitido e tamanho).  
4. O serviço monta um e-mail em formato MIME contendo o anexo.  
5. O JavaMailSender envia o e-mail para o endereço configurado.  
6. O usuário recebe uma resposta indicando sucesso ou erro.
