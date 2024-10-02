create table
    department (
        id serial not null primary key,
        name varchar(100) not null
    );

create table
    leave (
        id serial not null primary key,
        type varchar(10) not null,
        name varchar(100) not null
    );

create table
    travel_type (
        id serial not null primary key,
        name varchar(50) not null,
        travel_fee int not null
    );

create table
    position(
        id serial not null primary key,
        name varchar(100) not null
    );

create table
    biodata (
        id serial not null primary key,
        first_name varchar(20) not null,
        last_name varchar(30) null,
        dob date not null,
        pob varchar(50) not null,
        address varchar(255) null,
        marital_status boolean not null default false
    );

create table
    employee (
        id serial not null primary key,
        biodata_id bigint not null,
        nip varchar(5) not null,
        status varchar(10) not null,
        salary numeric(10) not null default 0
    );

alter table employee add constraint fk_employee_biodata foreign key (biodata_id) references biodata (id);

create table
    employee_position (
        id serial not null primary key,
        employee_id bigint not null,
        position_id bigint not null
    );

alter table employee_position add constraint fk_employee_position_employee foreign key (employee_id) references employee (id);

alter table employee_position add constraint fk_employee_position_position foreign key (position_id) references position(id);

create table
    family (
        id serial not null primary key,
        biodata_id bigint not null,
        name varchar(100) not null,
        status varchar(50) not null
    );

alter table family add constraint fk_family_biodata foreign key (biodata_id) references biodata (id);

create table
    contact_person (
        id serial not null primary key,
        biodata_id bigint not null,
        type varchar(5) not null,
        contact varchar(100) not null
    );

alter table contact_person add constraint fk_contact_person_biodata foreign key (biodata_id) references biodata (id);

create table
    leave_request (
        id serial not null primary key,
        employee_id bigint not null,
        leave_id bigint not null,
        start_date date not null,
        end_date date not null,
        reason varchar(255) not null
    );

alter table leave_request add constraint fk_leave_request_employee foreign key (employee_id) references employee (id);

alter table leave_request add constraint fk_leave_request_leave foreign key (leave_id) references leave (id);

create table
    travel_request (
        id serial not null primary key,
        employee_id bigint not null,
        travel_type_id bigint not null,
        start_date date not null,
        end_date date not null
    );

alter table travel_request add constraint fk_travel_request_employee foreign key (employee_id) references employee (id);

alter table travel_request add constraint fk_travel_request_travel_type foreign key (travel_type_id) references travel_type (id);

create table
    travel_settlement (
        id serial not null primary key,
        travel_request_id bigint not null,
        item_name varchar(100) not null,
        item_cost int not null
    );

alter table travel_settlement add constraint fk_travel_settlement_travel_request foreign key (travel_request_id) references travel_request (id);

create table
    employee_leave (
        id serial not null primary key,
        employee_id bigint not null,
        period varchar(4) not null,
        regular_quota int not null
    );

alter table employee_leave add constraint fk_employee_leave_employee foreign key (employee_id) references employee (id);