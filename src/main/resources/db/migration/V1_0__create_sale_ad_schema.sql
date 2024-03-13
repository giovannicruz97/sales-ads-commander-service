create table if not exists sale_ad(
    id uuid not null primary key ,
    price numeric(10, 2) not null,
    url varchar(255) not null ,
    image varchar(255) not null ,
    lifetime timestamp not null ,
    active boolean not null
)