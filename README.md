# Sistema de Produtos API

API REST desenvolvida com Java e Spring Boot para gerenciamento de produtos, categorias e autenticação de usuários.

O projeto foi construído com foco no aprendizado e aplicação de boas práticas do ecossistema Spring, utilizando arquitetura em camadas, DTOs, mapeamento de objetos, validações, tratamento global de exceções, autenticação JWT e integração com MySQL.

---

# Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- Hibernate
- Spring Security
- JWT (JSON Web Token)
- MySQL
- Bean Validation
- Lombok
- Maven
- Docker Compose

---

# Funcionalidades

## Produtos

- Criar produto
- Buscar produto por ID
- Atualizar produto
- Excluir produto
- Listar produtos
- Buscar por nome
- Buscar por categoria
- Buscar por faixa de preço
- Paginação de resultados

## Categorias

- Criar categoria
- Buscar categoria por ID
- Listar categorias
- Consultar produtos de uma categoria

## Autenticação

- Cadastro de usuários
- Login de usuários
- Geração de Token JWT
- Validação automática de Token JWT
- Controle de acesso baseado em Roles
- Senhas protegidas com BCrypt

---

# Conceitos Aplicados

## Arquitetura em Camadas

Controller
↓
Service
↓
Repository
↓
Database

## DTO Pattern

Separação entre dados expostos pela API e entidades persistidas.

## Mapper Pattern

Conversão centralizada entre DTOs e entidades.

## Repository Pattern

Abstração do acesso aos dados utilizando Spring Data JPA.

## Bean Validation

Validação automática dos dados recebidos pela API.

## Tratamento Global de Exceções

Centralização de erros através de @ControllerAdvice.

## Spring Security

Implementação de autenticação e autorização baseada em JWT.

---

# Segurança

A aplicação utiliza autenticação Stateless com JWT.

Rotas públicas:

POST /auth/register
POST /auth/login

Rotas protegidas:

- Produtos
- Categorias

Restrições de acesso:

- ADMIN pode criar, alterar e remover produtos e categorias.
- Usuários autenticados podem acessar recursos permitidos pelas regras da aplicação.

Componentes implementados:

- SecurityConfiguration
- JwtAuthenticationFilter
- TokenProvider
- AuthenticationService
- UserDetailsServiceImpl

---

# Modelagem

## Produto

- id : Long
- nome : String
- preco : Double
- categorias : List<Categoria>

## Categoria

- id : Long
- nome : String
- produtos : List<Produto>

---

# Relacionamento

Many-to-Many

Produto ↔ Categoria

---

# Estrutura do Projeto

src/main/java

├── controller
├── service
├── repository
├── entity
├── dto
├── mapper
├── config
├── exception
└── handler

---

# Ambiente Docker

O projeto utiliza Docker Compose para disponibilizar uma instância MySQL para a aplicação.

Executar:

docker compose -f docker/docker-compose.yml up -d

Encerrar:

docker compose -f docker/docker-compose.yml down

---

# Endpoints Principais

## Autenticação

POST /auth/register

POST /auth/login

## Produto

POST /produto

GET /produto

GET /produto/{id}

PUT /produto/{id}

DELETE /produto/{id}

GET /produto/nome/{nome}

GET /produto/categoria/{categoria}

GET /produto/faixa-preco/{min}/{max}

## Categoria

POST /categoria

GET /categoria

GET /categoria/{id}

---

# Pontos Fortes

✅ Arquitetura em camadas

✅ DTO Pattern

✅ Mapper Pattern

✅ Repository Pattern

✅ Bean Validation

✅ Tratamento global de exceções

✅ Relacionamento Many-to-Many

✅ Consultas customizadas com Spring Data JPA

✅ Paginação

✅ Spring Security

✅ JWT Authentication

✅ BCrypt Password Encoder

✅ Controle de acesso por Roles

✅ Docker Compose

✅ Integração com MySQL

---

# Próximas Evoluções

- Testes automatizados com JUnit e Mockito
- Swagger/OpenAPI
- Dockerfile da aplicação
- Containerização completa da API
- CI/CD com GitHub Actions
- Cobertura de testes

---


