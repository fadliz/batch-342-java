insert into
    travel_type (id, name, travel_fee)
values
    (1, 'In Indonesia', 200000),
    (2, 'Out Indonesia', 350000);

insert into
    leave (id, type, name)
values
    (1, 'Regular', 'Cuti Tahunan'),
    (2, 'Khusus', 'Cuti Menikah'),
    (3, 'Khusus', 'Cuti Haji & Umroh'),
    (4, 'Khusus', 'Melahirkan');

insert into
    department (id, name)
values
    (1, 'Recruitment'),
    (2, 'Sales'),
    (3, 'Human Resource'),
    (4, 'General Affair');

insert into
    position(id, name)
values
    (1, 'Direktur'),
    (2, 'General Manager'),
    (3, 'Manager'),
    (4, 'Staff');

insert into
    biodata (
        id,
        first_name,
        last_name,
        dob,
        pob,
        address,
        marital_status
    )
values
    (
        1,
        'Raya',
        'Indriyani',
        '1991-01-01',
        'Bali',
        'Jl. Raya Baru, Bali',
        false
    ),
    (
        2,
        'Rere',
        'Wulandari',
        '1992-01-02',
        'Bandung',
        'Jl. Berkah Ramadhan, Bandung',
        false
    ),
    (
        3,
        'Bunga',
        'Maria',
        '1991-03-03',
        'Jakarta',
        'Jl. Mawar Semerbak, Bogor',
        true
    ),
    (
        4,
        'Natasha',
        'Wulan',
        '1990-04-10',
        'Jakarta',
        'Jl. Mawar Harum, Jakarta',
        false
    ),
    (
        5,
        'Zahra',
        'Aurelia Putri',
        '1991-03-03',
        'Jakarta',
        'Jl. Mawar Semerbak, Bogor',
        true
    ),
    (
        6,
        'Katniss',
        'Everdeen',
        '1989-01-12',
        'Jakarta',
        'Jl. Bunga Melati, Jakarta',
        true
    );

insert into
    employee (id, biodata_id, nip, status, salary)
values
    (1, 1, 'NX001', 'Permanen', 12000000),
    (2, 2, 'NX002', 'Kontrak', 15000000),
    (3, 4, 'NX003', 'Permanen', 13500000),
    (4, 5, 'NX004', 'Permanen', 12000000),
    (5, 6, 'NX005', 'Permanen', 17000000),
    (6, 3, 'NX006', 'Permanen', 16000000);

insert into
    employee_position (id, employee_id, position_id)
values
    (1, 5, 1),
    (2, 4, 2),
    (3, 3, 3),
    (4, 2, 4),
    (5, 1, 4),
    (6, 6, 4);

insert into
    family (id, biodata_id, name, status)
values
    (1, 3, 'Azka Fadlan Zikrullah', 'Suami'),
    (2, 3, 'Primrose Everdeen', 'Anak'),
    (3, 5, 'Jaka Samudera Buana', 'Suami'),
    (4, 5, 'Friska Davira', 'Anak'),
    (5, 5, 'Harum Indah Az Zahra', 'Anak'),
    (6, 6, 'Adya Pratama Yuda', 'Suami');

insert into
    contact_person (id, biodata_id, type, contact)
values
    (1, 1, 'MAIL', 'raya.indriyani@gmail.com'),
    (2, 1, 'PHONE', '085612345678'),
    (3, 2, 'MAIL', 'rere.wulandari@gmail.com'),
    (4, 2, 'PHONE', '081312345678'),
    (5, 2, 'PHONE', '087812345678'),
    (6, 3, 'MAIL', 'bunga.maria@gmail.com'),
    (7, 4, 'MAIL', 'natasha.wulan@gmail.com'),
    (8, 5, 'MAIL', 'zahra.putri@gmail.com'),
    (9, 6, 'MAIL', 'katnis.everdeen@gmail.com');

insert into
    leave_request (
        id,
        employee_id,
        leave_id,
        start_date,
        end_date,
        reason
    )
values
    (
        1,
        1,
        1,
        to_date ('2020-10-10', 'YYYY-MM-DD'),
        to_date ('2020-10-12', 'YYYY-MM-DD'),
        'Liburan'
    ),
    (
        2,
        1,
        1,
        to_date ('2020-11-12', 'YYYY-MM-DD'),
        to_date ('2020-11-15', 'YYYY-MM-DD'),
        'Acara Keluarga'
    ),
    (
        3,
        2,
        2,
        to_date ('2020-05-05', 'YYYY-MM-DD'),
        to_date ('2020-05-07', 'YYYY-MM-DD'),
        'Menikah'
    ),
    (
        4,
        2,
        1,
        to_date ('2020-09-09', 'YYYY-MM-DD'),
        to_date ('2020-09-13', 'YYYY-MM-DD'),
        'Touring'
    ),
    (
        5,
        2,
        1,
        to_date ('2020-12-24', 'YYYY-MM-DD'),
        to_date ('2020-12-25', 'YYYY-MM-DD'),
        'Acara Keluarga'
    );

insert into
    travel_request (
        id,
        employee_id,
        travel_type_id,
        start_date,
        end_date
    )
values
    (
        1,
        1,
        1,
        to_date ('2020-07-07', 'YYYY-MM-DD'),
        to_date ('2020-07-08', 'YYYY-MM-DD')
    ),
    (
        2,
        1,
        1,
        to_date ('2020-08-07', 'YYYY-MM-DD'),
        to_date ('2020-08-08', 'YYYY-MM-DD')
    ),
    (
        3,
        2,
        2,
        to_date ('2020-04-04', 'YYYY-MM-DD'),
        to_date ('2020-04-07', 'YYYY-MM-DD')
    );

insert into
    travel_settlement (id, travel_request_id, item_name, item_cost)
values
    (1, 1, 'Tiket travel Do-Car berangkat', 165000),
    (2, 1, 'Hotel', 750000),
    (3, 1, 'Tiket travel Do-Car pulang', 165000),
    (4, 2, 'Tiket pesawat berangkat', 750000),
    (5, 2, 'Hotel', 650000),
    (6, 2, 'Tiket pesawat pulang', 1250000),
    (7, 3, 'Tiket pesawat berangkat', 4750000),
    (8, 3, 'Hotel', 6000000),
    (9, 2, 'Tiket pesawat pulang', 4250000);

insert into
    employee_leave (id, employee_id, period, regular_quota)
values
    (1, 1, 2020, 16),
    (2, 2, 2020, 12),
    (3, 1, 2021, 16),
    (4, 2, 2021, 12),
    (5, 4, 2021, 12),
    (6, 5, 2021, 12),
    (7, 6, 2021, 12);