# 📽️ VideoManager API

Projeto de uma API REST para gerenciamento de vídeos, construída com Java 21, Spring Boot 3 e MySQL 8. O projeto está totalmente containerizado com Docker e expõe métricas para monitoramento com Prometheus.

## ✅ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3** (Web, Data JPA, Validation, Actuator)
- **MySQL 8.0**
- **Hibernate 6**
- **Maven**
- **Docker & Docker Compose**
- **Micrometer & Prometheus** para métricas

## ⚙️ Pré-requisitos

- Java 21+
- Maven 3.8+
- Docker
- Docker Compose

## 🚀 Como Executar o Projeto

Existem duas maneiras de executar a aplicação:

### 1. Usando Docker Compose (Recomendado)

Este é o método mais simples. Ele irá construir a imagem da aplicação e subir os contêineres da API e do banco de dados de uma vez só.

1.  **Construa o JAR da aplicação:**
    ```bash
    cd videomanager
    ./mvnw package
    ```

2.  **Suba os contêineres:**
    ```bash
    sudo docker compose up -d
    ```

A API estará disponível em `http://localhost:8080`.

### 2. Executando Localmente

Este método é útil para desenvolvimento e depuração.

1.  **Inicie o banco de dados com Docker:**
    ```bash
    cd videomanager
    sudo docker compose up -d db
    ```

2.  **Construa o JAR da aplicação:**
    ```bash
    ./mvnw package
    ```

3.  **Execute o JAR:**
    ```bash
    java -jar target/videomanager-0.0.1-SNAPSHOT.jar
    ```

A API estará disponível em `http://localhost:8080`.

## 📊 Monitoramento com Prometheus

Com a aplicação em execução, você pode acessar o endpoint de métricas, que está pronto para ser consumido por um servidor Prometheus.

- **URL do Endpoint:** `http://localhost:8080/actuator/prometheus`

## 📖 Endpoints da API

- `POST /videos`: Cria um novo vídeo.
- `GET /videos`: Retorna uma lista de todos os vídeos.
- `GET /videos/{id}`: Retorna um vídeo específico pelo seu ID.
- `PUT /videos/{id}`: Atualiza um vídeo existente.
- `DELETE /videos/{id}`: Deleta um vídeo.

### Exemplo de corpo para `POST /videos`:

```json
{
  "title": "Meu Vídeo Incrível",
  "description": "Uma descrição detalhada do vídeo.",
  "url": "https://www.youtube.com/watch?v=dQw4w9WgXcQ"
}
```

## 📄 Licença

Este projeto está licenciado sob a licença GNU.
