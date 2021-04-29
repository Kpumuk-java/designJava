create table users (
    id                      bigserial primary key,
    name                    varchar(30) not null unique,
    age                     int
);

insert into users (name, age)
values
('bob', 25),
('john', 34);