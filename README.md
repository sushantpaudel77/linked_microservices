## 🛠️ TODO: Externalized Configuration with Spring Cloud Config

📌 **Note:** Currently, all microservices use **hardcoded or local `application.yml` files** for configuration.  
To improve maintainability and enable centralized configuration management:

- [ ] Integrate a **Spring Cloud Config Server**
- [ ] Move all service-specific properties (ports, DB credentials, Kafka topics, etc.) to a shared config repo
- [ ] Connect each microservice to fetch configuration from the Config Server at startup
- [ ] (Optional) Add support for dynamic refresh using Spring Actuator + Bus

🔗 Official Docs: [Spring Cloud Config](https://spring.io/projects/spring-cloud-config)

# 🐳 LinkedIn Backend Microservices — Full Docker Compose Stack

This is a complete **monolithic `docker-compose.yml` setup** for my LinkedIn backend clone.

It includes:

- Kafka & Kafbat UI
- PostgreSQL Databases
- Neo4j (Graph DB for Connections)
- Spring Boot Microservices
- Eureka Discovery Server
- API Gateway

> ✅ **Note**: I’ve modularized this setup into **three smaller Compose files** for better management in most workflows.

This file serves as an **all-in-one alternative** — ideal for **quick local testing** or when a unified stack is easier to manage.

---

## 🔀 See the Modular Files

For advanced or staged deployments, use the split Compose files:

- [`docker-compose.base.yml`](./docker-compose.base.yml)
- [`docker-compose.kafka-zipkin.yml`](./docker-compose.kafka-zipkin.yml)
- [`docker-compose.posts-user.yml`](./docker-compose.posts-user.yml)

---

## 🚀 How to Run

### 🔧 Split Compose Files (Recommended)

```bash
docker compose -f docker-compose.base.yml \
               -f docker-compose.kafka-zipkin.yml \
               -f docker-compose.posts-user.yml up

🧱 All-in-One Compose
docker-compose up --build

☸️ Kubernetes Deployment
kubectl apply -f k8s/

⚙️ Resource Configuration
Kubernetes resource limits and requests can be adjusted based on your environment's needs to optimize performance and resource usage.
For example, in ./k8s/connections-db.yml:

resources:
  limits:
    memory: "1024Mi"
    cpu: "500m"
  requests:
    memory: "512Mi"
    cpu: "200m"
requests define the minimum guaranteed resources.


🔐 Secrets & Environment Variables
env
Copy
Edit
JWT_SECRET_KEY=my_super_secret_key

🧠 Monitoring & Debugging
Tool	URL	Notes
Eureka Dashboard	http://localhost:8761	Service registration monitor
Kafbat UI	http://localhost:8090	View topics, messages
Neo4j Browser	http://localhost:7474	Graph DB for connections
Zipkin (Optional)	Add tracing support later	Distributed tracing


📦 Microservices Overview
Service	Port	Description
🧭 API Gateway	8080	Entry point for all requests
🧬 Discovery Server	8761	Eureka registry for service discovery
👤 User Service	9011	Handles user authentication & profiles
📝 Posts Service	9010	Manages posts and user feed
🔔 Notifications	9012	Sends and stores notifications
🔗 Connections	9013	Manages user connections (Neo4j)

🧪 Testing & Validation
Use the following tools to test and validate the setup:
🧪 Postman / Thunder Client for REST API testing
🛰️ Kafbat UI to inspect message topics and brokers
🌐 Eureka Dashboard to verify microservice registration
📜 Logs via Docker or K8s to debug errors or issues

👤 Author
Sushant Paudel
🔗 GitHub
🐳 DockerHub

💬 Feel free to fork, contribute, or raise issues! This project is built for learning and scale experimentation.
