create schema if not exists  pet_clinic;

create table if not exists pet_clinic.pet_owner
(
	id bigint not null
		constraint pet_owner_pkey
			primary key,
	city varchar(255),
	index bigint,
	street varchar(255),
	login varchar(255),
	pass varchar(255),
	role varchar(255),
	first_name varchar(100),
	last_name varchar(100)
);

insert into pet_clinic.pet_owner(id, login, pass, role, first_name, last_name, city, street, index) values
(1000, 'sergey1895', '1234', 'USER', 'Sergey', 'Ivanov', 'Perm', 'Baikalskaya', 614023),
(1001, 'kotik007', 'qwerty', 'ADMIN', 'Valeriy', 'Petrov', 'Kungur', 'Sovhozniy', 617474);


create table if not exists pet_clinic.pet
(
	id bigint not null
		constraint pet_pkey
			primary key,
	name varchar(255),
	type_pet varchar(255),
	owner_id bigint
		constraint fktan5592od8n46s6ub58o7nhcf
			references pet_clinic.pet_owner
);

insert into pet_clinic.pet(id, name, type_pet, owner_id) values
(999, 'Busia', 'DOG', 1000);

create table if not exists pet_clinic.vet
(
	id bigint not null
		constraint vet_pkey
			primary key,
	first_name varchar(255),
	last_name varchar(255),
	speciality varchar(255)
);

insert into pet_clinic.vet (id, first_name, last_name, speciality) values
(16, 'Ukolov', 'Stepan', 'THERAPIST');

create table if not exists pet_clinic.visit
(
	id bigint not null
		constraint visit_pkey
			primary key,
	first_name varchar(255),
	last_name varchar(255),
	created_visit date,
	date date,
	description varchar(255),
	status varchar(255),
	updated_visit timestamp,
	vet_id bigint
		constraint fk8wn2rh59ouslkysfmd741rxii
			references pet_clinic.vet
);

insert into pet_clinic.visit (id, first_name, last_name, created_visit, date, description, status, vet_id) values
(25, 'Sergey', 'Ivanov', '2021-11-10', '2021-11-15', 'desc visit', 'PLANTED', 16)


