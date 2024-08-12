# Fraud Detector Microservices Application
## Overview
This project is a microservices-based application that includes services for customer management, fraud detection, and notifications. 
It leverages Docker for containerization, message queues for asynchronous communication, and various databases for data persistence.

## Architecture
The application architecture is divided into the following components:

- Load Balancer: Routes incoming requests to the appropriate microservice.
- Fraud Service: Handles fraud detection logic and stores data in MongoDB.
- Customer Service: Manages customer information and stores data in PostgreSQL.
- Notification Service: Stores notifications in PostgreSQL.
- Message Queue: RabbitMQ are used for asynchronous communication between services.
- Eureka Server: For service discovery.
- Config Server: Manages configuration for the microservices.
- Private Docker Registry: Stores Docker images for the services.
- Sleuth and Zipkin: For distributed tracing of the services.
