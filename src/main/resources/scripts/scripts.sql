create table if not exists student {
    student_id bigint primary key,
    first_name text not null,
    last_name text not null,
    email text unique not null,
 };
--pozniej dopisac jeszcze foreign key-e, ale najpierw utworzyć pod-tabele do studenta

create table [if not exists] osiagniecia {
    osiagniecia_id bigint primary key,
    nazwa text not null,
    opis text
};

select nspname
from pg_catalog.pg_namespace; --to show list of all schemas