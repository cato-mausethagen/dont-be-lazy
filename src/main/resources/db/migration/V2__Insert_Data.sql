insert into mother_organisations (name, mother_org_nr, description)
values ('Reitan Handel AS', '914526647', null);

insert into companies (mother_org_id, name, company_org_nr)
values ((select id from mother_organisations where mother_org_nr = '914526647'),
        'Rema 1000',
        '982254604');

insert into products (company_id, name, description)
values ((select id from companies where company_org_nr = '982254604'),
        'Bananer',
        null);