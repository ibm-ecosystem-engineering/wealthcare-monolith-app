# Wealthcare Monolith Application

## Personas

The application consists of the below 3 Personas.

#### Business Manager

Business Manager can do the following operations.

- Creates Wealth manager
- Creates Customer 
- Assign Wealth manager to the customer

#### Wealth Manager

Wealth Manager can do the following operations.

- Manage financial plan for Customer

	Create Goals

	Create Investment
- View Customer Portfolio
- View Customer profile

#### Customer

Customer can do the following operations.

- View Financial Plan
- View Portfolio
- View Profile


## Database

Wealthcare application uses DB2 database.

#### Schema definitions

Schema definitions are given for 3 databases.

- sql/schema-db2.sql

You can run this schema and create database. 

#### Data

Table data is given in the below file. This is common for all the databases

- sql/data.sql

You can run this data.sql and create data in database. 

#### Database Configuration in application.properties

The database configuration to be done in the below property file.

```
wcareEJB/ejbModule/META-INF/persistence.xml
```

## License

The Wealthcare monolith Application is licensed under Apache-2.0 License.

## Tools and Technologies

- Java
- EJB
- Websphere
- DB2 database