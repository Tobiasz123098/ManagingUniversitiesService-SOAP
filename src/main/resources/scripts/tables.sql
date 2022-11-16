--create table student (
--    id bigint primary key,
--    first_name text not null,
--    last_name text not null,
--    email text unique not null
-- );

create table uniwersytet (
    id bigint not null
);

create table sala (
    id bigint primary key,
    numer_sali smallint not null,
    uniwersytet_id bigint not null
);

create table prowadzacy (
    id bigint primary key,
    imie text not null,
    nazwisko text not null,
    email text unique not null,
    tytul text not null,
    uniwersytet_id bigint not null
);

create table student (
    id bigint primary key,
    imie text not null,
    nazwisko text not null,
    email text unique not null,
    uniwersytet_id bigint not null,
    index_id bigint not null
);
--pozniej dopisac jeszcze foreign key-e, ale najpierw utworzyć pod-tabele do studenta

create table osiagniecie (
    id bigint primary key,
    nazwa text not null,
    opis text,
    rodzaj_osiagniecia text not null,
    student_id bigint not null
);

create table stypendium (
    id bigint primary key,
    student_id bigint not null,
    rodzaj_stypendium bigint not null
);

create table index (
    id bigint primary key,
    grupa_id bigint not null,
    student_id bigint not null,
    kierunek_studiow bigint not null
);

create table ocena (
    id bigint primary key,
    index_id bigint not null,
    ocena smallint not null,
    opis text not null
);

    --add join table

create table grupa (
    id bigint primary key,
    plan_zajec_id bigint not null
);

create table plan_zajec (
    id bigint primary key,
    --check and add specific datatypes
);

create table dzien (
    id bigint primary key,
    plan_zajec_id bigint not null,
    --the same as above
    przedmiot_id bigint not null
);

create table przedmiot (
    id bigint primary key,
    nazwa text not null,
    prowadzacy_id bigint not null
);


select nspname
from pg_catalog.pg_namespace; --to show list of all schemas

create table xyz (
    id bigint primary key
 );