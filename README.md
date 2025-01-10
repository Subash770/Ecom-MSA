# Revshop Microservice [Ecom-MSA]

Revshop is a scalable e-commerce application developed using a microservices architecture with Spring Boot. It includes separate services for products, orders, carts, users, and payments, ensuring modularity and efficient service management.

## Features
- **Microservices Architecture**: Each service is independently deployable and scalable.
- **Spring Boot Framework**: For rapid development and deployment.
- **Eureka Service Discovery**: Used for service registration and discovery.
- **RestTemplate**: For inter-service communication.
- **Database Separation**: Ensures each service has its own database, enhancing modularity.
- **Docker and Kubernetes**: For containerization and orchestration (if applicable).

## Services
1. **Product Service**: Manages product details and inventory.
2. **Order Service**: Handles order creation, tracking, and history.
3. **Cart Service**: Manages user cart items.
4. **User Service**: Manages user authentication and profiles.
5. **Payment Service**: Handles payment processing and transactions.

## Technologies Used
- Java
- Spring Boot
- Spring Cloud (Eureka, Config Server, etc.)
- MySQL
- RestTemplate

## Installation and Setup
1. Clone the repository:
    ```bash
    git clone https://github.com/Subash770/Ecom-MSA.git
    cd Ecom-MSA
    ```

2. Build the project:
    ```bash
    mvn clean install
    ```

3. Run each microservice:
    ```bash
    cd <microservice-folder>
    mvn spring-boot:run
    ```

4. Access the services:
    - Product Service: `http://localhost:<product-service-port>`
    - Order Service: `http://localhost:<order-service-port>`
    - Cart Service: `http://localhost:<cart-service-port>`
    - User Service: `http://localhost:<user-service-port>`
    - Payment Service: `http://localhost:<payment-service-port>`

## Screenshots
![Revshop Products](https://raw.githubusercontent.com/Subash770/Ecom-MSA/main/Revshopsi.png)
![Revshop Products](https://raw.githubusercontent.com/Subash770/Ecom-MSA/main/Revshopsii.png)
![Revshop Products](https://raw.githubusercontent.com/Subash770/Ecom-MSA/main/RevshopProducts.png)

## Contribution
Feel free to fork this repository and contribute by submitting a pull request. For any issues, you can create an issue on GitHub.

## Contact
For any inquiries or questions, you can reach out to [Subash R.](mailto:ssubash2651@example.com).
