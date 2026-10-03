# E-Commerce Backend

A RESTful e-commerce backend built using **Spring Boot, Spring Data JPA, Hibernate, and PostgreSQL**.

The application provides product management, product search, and shopping cart operations through REST APIs. It is containerized using Docker and deployed on Render with a PostgreSQL database.

## 🚀 Live Deployment

**Base URL:**

https://ecom-backend-fgz8.onrender.com

### Quick API Tests

**Get all products**

```http
GET https://ecom-backend-fgz8.onrender.com/api/products
```

**Get product by ID**

```http
GET https://ecom-backend-fgz8.onrender.com/api/product/1
```

**Search products**

```http
GET https://ecom-backend-fgz8.onrender.com/api/products/search?keyword=Apple
```

**Create a cart**

```http
POST https://ecom-backend-fgz8.onrender.com/api/carts
```

**Get a cart**

```http
GET https://ecom-backend-fgz8.onrender.com/api/carts/1
```

> The Render service may take a few seconds to respond if it has been idle.

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Docker
- Docker Compose
- Render
- Postman

---

## ✨ Features

### Product Management

- Create products
- Retrieve all products
- Retrieve product by ID
- Update products
- Delete products
- Search products by name, brand, or category

### Shopping Cart

- Create cart
- Retrieve cart
- Add product to cart
- Update cart item quantity
- Remove product from cart
- Delete cart

### Database

- PostgreSQL database
- JPA/Hibernate ORM
- Entity relationships
- Product persistence
- Cart persistence
- Cart and CartItem relationship
- CartItem and Product relationship

### Deployment

- Dockerized Spring Boot application
- Docker Compose for local development
- PostgreSQL container for local development
- Render Web Service deployment
- Render PostgreSQL production database
- Environment-based database configuration

---

# 🔗 REST API Documentation

## Product APIs

### 1. Get All Products

**Method:** `GET`

**Endpoint:**

```text
/api/products
```

**Live URL:**

```text
https://ecom-backend-fgz8.onrender.com/api/products
```

---

### 2. Get Product By ID

**Method:** `GET`

**Endpoint:**

```text
/api/product/{prodId}
```

**Example:**

```text
https://ecom-backend-fgz8.onrender.com/api/product/1
```

---

### 3. Create Product

**Method:** `POST`

**Endpoint:**

```text
/api/product
```

**Example request body:**

```json
{
  "name": "OnePlus 13",
  "desc": "Android smartphone",
  "brand": "OnePlus",
  "price": 69999,
  "category": "Mobile",
  "available": true,
  "stockQuantity": 20
}
```

---

### 4. Update Product

**Method:** `PUT`

**Endpoint:**

```text
/api/product/{prodId}
```

**Example:**

```text
https://ecom-backend-fgz8.onrender.com/api/product/1
```

**Example request body:**

```json
{
  "name": "iPhone 15 Updated",
  "desc": "Updated Apple smartphone",
  "brand": "Apple",
  "price": 67999,
  "category": "Mobile",
  "available": true,
  "stockQuantity": 30
}
```

---

### 5. Delete Product

**Method:** `DELETE`

**Endpoint:**

```text
/api/product/{prodId}
```

**Example:**

```text
https://ecom-backend-fgz8.onrender.com/api/product/1
```

---

### 6. Search Products

**Method:** `GET`

**Endpoint:**

```text
/api/products/search?keyword={keyword}
```

**Example:**

```text
https://ecom-backend-fgz8.onrender.com/api/products/search?keyword=Apple
```

The search checks:

- Product name
- Brand
- Category

---

# 🛒 Cart APIs

## 1. Create Cart

**Method:** `POST`

**Endpoint:**

```text
/api/carts
```

**Live URL:**

```text
https://ecom-backend-fgz8.onrender.com/api/carts
```

**Example response:**

```json
{
  "id": 1,
  "items": []
}
```

---

## 2. Get Cart

**Method:** `GET`

**Endpoint:**

```text
/api/carts/{id}
```

**Example:**

```text
https://ecom-backend-fgz8.onrender.com/api/carts/1
```

---

## 3. Add Product to Cart

**Method:** `POST`

**Endpoint:**

```text
/api/carts/{cartId}/items
```

**Query Parameters:**

```text
productId
quantity
```

**Example:**

```text
https://ecom-backend-fgz8.onrender.com/api/carts/1/items?productId=2&quantity=2
```

---

## 4. Update Cart Item Quantity

**Method:** `PUT`

**Endpoint:**

```text
/api/carts/{cartId}/items/{productId}
```

**Example:**

```text
https://ecom-backend-fgz8.onrender.com/api/carts/1/items/2?quantity=3
```

---

## 5. Remove Product From Cart

**Method:** `DELETE`

**Endpoint:**

```text
/api/carts/{cartId}/items/{productId}
```

**Example:**

```text
https://ecom-backend-fgz8.onrender.com/api/carts/1/items/2
```

---

## 6. Delete Cart

**Method:** `DELETE`

**Endpoint:**

```text
/api/carts/{id}
```

**Example:**

```text
https://ecom-backend-fgz8.onrender.com/api/carts/1
```

---

# 🧪 Quick Interview Test

An interviewer can test the deployed application using the following sequence.

### Step 1 — Get Products

```http
GET https://ecom-backend-fgz8.onrender.com/api/products
```

### Step 2 — Search Products

```http
GET https://ecom-backend-fgz8.onrender.com/api/products/search?keyword=Apple
```

### Step 3 — Get Product

```http
GET https://ecom-backend-fgz8.onrender.com/api/product/1
```

### Step 4 — Create Cart

```http
POST https://ecom-backend-fgz8.onrender.com/api/carts
```

Note the returned cart ID.

### Step 5 — Add Product to Cart

Assuming the cart ID is `1`:

```http
POST https://ecom-backend-fgz8.onrender.com/api/carts/1/items?productId=2&quantity=2
```

### Step 6 — View Cart

```http
GET https://ecom-backend-fgz8.onrender.com/api/carts/1
```

### Step 7 — Update Quantity

```http
PUT https://ecom-backend-fgz8.onrender.com/api/carts/1/items/2?quantity=3
```

### Step 8 — Remove Product

```http
DELETE https://ecom-backend-fgz8.onrender.com/api/carts/1/items/2
```

---

# 🏗️ Project Structure

```text
ecom-proj/
│
├── src/
│   ├── main/
│   │   ├── java/com/rohith/ecom_proj/
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       └── data.sql
│   │
│   └── test/
│
├── Dockerfile
├── compose.yaml
├── .dockerignore
├── .gitignore
├── .env.example
├── pom.xml
├── mvnw
└── README.md
```

---

# 🐳 Running Locally with Docker

Clone the repository:

```bash
git clone https://github.com/Rohith4100/ecom-proj.git
cd ecom-proj
```

Start the application and PostgreSQL database:

```bash
docker compose up --build
```

The application will be available at:

```text
http://localhost:8080
```

Test the API:

```text
http://localhost:8080/api/products
```

Stop the containers:

```bash
docker compose down
```

---

# 🗄️ Database Configuration

The application uses PostgreSQL.

Database configuration is provided through environment variables:

```text
DB_URL
DB_USERNAME
DB_PASSWORD
```

Sensitive database credentials are not stored in the repository.

For local development, create a `.env` file based on:

```text
.env.example
```

---

# 🔍 API Testing

The REST APIs were tested using **Postman**.

Testing covered:

- GET requests
- POST requests
- PUT requests
- DELETE requests
- Request parameters
- JSON request bodies
- Response status codes
- CRUD operations
- Product search
- Cart operations
- Database persistence

---

# 📐 Architecture

The application follows a layered Spring Boot architecture:

```text
Client
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
PostgreSQL
```

### Controller

Handles HTTP requests and responses.

### Service

Contains application and business logic.

### Repository

Uses Spring Data JPA to communicate with the database.

### Model

Contains JPA entity classes representing database tables.

---

# 📊 Database Relationships

The main entities are:

```text
Cart
 │
 │ 1
 │
 │ *
 ▼
CartItem
 │
 │ *
 │
 │ 1
 ▼
Product
```

A cart can contain multiple cart items.

Each cart item references one product and stores its quantity.

---

# 🔮 Future Improvements

- User authentication and authorization
- Order management
- Payment integration
- Product pagination
- Advanced filtering and sorting
- Global exception handling
- Swagger/OpenAPI documentation
- Unit testing
- Integration testing
- CI/CD pipeline