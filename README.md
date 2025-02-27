# Spring Boot Microservices

## 👨‍💻 Author
**Muhammad Fikri Nur Sya'Bani**  
NIM: 221524019

Repository ini berisi implementasi **Spring Boot Microservices** berdasarkan tutorial dari channel YouTube **Programming Techie**.

## 📌 Features
- **Product Service** (CRUD Produk)
- **Order Service** (Pemesanan Produk)
- **Inventory Service** (Cek Ketersediaan Produk)
- **Discovery Server** (Eureka Server untuk service registry)
- **API Gateway** (Routing ke berbagai service)
- **Resilience4j Circuit Breaker** (Menangani error dan timeout)
- **MongoDB & PostgreSQL** (Database untuk masing-masing service)
- **Docker & Kubernetes** (Containerization & Deployment)
- **Kafka Event-Driven Architecture**

## ⚙️ Requirements
Pastikan kamu sudah menginstal:
- **Java 17** atau lebih baru
- **Maven**
- **Docker & Docker Compose**
- **PostgreSQL** (untuk Order Service)
- **MongoDB** (untuk Product Service)
- **Apache Kafka** (untuk event-driven communication)

## 🚀 Cara Install dan Menjalankan
### 1️⃣ Clone Repository
```sh
git clone https://github.com/username/repository-name.git
cd repository-name
```

### 2️⃣ Jalankan Service Database dan Kafka (Opsional)
Jika menggunakan Docker, jalankan command berikut:
```sh
docker-compose up -d
```
Atau jalankan manual:
```sh
# Start MongoDB
docker run -d --name mongodb -p 27017:27017 mongo

# Start PostgreSQL
docker run -d --name postgres -p 5432:5432 -e POSTGRES_USER=root -e POSTGRES_PASSWORD=root -e POSTGRES_DB=order_db postgres

# Start Kafka & Zookeeper
docker-compose -f kafka-docker-compose.yml up -d
```

### 3️⃣ Jalankan Microservices
Jalankan masing-masing service secara terpisah:
```sh
# Discovery Server
docker-compose -f discovery-server.yml up -d

# API Gateway
mvn spring-boot:run -pl api-gateway

# Product Service
mvn spring-boot:run -pl product-service

# Inventory Service
mvn spring-boot:run -pl inventory-service

# Order Service
mvn spring-boot:run -pl order-service
```

### 4️⃣ Cek di Browser atau Postman
- **Eureka Dashboard** → [http://localhost:8761](http://localhost:8761)
- **API Gateway** → [http://localhost:8080](http://localhost:8080)
- **Product API** → [http://localhost:8080/api/product](http://localhost:8080/api/product)
- **Order API** → [http://localhost:8080/api/order](http://localhost:8080/api/order)

## 🐳 Deployment dengan Docker
Build image untuk masing-masing service:
```sh
mvn clean package -DskipTests
```
Lalu build dan jalankan container:
```sh
docker-compose -f docker-compose.yml up -d --build
```

## 🔥 Troubleshooting
1. **Port sudah digunakan** → Pastikan tidak ada service lain yang berjalan di port yang sama.
2. **Kafka tidak bisa konek** → Pastikan Kafka & Zookeeper sudah berjalan.
3. **Database error** → Cek koneksi MongoDB dan PostgreSQL.

---
