# Shipping

## Description

The Shipping microservice is a fictitious shipping service that does nothing but receive messages from the Order microservice and randomly sends an event indicating the success or failure of a shipment. It was developed as part of a course project on creating microservices using RabbitMQ for communication between services.

## Technologies Used

- Programming Language: Java with Spring Boot
- Message Queue: RabbitMQ
- Containerization: Docker

## Installation and Configuration

1. Clone the GitHub repository:

```bash
git clone git@github.com:RedbeanGit/polyshop-shipping.git
```

2. Install Docker and Docker Compose on your machine if you haven't already. You can follow the installation instructions on Docker's official website: https://docs.docker.com/get-docker/ and https://docs.docker.com/compose/install/.

3. Navigate to the Shipping microservice directory:

```bash
cd polyshop-shipping
```

4. Launch Docker Compose to start the necessary containers:

```bash
docker-compose up -d
```

**Now you can choose to run the Shipping service inside a docker container or directly on your host.**

### Running with docker

5. Build the Docker image for the microservice using the provided Dockerfile:

```bash
docker build -t polyshop-shipping .
```

6. Run the container from the image you have just builded:

```bash
docker run --name polyshop_shipping polyshop-shipping
```

### Running on host

5. Start Spring Boot application:

```bash
./mvnw spring-boot:run
```

## Message Queue

The Shipping microservice listens for messages from the Order microservice and sends events upon successful or unsuccessful shipments.
