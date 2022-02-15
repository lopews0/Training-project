drop table if exists assets;
drop table if exists hibernate_sequence;

create table assets
(
    id     bigint not null,
    amount decimal(19, 2),
    primary key (id)
) engine = InnoDB;

create table hibernate_sequence
(
    next_val bigint
) engine = InnoDB;

insert into hibernate_sequence values ( 1 );