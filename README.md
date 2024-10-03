# REST API using Spring Boot and MySQL database

**Explanation:**

I'm using a **controller** as a **listener** for user input through set **methods**.
These **methods** are **mapped** by **services**.
Using **dependency injection**, a **service** can access a **repository** and call its methods.
The **repository** uses **queries** in order to **pull data** through **entities** from the **database**.
Finally, The repository maps the data gotten from the entity to the model.
This can be expanded on further by adding more functions, more validators or adding a frontend application. 

I use generated tokens for user authentication.


*A simple project that demonstrates useful backend logic implemented through modern technologies.*

**I recommended approaching the application through the Postman platform.**
