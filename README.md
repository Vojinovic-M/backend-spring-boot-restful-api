# REST API using Spring Boot and MySQL database

*A simple project that demonstrates useful backend logic implemented through modern technologies.*

**CURRENT UPDATES:**

Developing NextJS frontend on a different repository [frontend-next-js](https://github.com/Vojinovic-M/frontend-next-js)
Expanded on signup requirements

**Explanation:**

The project uses `UserController`/`ProductController` as listeners for user inputs through methods (`get-list`, `get-user-products-list`, `get-page-list`, `create`, `update`, `delete` in _UserController_, and `get-list`, `create-product`, `update-product`, `delete-product` in _ProductController_).

These methods are mapped by interfaces (`IUserService`, `IProductService`) then implemented through their services (`UserService`, `ProductService`). Services also include `JwtService` for generating and validating tokens, as well as `AuthenticationService`.

Using _Dependency Injection_ (DI), a service can access a repository and call its methods. Repositories included are `IProductRepository`, `IUserProductsRepository`, and `IUserRepository`.
The repository uses predefined queries in order to pull data through entities (_Category_, _Product_, _Role_, _User_, _UserProducts_) from the database (_springdb.sql_).

Finally, the repository maps the data gotten from the entity to the model. Reaching the model, voila, request results are shown to the user!

**I recommend approaching the application through the Postman platform for the moment while the frontend is still in development.**
To have access to the functions, the user must sign up (POST auth/signup) and reenter the credentials (POST auth/login). That will generate a token which should be entered in the Authorization tab of Postman (Bearer Token) on the tabs where you're using different endpoints.

Available endpoints at the moment: </br>

POST auth/signup </br>
POST auth/login </br></br>

GET user/get-list </br>
GET user/get-user-products-list </br>
GET user/get-page-list </br>
POST user/create </br>
POST user/update </br>
DELETE user/delete?id=[ID OF USER YOU WANT TO DELETE] </br> </br>

GET product/get-list </br> 
POST product/create-product</br>
POST product/update-product </br>
DELETE product/delete-product?id=[ID OF USER YOU WANT TO DELETE] </br>


This can be expanded on further by adding more functions or adding a frontend application. I welcome fellow developers to add their own features to this project!
