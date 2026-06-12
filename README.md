# Sistema de Produtos API

API REST desenvolvida com Java e Spring Boot para gerenciamento de produtos e categorias.

O projeto foi criado com o objetivo de praticar conceitos fundamentais do desenvolvimento Backend moderno utilizando Spring Boot, Hibernate e MySQL, aplicando boas práticas de arquitetura, separação de responsabilidades e modelagem de dados.

---

# Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Bean Validation
- Lombok
- MySQL
- Maven

---

# Conceitos Aplicados

## Arquitetura em Camadas

O projeto segue uma arquitetura organizada em camadas:

```text
Controller
 ↓
Service
 ↓
Repository
 ↓
Banco de Dados
```

Cada camada possui uma responsabilidade específica, facilitando manutenção, evolução e testes.

---

## DTO Pattern

Utilização de DTOs para separar os dados expostos pela API das entidades persistidas no banco.

Exemplos:

- ProdutoRequest
- ProdutoResponse
- ProdutoResumoResponse
- CategoriaRequest
- CategoriaResponse

---

## Mapper Pattern

Responsável por converter:

```text
DTO -> Entity
Entity -> DTO
```

Mantendo controllers e services mais limpos.

---

## Repository Pattern

Abstração do acesso aos dados utilizando Spring Data JPA.

Exemplo:

```java
public interface ProdutoRepository extends JpaRepository<Produto, Long>
```

---

## Tratamento Global de Exceções

Implementação de:

```java
@ControllerAdvice
```

para centralizar o tratamento de erros da aplicação.

Exemplo:

```java
@NotFoundException
```

retornando respostas padronizadas para o cliente.

---

## Bean Validation

Validação dos dados recebidos pela API.

Exemplos:

- Campos obrigatórios
- Preço positivo
- Nome não nulo

---

# Modelagem

## Produto

| Campo | Tipo |
|---------|---------|
| id | Long |
| nome | String |
| preco | Double |
| categorias | List<Categoria> |

---

## Categoria

| Campo | Tipo |
|---------|---------|
| id | Long |
| nome | String |
| produtos | List<Produto> |

---

# Relacionamento

O sistema utiliza um relacionamento:

```text
Many-to-Many
```

Onde:

- Um produto pode possuir várias categorias
- Uma categoria pode possuir vários produtos

Exemplo:

```text
Notebook Gamer
```

Categorias:

```text
ELETRONICOS
INFORMATICA
```

---

# Funcionalidades

## Produtos

- Criar produto
- Buscar por ID
- Atualizar produto
- Excluir produto
- Listar todos os produtos
- Buscar por nome
- Buscar por categoria
- Buscar por faixa de preço
- Paginação

## Categorias

- Criar categoria
- Listar categorias
- Buscar produtos de uma categoria

---

# Endpoints

## Produto

| Método | Endpoint |
|----------|----------|
| POST | /produto |
| GET | /produto |
| GET | /produto/{id} |
| PUT | /produto/{id} |
| DELETE | /produto/{id} |
| GET | /produto/nome/{nome} |
| GET | /produto/categoria/{categoria} |
| GET | /produto/faixa-preco/{min}/{max} |
| GET | /produto/pagina/{page} |

---

## Categoria

| Método | Endpoint |
|----------|----------|
| POST | /categoria |
| GET | /categoria |
| GET | /categoria/{id} |

---

# Estrutura do Projeto

```text
src/main/java
│
├── controller
│
├── service
│
├── repository
│
├── entity
│
├── dto
│
├── mapper
│
├── exception
│
└── handler
```

---

# Pontos Fortes do Projeto

✅ Arquitetura em camadas

✅ DTO Pattern

✅ Mapper Pattern

✅ Relacionamento Many-to-Many

✅ Bean Validation

✅ Tratamento global de exceções

✅ Consultas derivadas do Spring Data JPA

✅ Paginação

✅ Código organizado e legível

✅ Separação entre regras de negócio e acesso a dados

---

# O Que Pode Ser Melhorado

## 1. Testes Automatizados

Atualmente existe apenas a estrutura inicial de testes.

Adicionar:

- JUnit 5
- Mockito
- MockMvc

permitirá validar regras de negócio e endpoints automaticamente.

---

## 2. Documentação Swagger

Adicionar:

- OpenAPI
- Swagger UI

para documentação automática da API.

---

## 3. Docker

Containerizar:

- Aplicação Spring Boot
- Banco MySQL

facilita execução e demonstra conhecimento de DevOps.

---

## 4. Spring Security

Implementar:

- Autenticação
- Autorização
- JWT

transformaria o projeto em algo muito mais próximo de um sistema real.

---

## 5. Logs Profissionais

Utilizar:

```java
@Slf4j
```

ou

```java
LoggerFactory
```

para registrar eventos importantes da aplicação.

---

## 6. Paginação com Pageable

Atualmente a paginação funciona, mas pode ser modernizada utilizando:

```java
Pageable
```

e retornando:

```java
Page<ProdutoResponse>
```

---

## 7. Versionamento da API

Exemplo:

```text
/api/v1/produtos
```

Boa prática utilizada em sistemas corporativos.

---

## 8. CI/CD

Adicionar pipeline utilizando:

- GitHub Actions
- Jenkins

para build e testes automáticos.

---