# 🚍 Student Transport Booking System

A backend-based Student Transport Booking System developed using **Java Spring Boot** and **MySQL**. The system provides a platform where students can book transport trips while drivers register vehicles, manage trips, process bookings, generate tickets, and handle payments.

> 🚧 **Frontend Currently Under Development**
>
> This repository currently contains the complete backend implementation. A frontend will be integrated in a future update.

---

# 📌 Project Overview

This project was developed to simulate a real-world university transport booking system.

The system allows:

* Students to register and log in
* Drivers to register and activate their accounts by registering a vehicle
* Drivers to create and manage transport trips
* Students to book available transport trips
* Process transport payments
* Generate transport tickets
* Maintain secure relationships between all database entities

The application follows a clean layered architecture using **Controllers, Services, Repositories, DTOs, and Entity classes**.

---

# 🛠️ Technologies Used

## Backend

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* Maven

## Database

* MySQL

## Development Tools

* IntelliJ IDEA
* MySQL Workbench
* Postman
* Git
* GitHub

---

# 🚀 Getting Started

## Prerequisites

Before running the project, ensure you have:

* Java 17
* Maven
* MySQL Server
* IntelliJ IDEA (Recommended)

---

## Clone the Repository

```bash
git clone https://github.com/Bubele-Ernest-Mtsora/student-transport-booking-system.git
```

---

## Configure the Database

Create a MySQL database named:

```sql
CREATE DATABASE transport_db;
```

Update your `application.properties` file with your own MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/transport_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

---

## Run the Application

Using Maven:

```bash
mvn spring-boot:run
```

Or run the project directly from IntelliJ IDEA.

The application will start at:

```
http://localhost:8080
```

---

# 📂 Project Structure

```
src
│
├── Controller
├── Service
├── Repository
├── Entity
├── DTO
└── Resources
```

The project follows a clean layered architecture that separates business logic, database access, and API endpoints.

---

# 📚 Features

## 👨‍🎓 Student

* Register account
* Login
* Book transport trips
* View bookings
* Make payments
* Receive transport ticket

---

## 🚗 Driver

* Register account
* Login
* Register vehicle
* Driver status automatically changes from:

```
PENDING → ACTIVE
```

* Manage transport trips

---

## 🚙 Vehicle

* Vehicle registration
* One Driver ↔ One Vehicle relationship

---

## 🚌 Trip

* Create trip
* Departure location
* Destination location
* Departure date
* Departure time
* Available seats
* Trip price

---

## 📅 Booking

* Student books a transport trip
* Links Student and Trip

---

## 💳 Payment

* Payment linked to Booking

---

## 🎫 Ticket

* Generated after successful booking/payment

---

# 🗄️ Database Design

The project uses MySQL with a relational database design.

Relationships include:

* Student → Booking
* Driver → Vehicle
* Driver → Trip
* Vehicle → Trip
* Trip → Booking
* Booking → Payment
* Booking → Ticket

---

# 📊 Entity Relationship Diagram (ERD)


```

---

# 📸 Database Preview


---

# 🔌 REST API

### Student

```
POST /api/students/create
POST /api/students/login
```

### Driver

```
POST /api/drivers/create
POST /api/drivers/login
```

### Vehicle

```
POST /api/vehicles/create
```

### Trip

```
POST /api/trips
```

### Booking

```
POST /api/bookings
```

### Payment

```
POST /api/payments
```

### Ticket

```
POST /api/tickets
```

---

# 📖 Business Rules

* One driver can register only one vehicle.
* Driver status changes from **PENDING** to **ACTIVE** after vehicle registration.
* Each booking belongs to one student and one trip.
* Each payment belongs to one booking.
* Each ticket is generated from a booking.

---

# 🚀 Future Improvements

* Frontend Implementation
* JWT Authentication
* Spring Security
* Role-Based Authorization
* Email Notifications
* Trip Search & Filtering
* Online Payment Gateway Integration

---

# 👨‍💻 Author

**Bubele Ernest Mtsora**

BCom Information Systems (Honours)

Aspiring Software Engineer | Java Backend Developer

**Skills**

* Java
* Spring Boot
* REST APIs
* MySQL
* Git
* GitHub

GitHub:

https://github.com/Bubele-Ernest-Mtsora

---

# ⭐ Project Status

✅ Backend Completed

🚧 Frontend In Progress

📌 Continuous Improvements Ongoing
