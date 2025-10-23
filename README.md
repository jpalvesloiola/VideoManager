# 📽️ VideoManager API

A RESTful API for managing videos, built with Java 21, Spring Boot 3, and MySQL 8. The project is fully containerized with Docker and exposes metrics for monitoring with Prometheus.

## ✅ Technologies Used

- **Java 21**
- **Spring Boot 3** (Web, Data JPA, Validation, Actuator)
- **MySQL 8.0**
- **Hibernate 6**
- **Maven**
- **Docker & Docker Compose**
- **Micrometer & Prometheus** for metrics

## ⚙️ Prerequisites

- Java 21+
- Maven 3.8+
- Docker
- Docker Compose

## 🚀 How to Run the Project

There are two ways to run the application:

### 1. Using Docker Compose (Recommended)

This is the simplest method. It will build the application image and start the API and database containers at once.

1.  **Build the application JAR:**
    ```bash
    cd videomanager
    ./mvnw package
    ```

2.  **Start the containers:**
    ```bash
    sudo docker-compose up -d
    ```

The API will be available at `http://localhost:8080`.

### 2. Running Locally

This method is useful for development and debugging.

1.  **Start the database with Docker:**
    ```bash
    cd videomanager
    sudo docker-compose up -d db
    ```

2.  **Build the application JAR:**
    ```bash
    ./mvnw package
    ```

3.  **Run the JAR:**
    ```bash
    java -jar target/videomanager-0.0.1-SNAPSHOT.jar
    ```

The API will be available at `http://localhost:8080`.

## 📊 Monitoring with Prometheus

With the application running, you can access the metrics endpoint, which is ready to be consumed by a Prometheus server.

- **Endpoint URL:** `http://localhost:8080/actuator/prometheus`

## 📖 API Endpoints

- `POST /videos`: Creates a new video.
- `GET /videos`: Returns a list of all videos.
- `GET /videos/{id}`: Returns a specific video by its ID.
- `PUT /videos/{id}`: Updates an existing video.
- `DELETE /videos/{id}`: Deletes a video.

### Example body for `POST /videos`:

```json
{
  "title": "My Awesome Video",
  "description": "A detailed description of the video.",
  "url": "https://www.youtube.com/watch?v=dQw4w9WgXcQ"
}
```

## 📄 License

This project is licensed under the GNU license.
