create table shoe_dim
(
    id    serial       not null
        constraint shoe_dim_pkey
            primary key,
    brand varchar(100) not null,
    model varchar(100) not null,
    constraint brand_model_unq
        unique (brand, model)
);

alter table shoe_dim
    owner to shoe_dba;

create table shoe_size_dim
(
    id          serial  not null
        constraint shoe_size_dim_pkey
            primary key,
    sex         "char"  not null,
    us          numeric not null,
    inches      numeric not null,
    centimeters numeric not null,
    constraint sex_sizes_unq
        unique (sex, us, inches, centimeters)
);

alter table shoe_size_dim
    owner to shoe_dba;

create table date_dim
(
    date_dim_id            integer    not null
        constraint d_date_date_dim_id_pk
            primary key,
    date_actual            date       not null,
    epoch                  bigint     not null,
    day_suffix             varchar(4) not null,
    day_name               varchar(9) not null,
    day_of_week            integer    not null,
    day_of_month           integer    not null,
    day_of_quarter         integer    not null,
    day_of_year            integer    not null,
    week_of_month          integer    not null,
    week_of_year           integer    not null,
    week_of_year_iso       char(10)   not null,
    month_actual           integer    not null,
    month_name             varchar(9) not null,
    month_name_abbreviated char(3)    not null,
    quarter_actual         integer    not null,
    quarter_name           varchar(9) not null,
    year_actual            integer    not null,
    first_day_of_week      date       not null,
    last_day_of_week       date       not null,
    first_day_of_month     date       not null,
    last_day_of_month      date       not null,
    first_day_of_quarter   date       not null,
    last_day_of_quarter    date       not null,
    first_day_of_year      date       not null,
    last_day_of_year       date       not null,
    mmyyyy                 char(6)    not null,
    mmddyyyy               char(10)   not null,
    weekend_indr           boolean    not null
);

alter table date_dim
    owner to shoe_dba;

create index d_date_date_actual_idx
    on date_dim (date_actual);

create table true_to_size_fact
(
    id            serial   not null
        constraint true_to_size_fact_pkey
            primary key,
    date_dim      integer  not null
        constraint true_to_size_fact_date_dim_fkey
            references date_dim,
    shoe_dim      integer  not null
        constraint true_to_size_fact_shoe_dim_fkey
            references shoe_dim,
    shoe_size_dim integer
        constraint true_to_size_fact_shoe_size_dim_fkey
            references shoe_size_dim,
    true_to_size  smallint not null
);

alter table true_to_size_fact
    owner to shoe_dba;

