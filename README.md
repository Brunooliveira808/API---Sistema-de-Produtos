# Sistema de Produtos API

API REST desenvolvida com Java e Spring Boot para gerenciamento de produtos e categorias.

O projeto foi construído com foco no aprendizado e aplicação de boas práticas do ecossistema Spring, utilizando arquitetura em camadas, DTOs, mapeamento de objetos, validações, tratamento global de exceções e integração com MySQL.

---

# Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
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

Cada camada possui responsabilidades específicas, promovendo organização, manutenção e escalabilidade.

---

## DTO Pattern

Separação entre os dados expostos pela API e as entidades persistidas no banco de dados.

Exemplos:

- ProdutoRequest
- ProdutoResponse
- ProdutoResumoResponse
- CategoriaRequest
- CategoriaResponse

---

## Mapper Pattern

Conversão centralizada entre DTOs e entidades.

DTO -> Entity
Entity -> DTO

---

## Repository Pattern

Abstração do acesso aos dados utilizando Spring Data JPA.

---

## Bean Validation

Validação automática dos dados recebidos pela API.

Exemplos:

- Campos obrigatórios
- Valores positivos
- Restrições de tamanho

---

## Tratamento Global de Exceções

Implementado através de @ControllerAdvice, garantindo respostas padronizadas para erros da aplicação.

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

## Many-to-Many

Produto ↔ Categoria

Um produto pode pertencer a várias categorias e uma categoria pode conter vários produtos.

---

# Estrutura do Projeto

src/main/java

├── controller
├── service
├── repository
├── entity
├── dto
├── mapper
├── exception
└── handler

---

# Ambiente Docker

O projeto utiliza Docker Compose para disponibilizar rapidamente uma instância do MySQL para a aplicação.

## Executar banco de dados

docker compose -f docker/docker-compose.yml up -d

## Encerrar banco de dados

docker compose -f docker/docker-compose.yml down

## Configuração

Banco: mydb
Usuário: admin
Senha: 123
Porta: 3306

---

# Endpoints Principais

## Produto

POST   /produto
GET    /produto
GET    /produto/{id}
PUT    /produto/{id}
DELETE /produto/{id}
GET    /produto/nome/{nome}
GET    /produto/categoria/{categoria}
GET    /produto/faixa-preco/{min}/{max}

## Categoria

POST /categoria
GET  /categoria
GET  /categoria/{id}

---

# Pontos Fortes

- Arquitetura em camadas
- DTO Pattern
- Mapper Pattern
- Repository Pattern
- Bean Validation
- Tratamento global de exceções
- Relacionamento Many-to-Many
- Consultas customizadas com Spring Data JPA
- Paginação
- MySQL
- Docker Compose para ambiente de banco de dados
- Código organizado e desacoplado

---

# Próximas Evoluções

- Implementação de testes com JUnit e Mockito
- Documentação Swagger/OpenAPI
- Dockerfile da aplicação Spring Boot
- Containerização completa da API
- Spring Security + JWT
- Logs estruturados
- CI/CD com GitHub Actions

---

# Avaliação Técnica

Organização: 9/10
Arquitetura: 8.5/10
Modelagem: 8.5/10
Boas práticas: 8.5/10
Projeto para vaga Java Júnior: 8.5/10

---

# Objetivo do Projeto

Este projeto foi desenvolvido para consolidar conhecimentos em desenvolvimento Backend com Spring Boot e demonstrar a aplicação de boas práticas utilizadas em projetos reais do mercado.
