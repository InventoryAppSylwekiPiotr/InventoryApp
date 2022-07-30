insert into inventory (item, owner, place, inv_numb, description, add_date) values ('Tablica interaktywna', 'Jan Kowalski','sala 27', 'K234', 'Tablica firmy Samsung', '2014-11-11');
insert into inventory (item, owner, place, inv_numb, description, add_date) values ('Laptop', 'Anna Mała','sala 28', 'K300', 'Laptop firmy Samsung', '2014-10-12');
insert into inventory (item, owner, place,  inv_numb, description, add_date) values ('Rzutnik', 'Adam Kowalski','sala 1', 'K100', 'Rzutnik firmy Benq', '2020-10-10');

insert into role (id, name) values(1, 'ADMIN');
insert into role (id, name) values(2, 'USER');

insert into user (id, username, password) values(1, 'admin', '$2a$10$csIVj5k8CB74npTTstUQuO3ObjmaM6y8cRMxvsKqpHmT3zNQxY/IK');
insert into user (id, username, password) values(2, 'user', '$2a$10$m7BBzoGFKzb8e3/q5AK/SuC.qNKnyh.GcHkKnJYXsvJGQREhZe0Zu');

insert into user_role (user_id, role_id) values(1,1);
insert into user_role (user_id, role_id) values(2,2);