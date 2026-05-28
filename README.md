Sistema de Ordem de Serviço
Projeto desenvolvido em Java com Spring Boot para gerenciamento de ordens de serviço.

Tecnologias utilizadas
Java 21
Spring Boot
Spring Data JPA
Hibernate
Maven
Banco H2
Postman
Funcionalidades
Criar ordem de serviço
Listar ordens de serviço
Buscar ordem por ID
Atualizar ordem
Deletar ordem
Validação de dados
Tratamento global de exceções
Estrutura do Projeto
controller
service
repository
model
dto
exception
enums
Endpoints
Criar Ordem de Serviço
POST /ordens

Listar Todas
GET /ordens

Buscar por ID
GET /ordens/{id}

Atualizar
PUT /ordens/{id}

Deletar
DELETE /ordens/{id}

Exemplo JSON
{
  "titulo": "Troca de cabo de rede",
  "descricao": "Cliente está sem internet",
  "prioridade": "ALTA"
}
Como Executar
Clonar o repositório
Abrir no IntelliJ
Executar a classe:
OrdemservicoApplication
A API estará disponível em:
http://localhost:8080
