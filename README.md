# ⚽Football Tickets App

Hello! My name is Danylo Krupnyk and I am Java Developer! 

This is my RESTful project that provides service for users willing to buy some football tickets!
The project is made in accordance with the so-called three-tier development dividing the entire business application into:
- Presentation layer-business logic (controllers)
- Application layer (services)
- Data access layer (DAO)

Layering is to achieve "high cohesion, low coupling". The idea of "divide and conquer" is adopted to divide the problem into individual solutions, which is easy to control, easy to extend, and easy to allocate resources. 

In order to incorporate authentication and authorization possibilities there are different role levels in the project (admin, user) and these roles have different permitions! 

**Unauthorized user is allowed to:**
- registrate
- see all available sessions and information it
- search movie session by date

**Role "User" is allowed to:**
- book and buy tickets
- see history of all orders made by him

**Admin is allowed to:**
- add and edit information about movies, cinema halls, movie sessions
- search information about the user by e-mail

## 🔧Install it by yourself and try
- Download this project (clone and open in your IDE).
- Configure database connection via "src/main/resources/db.properties" and set your data.
- Add Tomcat configuration in your IDE and set deployment - "war_exploded" and application context - "/".
- Run Tomcat
- Users will be added automatically after Tomcat start. Log in as Admin: (login: "alice@gmail.com", password:"4321"), User: (name: "bob@gmail.com", password:"1234")

## 👨‍💻Technologies trained
- Spring - Core, MVC, Web, Security
- Hibernate Framework
- MySQL
- Maven
- Tomcat
- Json
- Postman
- Lombok

## 📝Contact me
- [Telegram](https://t.me/DKrupnyk)
- [LinkedIn](http://www.linkedin.com/in/danyloKrupnyk)
- [Skype](https://join.skype.com/invite/IX5MwBVFkWTg)
- [CodeWars](https://www.codewars.com/users/Danylo24)
