create table if not exists cars (
       id bigint not null auto_increment,
        brand varchar(255),
        car_number varchar(255),
        model varchar(255),
        year_of_manufacture integer,
        engine_id bigint not null,
        owner_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table if not exists engines (
           id bigint not null auto_increment,
            cubature integer,
            hours_power integer,
            engine_number varchar(255),
            primary key (id)
        ) engine=InnoDB;

     create table if not exists owners (
            id bigint not null auto_increment,
             date_of_birth date,
             first_name varchar(255),
             last_name varchar(255),
             primary key (id)
         ) engine=InnoDB;

        alter table cars
              add constraint UK_kfw3goyl3cgwqe10mkeo4txwm unique (engine_id);

        alter table engines
              add constraint UK_eug2gvl06hx942rnvnbqa58ot unique (engine_number);

