# Sistema de Produtos API

API REST desenvolvida com Spring Boot para gerenciamento de produtos e categorias.

O projeto tem como objetivo praticar conceitos fundamentais do desenvolvimento backend utilizando Java e Spring Boot, aplicando arquitetura em camadas, DTOs, relacionamento entre entidades, validações e consultas personalizadas com JPA.

---

## Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Bean Validation
- MySQL
- Maven

---

## Conceitos Aplicados

- API REST
- Arquitetura em Camadas
- DTO Pattern
- Mapper Pattern
- Repository Pattern
- Service Layer Pattern
- Bean Validation
- Relacionamento Many-to-Many
- Consultas personalizadas com Spring Data JPA
- Tratamento de relacionamentos entre entidades

---

## Estrutura do Projeto

```text
src/main/java
│
├── controller
│   ├── ProdutoController
│   └── CategoriaController
│
├── service
│   ├── ProdutoService
│   └── CategoriaService
│
├── repository
│   ├── ProdutoRepository
│   └── CategoriaRepository
│
├── mapper
│   ├── ProdutoMapper
│   └── CategoriaMapper
│
├── entity
│   ├── Produto
│   └── Categoria
│
└── dto
    ├── categoria
    └── produto
```

---

## Modelagem

### Produto

- id
- nome
- preco
- categorias

### Categoria

- id
- nome
- produtos

---

## Relacionamento

O projeto utiliza um relacionamento Many-to-Many entre produtos e categorias.

Exemplo:

Produto:

```text
Notebook Gamer
```

Categorias:

```text
ELETRONICOS
INFORMATICA
```

Um produto pode possuir várias categorias e uma categoria pode estar associada a vários produtos.

---

## Funcionalidades

### Produtos

- Criar produto
- Buscar produto por ID
- Listar todos os produtos
- Atualizar produto
- Remover produto
- Buscar produtos por nome
- Buscar produtos por categoria
- Buscar produtos por faixa de preço
- Listagem paginada

### Categorias

- Criar categoria
- Listar categorias
- Listar produtos associados a uma categoria

---

## Endpoints

### Produto

| Método | Endpoint | Descrição |
|----------|----------|----------|
| POST | /produto | Criar produto |
| GET | /produto | Listar produtos |
| GET | /produto/{id} | Buscar produto por ID |
| PUT | /produto/{id} | Atualizar produto |
| DELETE | /produto/{id} | Remover produto |
| GET | /produto/pagina/{page} | Paginação |
| GET | /produto/nome/{nome} | Buscar por nome |
| GET | /produto/categoria/{categoria} | Buscar por categoria |
| GET | /produto/faixa-preco/{precoMin}/{precoMax} | Buscar por faixa de preço |

---

### Categoria

| Método | Endpoint | Descrição |
|----------|----------|----------|
| POST | /categoria | Criar categoria |
| GET | /categoria | Listar categorias |
| GET | /categoria/{id} | Listar produtos da categoria |

---

## Exemplo de Cadastro de Categoria

### Request

```json
{
  "nome": "ELETRONICOS"
}
```

### Response

```json
{
  "id": 1,
  "nome": "ELETRONICOS"
}
```

---

## Exemplo de Cadastro de Produto

### Request

```json
{
  "nome": "Notebook Gamer",
  "preco": 4999.99,
  "categoriasIds": [1, 2]
}
```

### Response

```json
{
  "id": 1,
  "nome": "Notebook Gamer",
  "preco": 4999.99,
  "categorias": [
    "ELETRONICOS",
    "INFORMATICA"
  ]
}
```

---

## Exemplo de Consulta por Categoria

### GET

```http
GET /categoria/1
```

### Response

```json
[
  {
    "id": 1,
    "nome": "Notebook Gamer",
    "preco": 4999.99
  },
  {
    "id": 2,
    "nome": "Mouse Gamer",
    "preco": 199.99
  }
]
```

---

## Validações

O projeto utiliza Bean Validation para garantir integridade dos dados recebidos pela API.

Exemplos:

- Nome obrigatório
- Preço positivo
- Lista de categorias obrigatória ao cadastrar produto

---

## Melhorias Futuras

- Paginação utilizando Pageable
- Ordenação dinâmica
- Swagger/OpenAPI
- Tratamento global de exceções (`@RestControllerAdvice`)
- Testes unitários
- Testes de integração
- Dockerização da aplicação

---

## Objetivo

Este projeto foi desenvolvido para consolidar conhecimentos em:

- Java
- Spring Boot
- JPA/Hibernate
- APIs REST
- Arquitetura de Software
- Boas práticas de desenvolvimento backend

Servindo como projeto de estudo e portfólio para vagas de estágio e desenvolvedor Java Júnior.