# VideoManager API

VideoManager é uma aplicação desenvolvida com Spring Boot que fornece uma API REST para gerenciamento de vídeos. Esta aplicação permite criar, listar, atualizar e deletar vídeos, facilitando a manipulação de dados relacionados a vídeos.

## Estrutura do Projeto

O projeto é organizado da seguinte forma:

```
VideoManager
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── videomanager
│   │   │               ├── VideoManagerApplication.java  # Ponto de entrada da aplicação
│   │   │               ├── controller
│   │   │               │   └── VideoController.java      # Controlador da API para vídeos
│   │   │               ├── service
│   │   │               │   └── VideoService.java         # Lógica de negócios para vídeos
│   │   │               ├── repository
│   │   │               │   └── VideoRepository.java      # Repositório para operações de CRUD
│   │   │               ├── model
│   │   │               │   └── Video.java                # Entidade de vídeo
│   │   │               ├── dto
│   │   │               │   └── VideoDto.java             # DTO para transferência de dados
│   │   │               └── exception
│   │   │                   └── NotFoundException.java     # Exceção personalizada
│   │   └── resources
│   │       ├── application.yml                             # Configurações da aplicação
│   │       └── data.sql                                    # Scripts SQL para inicialização do banco de dados
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── videomanager
│                       └── VideoControllerTest.java      # Testes unitários para o controlador
├── Dockerfile                                               # Instruções para construir a imagem Docker
├── docker-compose.yml                                      # Configuração dos serviços Docker
├── .dockerignore                                           # Arquivos a serem ignorados na construção da imagem Docker
├── .gitignore                                              # Arquivos a serem ignorados pelo Git
├── mvnw                                                   # Script para execução do Maven
├── mvnw.cmd                                               # Script para execução do Maven no Windows
├── pom.xml                                                # Configuração do Maven
└── README.md                                              # Documentação do projeto
```

## Como Executar

### Com Docker

Para executar a aplicação com Docker, utilize o Docker Compose:

```
sudo docker-compose up -d
```

A API estará disponível em `http://localhost:8080`.

### Localmente

1. **Clone o repositório:**
   ```
   git clone <URL_DO_REPOSITORIO>
   cd VideoManager
   ```

2. **Execute a aplicação:**
   ```
   ./mvnw spring-boot:run
   ```

3. **Acesse a API:**
   A API estará disponível em `http://localhost:8080`.

## Endpoints da API

- `POST /videos`: Cria um novo vídeo.
- `GET /videos`: Retorna todos os vídeos.
- `GET /videos/{id}`: Retorna um vídeo pelo ID.
- `PUT /videos/{id}`: Atualiza um vídeo existente.
- `DELETE /videos/{id}`: Deleta um vídeo.

## Monitoramento

A aplicação expõe métricas no formato Prometheus no endpoint `/actuator/prometheus`.

## Dependências

As dependências do projeto estão definidas no arquivo `pom.xml`.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.

## Licença

Este projeto está licenciado sob a MIT License. Veja o arquivo LICENSE para mais detalhes.