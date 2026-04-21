# Task Flow API

API REST desenvolvida em Java com Spring Boot para gerenciamento de tarefas, com suporte a usuários e priorização automática baseada em regras de negócio.

## Tecnologias utilizadas

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Jakarta Validation
* Lombok
* MySQL Driver
* H2 Database
* Swagger (OpenAPI)
* DevTools

## Diferencial

O sistema possui um mecanismo de priorização automática de tarefas baseado em regras de negócio.

A prioridade é definida considerando:

* Prazo da tarefa (quanto mais próximo, maior a prioridade)
* Nível de esforço

Isso simula cenários reais onde a priorização não é manual, mas sim baseada em critérios objetivos.

## Arquitetura e boas práticas

O projeto segue boas práticas de desenvolvimento backend:

* Separação em camadas (Controller, Service, Repository)  
  Cada camada possui responsabilidade bem definida, facilitando manutenção e escalabilidade.

* Uso de DTOs (Data Transfer Objects)  
  A API não expõe diretamente as entidades, utilizando objetos específicos para entrada e saída de dados.

* Mapper (DTO ↔ Entity)  
  Conversão centralizada entre DTOs e entidades, evitando lógica nos controllers.

* Validação com Jakarta Validation  
  Uso de anotações como `@Valid` para garantir integridade dos dados recebidos.

## Estrutura do projeto

A estrutura foi pensada para manter baixo acoplamento e alta coesão entre as camadas:

```text
com.camach.task_flow
├── controller       # Camada de entrada da API (endpoints REST)
├── dto              # Objetos de transferência de dados
│   ├── task
│   └── user
├── infrastructure
│   ├── entity       # Entidades JPA
│   └── repository   # Interfaces de acesso ao banco
├── mapper           # Conversão entre DTOs e entidades
├── service          # Regras de negócio da aplicação
└── TaskFlowApplication
```

Essa organização evita acoplamento entre camadas e mantém as regras de negócio isoladas da camada de entrada.

## Funcionalidades

### Usuários

* Criar usuário
* Listar usuários
* Buscar por ID
* Atualizar
* Deletar

### Tarefas

* Criar tarefa vinculada a um usuário
* Listar todas as tarefas
* Listar tarefas por usuário
* Atualizar tarefa
* Deletar tarefa
* Definir status
* Prioridade automática baseada em regras

## Endpoints da API

### Usuários

* `POST /users`
* `GET /users`
* `GET /users/{id}`
* `PUT /users/{id}`
* `DELETE /users/{id}`

### Tarefas

* `POST /tasks`
* `GET /tasks`
* `GET /tasks/user/{userId}`
* `PUT /tasks/{id}`
* `DELETE /tasks/{id}`

## Como executar o projeto

### Pré-requisitos

* Java 17+
* Maven

### Passos

```bash
git clone https://github.com/Oscar-Machado/TaskFlow
cd TaskFlow
./mvnw spring-boot:run
```

Ou execute diretamente pela sua IDE.

## Banco de dados

* H2 (em memória, ideal para testes)
* MySQL (configurável no `application.properties`)

## Documentação da API

A documentação interativa está disponível via Swagger:

<http://localhost:8080/swagger-ui.html>

## Autor

Feito por Oscar
