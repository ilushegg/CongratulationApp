create table hibernate_sequence (next_val bigint);
insert into hibernate_sequence values (1);
create table person(
    id bigint not null,
    name varchar(255) not null,
    birthday date not null,
    filename varchar(255),
    user_id bigint,
    primary key (id)
);
create table user(
    id bigint not null,
    email varchar(255) not null,
    password varchar(255) not null,
    username varchar(255) not null,
    avatar varchar(255),
    activation_code varchar(255),
    primary key (id)
);
alter table person add constraint person_user_fk foreign key(user_id) references user (id);
