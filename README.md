<p align="center">
  <img 
    src="https://github.com/user-attachments/assets/cf3b9717-51e0-446f-847a-78c804660381" 
    alt="FidesDiária" 
    width="350"
  />
</p>

O **FidesDiária** é uma aplicação desenvolvida em Java para auxiliar no acompanhamento da rotina de devoção religiosa. Por meio do registro de orações e leituras bíblicas, o usuário pode acompanhar seu histórico, sua pontuação e sua evolução através de diferentes níveis de devoção.

O projeto foi desenvolvido inicialmente como uma aplicação **via terminal (CLI)**, com persistência dos dados em arquivos `.txt`.

---

## 📖 Sobre o projeto

O FidesDiária busca transformar práticas de devoção em uma experiência de acompanhamento e progresso.

O usuário pode registrar suas atividades diárias, como **orações e leituras bíblicas**, acumulando pontos conforme mantém sua rotina. Quanto mais atividades são registradas, maior é sua pontuação e, consequentemente, seu nível de devoção.

Além disso, o sistema disponibiliza o **Santo do Dia**, permitindo que o usuário consulte informações relacionadas aos santos cadastrados.

---

## 🎯 Objetivo

O principal objetivo do FidesDiária é proporcionar uma forma simples de **acompanhar e incentivar a constância na vida de oração e leitura bíblica**, permitindo que o usuário visualize sua evolução ao longo do tempo.

---

## ✨ Funcionalidades

### 👤 Usuário

* Criar uma conta com nome e senha
* Realizar login
* Visualizar o perfil
* Consultar sua pontuação
* Acompanhar seu nível de devoção
* Registrar orações
* Registrar leituras bíblicas
* Adicionar uma reflexão à leitura
* Consultar histórico de orações
* Consultar histórico de leituras
* Consultar o Santo do Dia

### 🛡️ Administrador

Além das funcionalidades disponíveis para usuários comuns, o administrador pode:

* Cadastrar Santos do Dia
* Informar o nome, dia e mês do santo
* Promover usuários comuns para administradores através do ID

---
## ⭐ Sistema de Progressão

O FidesDiária possui um sistema de **pontuação e níveis** criado para incentivar o usuário a manter uma rotina de registros dentro da aplicação.

Cada atividade registrada contribui para o progresso do usuário:

| Atividade                                   |  Pontuação |
| ------------------------------------------- | ---------: |
| Oração registrada                           |  +5 pontos |
| Leitura bíblica                             |  +5 pontos |
| Leitura com reflexão acima de 35 caracteres | +10 pontos |

A pontuação acumulada permite que o usuário avance pelos diferentes níveis da aplicação:

**Iniciante → Constante → Perseverante → Devoto → Firme na Fé**

> **Importante:** os níveis representam apenas o **progresso do usuário dentro da aplicação** e foram pensados como uma forma de **gamificação e motivação**. Eles não representam, medem ou determinam o nível de fé, devoção ou espiritualidade de uma pessoa. O objetivo é apenas incentivar a constância nas atividades que o próprio usuário escolhe registrar.


---

## 🙏 Tipos de oração

Atualmente, o sistema possui cinco tipos de oração:

* 🌅 Oração da Manhã
* ☀️ Oração da Tarde
* 🌙 Oração da Noite
* 📿 Terço Mariano
* ❤️ Terço da Divina Misericórdia

---

## 🧩 Arquitetura

O projeto utiliza conceitos de **Domain-Driven Design (DDD)** para organizar o código de acordo com as responsabilidades do domínio da aplicação.

A estrutura é dividida em quatro principais camadas:

```text
Domain
   ↓
Application
   ↓
Infrastructure
   ↓
Presentation
```

### Domain

É o núcleo da aplicação, contendo as entidades, objetos de valor, enums, interfaces de repositório e regras relacionadas ao domínio.

### Application

Responsável pelos casos de uso da aplicação, utilizando os serviços para orquestrar as operações.

### Infrastructure

Contém os detalhes relacionados à persistência dos dados. Atualmente, os dados são armazenados em arquivos `.txt`.

### Presentation

Responsável pela interação com o usuário através da interface de linha de comando (CLI).

---

## 📁 Estrutura do projeto

```text
fidesdiaria/
└── src/
    └── br/com/fidesdiaria/
        │
        ├── domain/
        │   ├── model/
        │   │   ├── User.java
        │   │   ├── UserProgress.java
        │   │   ├── UserType.java
        │   │   ├── Level.java
        │   │   ├── Prayer.java
        │   │   ├── PrayerRecord.java
        │   │   ├── Reading.java
        │   │   ├── Saint.java
        │   │   └── IdGenerator.java
        │   │
        │   ├── repository/
        │   │   ├── UserRepository.java
        │   │   ├── PrayerRecordRepository.java
        │   │   ├── ReadingRepository.java
        │   │   └── SaintRepository.java
        │   │
        │   ├── exception/
        │   │   ├── InvalidAuthenticationException.java
        │   │   └── InvalidPasswordException.java
        │   │
        │   └── security/
        │       ├── NameFormatter.java
        │       └── PasswordValidator.java
        │
        ├── application/
        │   └── service/
        │       ├── UserService.java
        │       ├── AdministratorService.java
        │       ├── PrayerRecordService.java
        │       ├── ReadingService.java
        │       └── SaintService.java
        │
        ├── infrastructure/
        │   └── persistence/
        │       ├── UserRepositoryTxt.java
        │       ├── PrayerRecordRepositoryTxt.java
        │       ├── ReadingRepositoryTxt.java
        │       └── SaintRepositoryTxt.java
        │
        ├── presentation/                                            *Estrutura sujeita a alterações.
        │   └── cli/
        │       ├── StartMenu.java
        │       ├── UserMenu.java
        │       └── AdminMenu.java
        │
        └── Main.java
```

---

## 💻 Tecnologias

### Atualmente

* ☕ **Java**
* 🖥️ **CLI (Command Line Interface)**
* 📄 **Persistência em arquivos `.txt`**
* 🧩 **Domain-Driven Design (DDD)**

### Planejado

Para futuras versões, o projeto poderá evoluir para uma aplicação web utilizando:

* PostgreSQL
* JPA
* Spring Boot
* REST API

> Essas tecnologias fazem parte do planejamento futuro do projeto e ainda não fazem parte da implementação atual.

---

## 💾 Persistência

Atualmente, os dados da aplicação são armazenados localmente em arquivos `.txt`.

Exemplos:

```text
user.txt
prayer.txt
reading.txt
saint.txt
```

Os dados são carregados automaticamente quando a aplicação é iniciada, permitindo que os registros sejam mantidos entre diferentes execuções do programa.

---

## 🚀 Como executar

### 1. Clone o repositório

```bash
git clone <URL_DO_REPOSITORIO>
```

### 2. Acesse o projeto

```bash
cd fidesdiaria
```

### 3. Compile e execute

Execute a classe principal:

```text
Main.java
```

A aplicação será iniciada através do terminal.

---

## 🔮 Próximos passos

O projeto está sendo desenvolvido de forma incremental. Entre os próximos passos planejados estão:

* [ ] Substituir a persistência em `.txt` por PostgreSQL
* [ ] Implementar JPA
* [ ] Migrar a aplicação para Spring Boot
* [ ] Criar uma REST API
* [ ] Desenvolver uma interface web
* [ ] Expandir o sistema de progressão
* [ ] Adicionar novas funcionalidades de acompanhamento da vida devocional

---

## 📌 Status

🚧 **Em desenvolvimento**

O FidesDiária encontra-se atualmente em sua versão inicial, desenvolvida em **Java e executada via terminal**.

---

## 👩‍💻 Autoria

Projeto desenvolvido para fins acadêmicos e de aprendizado em desenvolvimento de software.

**FidesDiária — sua caminhada de fé, um dia de cada vez.** ✝️
