# user-api - Spring Boot

## Sobre o projeto
API REST desenvolvida com Spring Boot para gerenciamento de usuários, com operações completas de CRUD e persistência em banco de dados  MySQL.

## Tecnologias utilizadas
- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA (Hibernate)
- MySQL
- Maven
- Postman (testes de requisições HTTP)
- HTML + JavaScript (fronted simples para consumo da API)

---

## Arquitetura
- Controller - recebe requisições HTTP
- Service - regra de negócio
- Repository - acesso ao banco (JPA)
- Exception Handler - tratamento de erros

--- 

## Configuração

### 1. Cria banco de dados

SQL
CREATE DATABASE userdb;

### Configurar variável de ambiente

No Windows (PowerShell):
setx DB_PASSWORD "SUA_SENHA"

### application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/userdb
spring.datasource.username=root
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=update

---

## Como Rodar

./mvnw spring-boot:run

---

## Interface Web (Frontend)

O projeto inclui uma interface web simples desenvolvida em HTML e JavaScript para interação com a API

Funcionalidades Disponíveis: 

- Criar usuários
- Listar usuários
- Deletar usuários

A interface consome os endpoints REST utilizando `fetch`.

### Acessar

Após iniciar a aplicação, acesse:

http://localhost:8080/index.html

## Endpoints

### Criar usuário
POST /users
    {
        "name": "João",
        "age": 25
    }

### Listar usuários
GET /users

### Buscar por ID
GET /users/{id}

### Atualizar usuário
PUT /users{id}

### Deletar usuário
DELETE /users/{id}

---

## Testes

As requisições HTTP foram testadas utilizando o Postman.

---


## OBSERVAÇÕES
- O ID é gerado automaticamentoe pelo banco
- Não deve ser enviado no POST
- Projeto utiliza JPA para persistência real

---

## Status
- API Funcional
- Persistência com MySQL
- Boas práticas de segurança aplicadas.


