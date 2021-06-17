create table example_database
(
    id                  bigint      not null
        constraint position_pkey
            primary key,
    description         varchar(255)
);

