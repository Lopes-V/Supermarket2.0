🛒 Supermarket API 2.0
Este é um projeto de gerenciamento de estoque para um supermercado, desenvolvido para aplicar conceitos avançados do ecossistema Spring Boot. A API permite o controle de produtos e suas categorias, com foco em boas práticas de desenvolvimento, robustez no tratamento de erros e organização arquitetural.

🚀 Tecnologias e Ferramentas
Java 17

Spring Boot 3.x

Spring Data JPA (Persistência de Dados)

PostgreSQL (Banco de dados relacional)

Lombok (Produtividade e redução de boilerplate)

Spring Security (Autenticação e Autorização)

🏗️ Arquitetura e Padrões de Projeto
O projeto foi estruturado seguindo o padrão de camadas para garantir a separação de responsabilidades:

Entities: Representação das tabelas do banco de dados (Produto e Categoria).

Repositories: Interfaces de acesso a dados usando JpaRepository.

Services: Camada de lógica de negócio e validações.

Controllers: Exposição dos endpoints REST da aplicação.

DTOs (Data Transfer Objects): Uso de Java Records para otimizar o transporte de dados entre camadas e a API.

🛡️ Tratamento de Erros Profissional
A aplicação implementa um sistema global de tratamento de exceções utilizando @ControllerAdvice. Isso garante que a API responda de forma padronizada e amigável em cenários de erro, como:

Recurso não encontrado (404): Capturado via ResourceNotFoundException.

Erros de Banco de Dados (400): Tratamento de violações de integridade.

Regras de Negócio: Validações customizadas (ex: impedindo preços negativos).

📊 Modelo de Dados
A API gerencia o relacionamento Muitos-para-Um (@ManyToOne) entre Produtos e Categorias, garantindo a integridade referencial do estoque.

🛠️ Como rodar o projeto
Clone o repositório.

Configure as credenciais do PostgreSQL no arquivo application.properties.

Execute a aplicação via sua IDE ou terminal com ./mvnw spring-boot:run.