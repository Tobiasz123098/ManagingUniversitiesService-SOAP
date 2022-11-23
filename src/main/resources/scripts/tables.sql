create table uniwersytet (
    id bigint not null primary key default nextval('uniwersytet_id_seq'::regclass),
    nazwa text not null
);

create table sala (
    id bigint not null primary key default nextval('sala_id_seq'::regclass),
    numer_sali smallint not null,
    uniwersytet_id bigint not null,
    foreign key (uniwersytet_id)
        references uniwersytet (id) match full
);

create table prowadzacy (
    id bigint not null primary key default nextval('prowadzacy_id_seq'::regclass),
    imie text not null,
    nazwisko text not null,
    email text unique not null,
    tytul text not null,
    uniwersytet_id bigint not null,
    foreign key (uniwersytet_id)
        references uniwersytet (id) match full
);

create table student (
    id bigint not null primary key default nextval('student_id_seq'::regclass),
    imie text not null,
    nazwisko text not null,
    email text unique not null,
    uniwersytet_id bigint not null,
    index_id bigint not null,
    foreign key (uniwersytet_id)
        references uniwersytet (id) match full
    foreign key (index_id)
        references index (id) match full
);

alter table student add foreign key index_id references index (id);  --adding foreign key <index_id> to existing table <student>

create table osiagniecie (
    id bigint not null primary key default nextval('osiagniecie_id_seq'::regclass),
    opis text,
    rodzaj_osiagniecia text not null,
    student_id bigint not null,
    foreign key (student_id)
        references student (id) match full
);

create table stypendium (
    id bigint not null primary key default nextval('stypendium_id_seq'::regclass),
    student_id bigint not null,
    rodzaj_stypendium text not null,
    foreign key (student_id)
        references student (id) match full
);

create table ocena (
    id bigint not null primary key default nextval('ocena_id_seq'::regclass),
    index_id bigint not null,
    ocena smallint not null,
    opis text,
    foreign key (index_id)
        references index (id) match full
);

    --klucz kompozytowy
create table ocena_dzien (
    ocena_id bigint references ocena (id) on delete cascade,
    dzien_id bigint references dzien (id) on delete cascade,
    constraint ocena_dzien_pkey primary key (ocena_id, dzien_id),
    foreign key (ocena_id)
        references ocena (id) match full,
    foreign key (dzien_id)
        references dzien (id) match full
);

create table index (
    id bigint not null primary key default nextval('index_id_seq'::regclass),
    grupa_id bigint not null,
    student_id bigint not null,
    kierunek_studiow text not null,
    foreign key (student_id)
        references student (id) match full,
    foreign key (grupa_id)
        references grupa (id) match full
);

create table grupa (
    id bigint not null primary key default nextval('grupa_id_seq'::regclass),
    plan_zajec_id bigint not null,
    foreign key (plan_zajec_id)
        references plan_zajec (id) match full
);

create table plan_zajec (
    id bigint not null primary key default nextval('plan_zajec_id_seq'::regclass),
    dzien_od date not null,
    dzien_do date not null
);

create table dzien (
    id bigint not null primary key default nextval('dzien_id_seq'::regclass),
    plan_zajec_id bigint not null,
    data_dnia date not null,
    od_kiedy_zajecia time not null,
    do_kiedy_zajecia time not null,
    przedmiot_id bigint not null,
    foreign key (plan_zajec_id)
        references plan_zajec (id) match full,
    foreign key (przedmiot_id)
        references przedmiot (id) match full
);

create table przedmiot (
    id bigint not null primary key default nextval('przedmiot_id_seq'::regclass),
    nazwa text not null,
    prowadzacy_id bigint not null,
    foreign key (prowadzacy_id)
        references prowadzacy (id) match full
);


select nspname
from pg_catalog.pg_namespace; --to show list of all schemas
--on cascade delete   on cascade update  https://medium.com/geoblinktech/postgresql-foreign-keys-with-condition-on-update-cascade-330e1b25b6e5