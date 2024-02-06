create table companies
(
    id          int primary key not null,
    name        varchar(255) not null,
    org_nr      varchar(11) not null
);

create table employees
(
    id          int primary key not null,
    first_name  varchar(100) not null,
    family_name varchar(255) not null
);