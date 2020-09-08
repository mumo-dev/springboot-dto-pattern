create sequence hibernate_sequence start 1 increment 1;
create table public.roles (
id int8 not null,
first_name varchar(255) not null,
primary key (id));

create table public.user_role (
user_id int8 not null,
role_id int8 not null,
primary key (user_id, role_id));

create table public.users (
id int8 not null,
created_at timestamp not null,
updated_at timestamp not null,
email varchar(255) not null,
first_name varchar(255) not null,
last_name varchar(255) not null,
password varchar(255) not null,
primary key (id));


alter table public.user_role add constraint FK_user_role_role_id foreign key (role_id) references public.roles;

alter table public.user_role add constraint FK_user_role_user_id foreign key (user_id) references public.users;

