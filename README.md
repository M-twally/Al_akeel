# Al-Akeel - Food Delivery Backend (Java EE)

A Java EE REST backend for a **food-delivery platform** with four roles: **customers**, **restaurant owners**, **runners** (delivery couriers) and admins. Built with Maven and deployed as a WAR on JBoss / WildFly.

## Features

| Role | What they can do |
|---|---|
| **Customer** | Sign up / sign in, list restaurants, **make an order**, add or remove meals on an existing order, cancel an order, view order details |
| **Restaurant owner** | Sign up / sign in, add a restaurant, add / update / delete meals, view a restaurant and its **report** |
| **Runner** | Sign up / sign in, mark orders, view trips |

- Role-based access check (`UserPolicy`) - users must sign in and have the right role for each action
- JSON output models for meals, orders, restaurants and runners
- JPA persistence unit (`taskRedHat`) on the server's example datasource, schema created automatically

## REST resources

| Path | Description |
|---|---|
| `/customer` | `/signUP`, `/signIN`, `/MakeOrder/{id}`, `/EditOrderByAdd/{id}`, `/Delete/{id}`, `/cancelOrder/{id}`, `/showAllResturant`, `/showOrderByID/{id}` |
| `/owner` | `/signUP`, `/signIN`, `/AddResturant`, `/AddMeal/{id}`, `/{restaurantId}/AddMeal/{mealId}`, `/showResByID/{id}`, `/{restaurantId}/deletemeals/{mealId}`, `/ReportResByID/{id}` |
| `/runner` | `/signUP`, `/signIN`, `/mark`, `/Trips` |

## Tech stack

- Java, Maven (`war`), Java EE 7 (EJB, CDI, JPA, JAX-RS)
- Hibernate (via the application server), JSON output models

## Project structure

```
src/main/java/
├── com/lab/task/
│   ├── model/     # User, Orders, meal, resturant, Runner
│   ├── repo/      # JPA repositories
│   └── service/   # customerService, restaurantOwnerService, RunnerService, App
├── helper/        # UserPolicy, constants, helpers
├── JsonOutput/    # response models
└── META-INF/persistence.xml
```

## Build and run

```bash
mvn clean package
# deploy target/*.war to WildFly / JBoss EAP, then call the endpoints above
```

Requires JDK 8+, Maven 3 and a Java EE 7 application server.
