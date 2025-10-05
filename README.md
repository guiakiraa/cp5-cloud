# Sistema FIL

Sistema de gerenciamento de filiais e endereços desenvolvido com Spring Boot e Thymeleaf.

## Funcionalidades

- **Gerenciamento de Endereços**: Cadastro, edição, visualização e exclusão de endereços
- **Gerenciamento de Filiais**: Cadastro, edição, visualização e exclusão de filiais
- **Interface Web**: Interface moderna e responsiva com Bootstrap 5
- **Validação**: Validação de dados com Bean Validation
- **Banco de Dados**: Suporte a H2 (desenvolvimento) e SQL Server (produção)

## Tecnologias Utilizadas

- **Backend**: Spring Boot 3.5.6
- **Frontend**: Thymeleaf + Bootstrap 5
- **Banco de Dados**: H2 (desenvolvimento) / SQL Server (produção)
- **Build**: Maven
- **Java**: 17

## Estrutura do Projeto

```
src/main/java/br/com/dimdim/fil/
├── controller/          # Controllers REST
│   ├── EnderecoController.java
│   ├── FilialController.java
│   └── HomeController.java
├── model/              # Entidades JPA
│   ├── Endereco.java
│   └── Filial.java
├── repository/         # Repositórios JPA
│   ├── EnderecoRepository.java
│   └── FilialRepository.java
└── FilApplication.java # Classe principal

src/main/resources/
├── templates/          # Templates Thymeleaf
│   ├── endereco/
│   ├── filial/
│   ├── home/
│   └── fragmentos.html
├── db/migration/       # Scripts Flyway
│   ├── V1__criando_tabelas.sql
│   └── V2__populando_tabelas.sql
└── application.properties
```

## Como Executar

### Pré-requisitos
- Java 17+
- Maven 3.6+

### Executando a Aplicação

1. Clone o repositório
2. Navegue até a pasta do projeto
3. Execute o comando:
   ```bash
   mvn spring-boot:run
   ```

4. Acesse a aplicação em: http://localhost:8080

### Acesso ao Banco H2 (Desenvolvimento)

- URL: http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (vazio)

## Funcionalidades Implementadas

### Endereços
- ✅ Listar endereços
- ✅ Cadastrar novo endereço
- ✅ Editar endereço existente
- ✅ Visualizar detalhes do endereço
- ✅ Excluir endereço
- ✅ Validação de campos obrigatórios
- ✅ Validação de formato de CEP e UF

### Filiais
- ✅ Listar filiais
- ✅ Cadastrar nova filial
- ✅ Editar filial existente
- ✅ Visualizar detalhes da filial
- ✅ Excluir filial
- ✅ Associação com endereços
- ✅ Validação de campos obrigatórios

### Interface
- ✅ Design responsivo com Bootstrap 5
- ✅ Menu de navegação
- ✅ Página inicial
- ✅ Formulários com validação
- ✅ Mensagens de erro e sucesso
- ✅ Confirmação de exclusão

## Configuração do Banco de Dados

### Desenvolvimento (H2)
O banco H2 está configurado por padrão para desenvolvimento. Os dados são carregados automaticamente via Flyway.

### Produção (SQL Server)
Para usar SQL Server em produção, descomente e configure as propriedades no `application.properties`:

```properties
spring.datasource.url=jdbc:sqlserver://seu-servidor:1433;databaseName=seu-banco
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.SQLServer2016Dialect
```

## Dados de Exemplo

O sistema já vem com dados de exemplo carregados automaticamente:
- 5 endereços em São Paulo e Rio de Janeiro
- 5 filiais associadas aos endereços

## Desenvolvido com Base em

Este projeto foi desenvolvido baseado na estrutura do projeto `challenge-java-mottu`, adaptando os controllers e templates para o domínio de filiais e endereços.
