**Integrantes:** 
Isadora Correa Lopes - RA - 12413354
Pedro Arthur Moreira Santos - RA - 123222807
Vitoria Sofia B N Lopes - RA - 124115846

# Sistema de HelpDesk

Sistema de controle de chamados de TI desenvolvido em Java para gerenciamento de ordens de servico.

## Tecnologias Utilizadas

- Java 17
- Maven
- JUnit 5

## Funcionalidades

- Abrir chamado
- Listar chamados
- Buscar chamado por ID
- Atualizar status do chamado
- Atribuir tecnico ao chamado
- Adicionar comentario ao chamado
- Remover chamado

## Principios SOLID Aplicados

- **SRP**: Cada classe possui uma unica responsabilidade. O servico gerencia regras de negocio, o repositorio gerencia armazenamento.
- **OCP**: Interfaces permitem extensao sem modificacao das classes existentes.
- **LSP**: Tecnico e Administrador podem ser usados onde Usuario e esperado.
- **ISP**: Interfaces segregadas (ChamadoRepository, ChamadoService, ChamadoObserver) com metodos especificos.
- **DIP**: HelpDeskService depende da interface ChamadoRepository, nao da implementacao concreta.

## Padroes de Projeto Utilizados

- **Factory Method (Criacional)**: UsuarioFactory para criacao de diferentes tipos de usuario.
- **Repository (Estrutural)**: ChamadoRepository para separar logica de acesso a dados.
- **Observer (Comportamental)**: ChamadoObserver para notificacao de mudancas de status.

## Como Executar

1. Clonar o repositorio
2. Abrir no IntelliJ ou outra IDE com suporte Maven
3. Executar a classe `Main.java`

## Como Executar os Testes

```
mvn test
```
## Apresentação: https://www.canva.com/design/DAHK6FvnARo/RWIs4uVhT3pGvskJxfckFA/edit
