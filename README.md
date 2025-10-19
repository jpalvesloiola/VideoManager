
# 📽️ Projeto VideoManager com Spring Boot e Docker

Bem-vindo ao repositório do VideoManager, uma API REST para gerenciamento de vídeos, construída com Spring Boot, Docker e diversas tecnologias modernas para facilitar o desenvolvimento, deploy e monitoramento.

## 🧩 Visão Geral

* 🚀 **Objetivo:** Criar uma API para cadastro, armazenamento, conversão e monitoramento de vídeos.
* 🛠️ **Tecnologias:** Java, Spring Boot, MySQL, Docker, AWS (EC2, S3), Prometheus, Grafana, FFmpeg.


## ⚙️ Funcionalidades

* 🎞️ Cadastro e gerenciamento de vídeos com metadados.
* 🐳 Containerização da aplicação e banco com Docker.
* ☁️ Deploy na AWS com EC2 e armazenamento em S3.
* 📊 Monitoramento com Prometheus e dashboards no Grafana.
* 🔄 Conversão e processamento de vídeos usando FFmpeg.


## 📂 Estrutura do Repositório

```
videomanager/
├── src/
│   └── main/java/com/example/videomanager/
│       ├── controller/
│       ├── service/
│       ├── model/
│       └── repository/
├── Dockerfile
├── docker-compose.yml
├── prometheus.yml
├── README.md
```

## 🚀 Como Começar

1. Clone o repositório:
   ```
   git clone https://github.com/seuusuario/videomanager.git
   cd videomanager
   ```
3. Configure o banco MySQL no [`docker-compose.yml`](https://docker-compose.yml).  
4. Construa e rode os containers:
   ```
   docker-compose up --build
   ```
6. Acesse a API em `http://localhost:8080`.

## 📚 Referências

* [Spring Boot para Iniciantes](https://douglasnickson.com.br/2025/09/14/spring-boot-para-iniciantes-construindo-apis-rest-do-zero/) 🟦  
* [Guia Docker para API Java](https://dev.to/diegobrandao/guia-passo-a-passo-deploy-de-uma-api-rest-java-no-docker-33mp) 🐳  
* [Deploy Java na AWS](https://comoprogramarjava.com.br/deploy-de-aplicacoes-java-na-aws/) ☁️  
* [Monitoramento com Grafana e Prometheus](https://codeinloop.com.br/fazendo-monitoramento-de-suas-apps-com-grafana-prometheus-via-docker/) 📊  
* [Comandos FFmpeg](https://mundobytes.com/pt/Comandos-pr%C3%A1ticos-com-FFMPEG-para-converter-formatos-no-Linux/) 🎬  


## 🤝 Contribuição

Contribuições são bem-vindas! Abra issues ou pull requests para melhorias e correções.

## 📄 Licença

Este projeto está licenciado sob a licença GNU.

*Obrigado por visitar o VideoManager!*
