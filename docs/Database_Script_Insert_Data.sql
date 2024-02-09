select * from mother_organisations order by id desc;
select to_char(count(*), '9G999G999G999') from mother_organisations;

select * from companies order by id desc;
select to_char(count(*), '9G999G999G999') from companies;

select * from products;
select to_char(count(*), '9G999G999G999')
from products;


-- Step 1: Create lots of mother organisations
DO $$
    DECLARE
        i INTEGER;
    BEGIN
        FOR i IN 2..1001 LOOP
                DECLARE
                    var_name TEXT := 'The Mother of all ' || i || ' Organisation';
                    var_mother_org_nr TEXT := '' || (i + 100000000);
                BEGIN
                    INSERT INTO mother_organisations (name, mother_org_nr)
                    VALUES (var_name, var_mother_org_nr);
                END;
            END LOOP;
    END $$;


-- Step 2: Create lots of companies
DO $$
    DECLARE
        i INTEGER;
    BEGIN
        FOR i IN 2..1001 LOOP
                DECLARE
                    var_mother_org_id INT := i;
                    var_name TEXT := 'Rema ' || i;
                    var_company_org_nr TEXT := '' || (i + 900000000);
                BEGIN
                    INSERT INTO companies (mother_org_id, name, company_org_nr)
                    VALUES (var_mother_org_id, var_name, var_company_org_nr);
                END;
            END LOOP;
    END $$;

-- Step 3: Create lots of products for all of the companies
DO $$
    DECLARE
        j INTEGER;
        var_product_name TEXT;
        var_company_id INTEGER;
    BEGIN
        FOR var_company_id IN 2..1001 LOOP
            FOR j IN 2..1001 LOOP
                    CASE
                        WHEN j % 10 = 0 THEN var_product_name := 'Eple_0_' || (j + 10000);
                        WHEN j % 10 = 1 THEN var_product_name := 'Pære_1_' || (j + 10000);
                        WHEN j % 10 = 2 THEN var_product_name := 'Banan_2_' || (j + 10000);
                        WHEN j % 10 = 3 THEN var_product_name := 'Brød_3_' || (j + 10000);
                        WHEN j % 10 = 4 THEN var_product_name := 'Melk_4_' || (j + 10000);
                        WHEN j % 10 = 5 THEN var_product_name := 'Sjokolade_5_' || (j + 10000);
                        WHEN j % 10 = 6 THEN var_product_name := 'Vin_6_' || (j + 10000);
                        WHEN j % 10 = 7 THEN var_product_name := 'Pizza_7_' || (j + 10000);
                        WHEN j % 10 = 8 THEN var_product_name := 'Cola(Rød)_8_' || (j + 10000);
                        WHEN j % 10 = 9 THEN var_product_name := 'Mozarella_9_' || (j + 10000);
                        END CASE;

                    INSERT INTO products (company_id, name, description)
                    VALUES (var_company_id, var_product_name, 'Ingen beskrivelse');
                END LOOP;
            END LOOP;
    END $$;
