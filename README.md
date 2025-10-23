# 🧪 Automação de Testes de API - RestAssured + JUnit + Allure

Este projeto foi desenvolvido para praticar automação de testes de API REST utilizando **Java 11**, **RestAssured**, **JUnit 5**, **Maven** e **Allure Reports**.

## 🚀 Tecnologias Utilizadas
- Java 11  
- Maven  
- JUnit 5  
- RestAssured  
- Allure Framework  

## 🧩 Estrutura do Projeto
```
src/
AutoApiJavaRest/
│
├── .allure/                         → cache local do Allure (gerado automaticamente)
│
├── .github/
│   └── workflows/
│       └── teste.yaml               → workflow GitHub Actions (CI/CD, executa os testes automaticamente)
│
├── .idea/                           → configurações do IntelliJ (IDE)
│
├── .mvn/                            → scripts e configs do Maven wrapper (caso usado)
│
├── src/
│   ├── main/                        → código-fonte da aplicação (opcional em testes)
│   │   ├── java/                    → aqui iriam classes auxiliares, helpers ou models
│   │   └── resources/               → configs globais, ex: application.properties
│   │
│   └── test/                        → foco dos testes automatizados (JUnit + RestAssured)
│       ├── java/
│       │   └── BookingTest.java     → classe principal de teste (ex: POST, GET, PUT, DELETE)
│       │
│       └── resources/
│           └── payloads/
│               └── reserva.json     → corpo JSON usado nas requisições (payload)
│
├── target/                          → pasta de build do Maven (gerada após mvn test)
│   ├── allure-results/              → resultados brutos de testes (usado pelo Allure)
│   ├── surefire-reports/            → logs e relatórios do JUnit/Maven
│   ├── test-classes/                → classes compiladas de teste
│   └── ...                          → outras pastas de saída geradas
│
├── .gitignore                       → ignora arquivos temporários (target/, .idea/, etc.)
│
├── pom.xml                          → coração do projeto Maven ❤️
│                                     - Define as dependências:
│                                        🧱 RestAssured (testes de API)
│                                        🧪 JUnit 5 (framework de testes)
│                                        📊 Allure (relatórios)
│                                        🧩 Hamcrest / Jackson / etc
│
└── README.md                        → documentação do projeto (explicação e instruções)

```
