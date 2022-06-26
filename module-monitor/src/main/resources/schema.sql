drop table if exists hibernate_sequence;
drop table if exists todo;

create table hibernate_sequence (
   next_val bigint
) engine=InnoDB;

insert into hibernate_sequence values (1);

create table todo (
   id bigint not null,
    completed bit not null,
    created_on datetime(6),
    description varchar(255) not null,
    due_by datetime(6),
    primary key (id)
) engine=InnoDB;
