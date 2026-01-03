# Sistema de gerenciamento de tarefas — TechFlow Solutions

## Objetivo

Um sistema completo de gerenciamento de tarefas com **Spring Boot (Java)** no backend e **HTML/CSS/JS** no frontend.  
Permite **registro de usuários, login** e **CRUD de tarefas** (criar, listar, atualizar, excluir, concluir).

---

## 🚀 Tecnologias utilizadas

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL** (persistência)
- **HTML, CSS, JavaScript** (frontend simples)
- **Maven** (build e dependências)

---

## 📂 Estrutura do projeto
```
├───src
    ├───main
    │   ├───java
    │   │   └───com
    │   │       └───techflow
    │   │           └───tasks
    │   │               ├───config
    │   │               ├───controller
    │   │               ├───dto
    │   │               ├───exception
    │   │               ├───model
    │   │               ├───repository
    │   │               └───service
    │   └───resources
    │       └───static
    └───test
        ├───java
        │   └───com
        │       └───techflow
        │           └───tasks
        └───resources

```
---

## ⚙️ Configuração

1. **Banco de dados MySQL**
   ```sql
   CREATE DATABASE tasksdb;

### Configure usuário e senha em "application.properties":
    
    spring.datasource.url=jdbc:mysql://localhost:3306/tasksdb?useSSL=false&serverTimezone=UTC
    spring.datasource.username=root
    spring.datasource.password=SUASENHA
    spring.jpa.hibernate.ddl-auto=update

2. **Rodar Aplicação**


    mvn spring-boot:run


3. **Acessar o frontend**


    http://localhost:8080/index.html


## 🔑 Funcionalidades- Registro de usuários (POST /auth/register)


- Login de usuários (POST /auth/login)
- CRUD de tarefas:
  - Criar (POST /tasks)
  - Listar (GET /tasks)
  - Atualizar (PUT /tasks/{id})
  - Concluir/Desmarcar (PATCH /tasks/{id})
  - Excluir (DELETE /tasks/{id})

## 🧪 Testes

Os testes unitários e de integração ficam em
        
    src/test/java/com/techflow/tasks

## 🤝 Contribuição

- Faça um fork do projeto
- Crie uma branch para sua feature:

      git checkout -b feature/nova-feature

- Commit suas mudanças:

        git commit -m "feat: adiciona nova feature"

- Push para a branch:

      git push origin feature/nova-feature

- Abra um Pull Request

## 📌 Status✅ 

Projeto em desenvolvimento ativo

🔒 Issue #12 resolvida (PATCH para concluir tarefas sem apagar título/descrição)

## 📄 Licença

Este projeto está sob a licença MIT. 

Veja o arquivo LICENSE para mais detalhes.