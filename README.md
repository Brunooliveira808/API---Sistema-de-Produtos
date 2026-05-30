# Sistema de Produtos API

API REST desenvolvida com Spring Boot para gerenciamento de produtos e categorias.

O projeto foi criado com foco em aprendizado e prática de conceitos importantes do ecossistema Spring, como arquitetura em camadas, JPA/Hibernate, DTOs, relacionamentos entre entidades e boas práticas para construção de APIs REST.

---

## Funcionalidades

### Produtos

- Criar produto
- Listar todos os produtos
- Buscar produto por id
- Atualizar produto
- Remover produto

### Categorias

- Criar categoria
- Listar categorias
- Consultar produtos relacionados a uma categoria

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

## Arquitetura

O projeto segue uma arquitetura em camadas:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Banco de Dados
```

Além disso, utiliza DTOs e Mappers para desacoplar a camada de persistência da camada de apresentação.

```text
controller
service
repository
mapper
entity
dto
```

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
    ├── request
    └── response
```

---

## Relacionamento entre Entidades

O projeto utiliza um relacionamento Many-to-Many entre produtos e categorias.

### Exemplo

Um produto pode possuir várias categorias:

- Notebook
    - Eletrônicos
    - Informática

Uma categoria pode possuir vários produtos:

- Eletrônicos
    - Notebook
    - Smartphone
    - Tablet

---

## Exemplo de Requisição

### Criar Produto

**POST /produtos**

```json
{
  "nome": "Notebook Gamer",
  "preco": 4999.99,
  "categoriasIds": [1, 2]
}
```

### Resposta

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

## Endpoints

### Produtos

| Método | Endpoint | Descrição |
|----------|----------|----------|
| POST | /produtos | Criar produto |
| GET | /produtos | Listar produtos |
| PUT | /produtos/{id} | Atualizar produto |
| DELETE | /produtos/{id} | Remover produto |

### Categorias

| Método | Endpoint | Descrição |
|----------|----------|----------|
| POST | /categorias | Criar categoria |
| GET | /categorias | Listar categorias |
| GET | /categorias/{id} | Listar produtos da categoria |

---

## Conceitos Aplicados

- API REST
- DTO Pattern
- Mapper Pattern
- Service Layer Pattern
- Repository Pattern
- Relacionamento Many-to-Many
- Bean Validation
- Separação de Responsabilidades
- Arquitetura em Camadas

---

## Próximas Melhorias

- Paginação
- Ordenação
- Filtro por nome
- Filtro por categoria
- Filtro por faixa de preço
- Tratamento global de exceções
- Documentação com Swagger/OpenAPI
- Testes unitários

---

## Objetivo do Projeto

Este projeto foi desenvolvido como prática para consolidar conhecimentos em desenvolvimento backend com Spring Boot e simular cenários comuns encontrados em aplicações corporativas.

O foco principal foi a aplicação de boas práticas de arquitetura, modelagem de dados e construção de APIs REST.
