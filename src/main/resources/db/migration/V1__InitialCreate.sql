create table mother_organisations
(
    id            serial primary key not null,
    name          varchar(100)       not null,
    mother_org_nr varchar(9)         not null unique,
    description   varchar(255)       null default null
);

create table companies
(
    id             serial primary key not null,
    mother_org_id  int                null,
    name           varchar(255)       not null,
    company_org_nr varchar(9)         not null unique,
    constraint fk_mother_org foreign key (mother_org_id) references mother_organisations (id)
);

create table products
(
    id          serial primary key not null,
    company_id  int                not null,
    name        varchar(100)       not null,
    description varchar(255)       null,
    constraint fk_company foreign key (company_id) references companies (id)
);
