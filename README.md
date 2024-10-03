# REST API using Spring Boot and MySQL database

*A simple project that demonstrates useful backend logic implemented through modern technologies.*

**Explanation:**

The project uses `UserController`/`ProductController` as listeners for user inputs through methods (`get-list`, `get-user-products-list`, `get-page-list`, `create`, `update`, `delete` in _UserController_, and `get-list`, `create-product`, `update-product`, `delete-product` in _ProductController_).

These methods are mapped by interfaces (`IUserService`, `IProductService`) then implemented through their services (`UserService`, `ProductService`). Services also include `JwtService` for generating and validating tokens, as well as `AuthenticationService`.

Using _Dependency Injection_ (DI), a service can access a repository and call its methods. Repositories included are `IProductRepository`, `IUserProductsRepository`, and `IUserRepository`.
The repository uses predefined queries in order to pull data through entities (_Category_, _Product_, _Role_, _User_, _UserProducts_) from the database (_springdb.sql_).

Finally, the repository maps the data gotten from the entity to the model. Reaching the model, voila, request results are shown to the user!

**I recommended approaching the application through the Postman platform.**

This can be expanded on further by adding more functions or adding a frontend application. I welcome fellow developers to add their own features to this project!
