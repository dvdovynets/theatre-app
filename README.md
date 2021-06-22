# Theatre-app(in progress)
In this project I am building a web application, that theatres can use as an online service. Visitors could check available sessions, buy tickets and reserve their seats.
I am developing it using a stack of Hibernate and Spring. I am trying to follow all principles of SOLID, and use N-tier architecture which consist of: DataBase, DAO, Service, Controllers and View layers. It will have authentication and authorization functions with the help of roles. 

## **Main functions that will be available:**

- **Guest (without any role)**
  - registration (in progress)
  - authentication and authorization (in progress)
  - view of all available performances
  - view of all theatre stages 
  - search of relevant performance sessions by date

- **User**
  - all endpoints of the guest are available
  - adding of the ticket for performance to the shopping cart (in progress)
  - view of all the tickets in the shopping cart(in progress)
  - processing order (in progress)
  - view of history of all the orders (in progress)

- **Admin**
  - all endpoints of the guest are available
  - ability to edit schedule
  - adding of new performances
  - opening and closure of new stages
  - revealing information about user by e-mail (in progress)

## **Technologies used**

- Spring - Core / MVC / Web / Security
- Hibernate
- RDBMS - MySQL
- Packaging - Apache Maven
- Tomcat
- JSON

## **Configuration:**

- Сlone this project into your local folder and open the project in an IDE.
- Add Tomcat Configuration with "theatre-app:war exploded" and aplication context as "/"
- Setup new connection with
  - user: "your username"
  - password: "your password"
  - url: jdbc:mysql://host:port/nameOfDataBase?serverTimezone=UTC , where:    
- Run a project
