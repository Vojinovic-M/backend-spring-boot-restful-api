drop schema if exists `springdb`;
create schema `springdb`;
use `springdb`;

create table `springdb`.`users`(
id int auto_increment primary key,
first_name VARCHAR(255) ,
last_name VARCHAR(255) ,
email VARCHAR(255) not null,
contact_number VARCHAR(255),
password VARCHAR(255) 
);

create table `springdb`.`tokens`(
id int auto_increment primary key,
token mediumtext,
token_type VARCHAR(255),
revoked tinyint(1),
refresh_token VARCHAR(255),
expired tinyint(1),
user_id int,
constraint `fk_user_id_tokens`
foreign key (user_id)
references users(id) on update cascade on delete restrict


);


create table `springdb`.`roles`(
id int auto_increment primary key,
name VARCHAR(255) not null
);
create table `springdb`.`user_roles`(
id int auto_increment primary key,
user_id int,
role_id int,
constraint `fk_users_id`
foreign key(user_id)
references users(id) on update cascade on delete restrict,
constraint `fk_role_id`
foreign key(role_id)
references roles(id) on update cascade on delete restrict
);

INSERT INTO `springdb`.`roles` (name) VALUES
('Employee');
INSERT INTO `springdb`.`roles` (name) VALUES
('Customer');

create table `springdb`.`products`(
id int auto_increment primary key,
name VARCHAR(255) not null,
price int,
user_id int,
constraint `fk_user_id`
foreign key(user_id)
references users(id) on update cascade 
);



create table `springdb`.`categories`(
id int auto_increment primary key,
name VARCHAR(255) not null
);
create table `springdb`.`product_categories`(
id int auto_increment primary key,
product_id int not null,
category_id int not null,
constraint `fk_product_id`
foreign key(product_id)
references products(id) on update cascade on delete restrict,
constraint `fk_category_id`
foreign key(category_id)
references categories(id) on update cascade on delete restrict
);

INSERT INTO `springdb`.`users` (first_name, last_name, email,contact_number) VALUES
('Matej', 'Matejevic', 'matej@gmail.com','0651515155');
INSERT INTO `springdb`.`users` (first_name, last_name, email,contact_number, password) VALUES
('Marko', 'Markovic', 'marko@gmail.com','0633333333', 'marko');
INSERT INTO `springdb`.`users` (first_name, last_name, email,contact_number) VALUES
('Luka', 'Lukic', 'luka@gmail.com','0606060606');
INSERT INTO `springdb`.`users` (first_name, last_name, email,contact_number) VALUES
('Jovan', 'Jovanovic', 'jovan@gmail.com','0601212121');



INSERT INTO `springdb`.`products` (name, price, user_id) VALUES
('Lenovo L28u-35', 35000, 1), 
('Microsoft Surface Laptop 4', 85000, 1),
('Xiaomi 11T Pro', 65000, 1);