insert into
    travel_type (name, travel_fee)
values
    ('In Indonesia', 200000),
    ('Out Indonesia', 350000);

insert into
    leave (type, name)
values
    ('Regular', 'Cuti Tahunan'),
    ('Khusus', 'Cuti Menikah'),
    ('Khusus', 'Cuti Haji & Umroh'),
    ('Khusus', 'Melahirkan');

insert into
    department (name)
values
    ('Recruitment'),
    ('Sales'),
    ('Human Resource'),
    ('General Affair');

insert into
    position(name)
values
    ('Direktur'),
    ('General Manager'),
    ('Manager'),
    ('Staff');

insert into
    biodata (
        first_name,
        last_name,
        dob,
        pob,
        address,
        marital_status
    )
values
    (
        'Raya',
        'Indriyani',
        to_date ('1991-01-01', 'YYYY-MM-DD'),
        'Bali',
        'Jl. Raya Baru, Bali',
        false
    ),
    (
        'Rere',
        'Wulandari',
        to_date ('1992-01-02', 'YYYY-MM-DD'),
        'Bandung',
        'Jl. Berkah Ramadhan, Bandung',
        false
    ),
    (
        'Bunga',
        'Maria',
        to_date ('1991-03-03', 'YYYY-MM-DD'),
        'Jakarta',
        'Jl. Mawar Semerbak, Bogor',
        true
    ),
    (
        'Natasha',
        'Wulan',
        to_date ('1990-04-10', 'YYYY-MM-DD'),
        'Jakarta',
        'Jl. Mawar Harum, Jakarta',
        false
    ),
    (
        'Zahra',
        'Aurelia Putri',
        to_date ('1991-03-03', 'YYYY-MM-DD'),
        'Jakarta',
        'Jl. Mawar Semerbak, Bogor',
        true
    ),
    (
        'Katniss',
        'Everdeen',
        to_date ('1989-01-12', 'YYYY-MM-DD'),
        'Jakarta',
        'Jl. Bunga Melati, Jakarta',
        true
    );

insert into
    employee (biodata_id, nip, status, salary)
values
    (1, 'NX001', 'Permanen', 12000000),
    (2, 'NX002', 'Kontrak', 15000000),
    (4, 'NX003', 'Permanen', 13500000),
    (5, 'NX004', 'Permanen', 12000000),
    (6, 'NX005', 'Permanen', 17000000),
    (3, 'NX006', 'Permanen', 16000000);

insert into
    employee_position (employee_id, position_id)
values
    (5, 1),
    (4, 2),
    (3, 3),
    (2, 4),
    (1, 4),
    (6, 4);

insert into
    family (biodata_id, name, status)
values
    (3, 'Azka Fadlan Zikrullah', 'Suami'),
    (3, 'Primrose Everdeen', 'Anak'),
    (5, 'Jaka Samudera Buana', 'Suami'),
    (5, 'Friska Davira', 'Anak'),
    (5, 'Harum Indah Az Zahra', 'Anak'),
    (6, 'Adya Pratama Yuda', 'Suami');

insert into
    contact_person (biodata_id, type, contact)
values
    (1, 'MAIL', 'raya.indriyani@gmail.com'),
    (1, 'PHONE', '085612345678'),
    (2, 'MAIL', 'rere.wulandari@gmail.com'),
    (2, 'PHONE', '081312345678'),
    (2, 'PHONE', '087812345678'),
    (3, 'MAIL', 'bunga.maria@gmail.com'),
    (4, 'MAIL', 'natasha.wulan@gmail.com'),
    (5, 'MAIL', 'zahra.putri@gmail.com'),
    (6, 'MAIL', 'katnis.everdeen@gmail.com');

insert into
    leave_request (
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
        to_date ('2020-10-10', 'YYYY-MM-DD'),
        to_date ('2020-10-12', 'YYYY-MM-DD'),
        'Liburan'
    ),
    (
        1,
        1,
        to_date ('2020-11-12', 'YYYY-MM-DD'),
        to_date ('2020-11-15', 'YYYY-MM-DD'),
        'Acara Keluarga'
    ),
    (
        2,
        2,
        to_date ('2020-05-05', 'YYYY-MM-DD'),
        to_date ('2020-05-07', 'YYYY-MM-DD'),
        'Menikah'
    ),
    (
        2,
        1,
        to_date ('2020-09-09', 'YYYY-MM-DD'),
        to_date ('2020-09-13', 'YYYY-MM-DD'),
        'Touring'
    ),
    (
        2,
        1,
        to_date ('2020-12-24', 'YYYY-MM-DD'),
        to_date ('2020-12-25', 'YYYY-MM-DD'),
        'Acara Keluarga'
    );

insert into
    travel_request (
        employee_id,
        travel_type_id,
        start_date,
        end_date
    )
values
    (
        1,
        1,
        to_date ('2020-07-07', 'YYYY-MM-DD'),
        to_date ('2020-07-08', 'YYYY-MM-DD')
    ),
    (
        1,
        1,
        to_date ('2020-08-07', 'YYYY-MM-DD'),
        to_date ('2020-08-08', 'YYYY-MM-DD')
    ),
    (
        2,
        2,
        to_date ('2020-04-04', 'YYYY-MM-DD'),
        to_date ('2020-04-07', 'YYYY-MM-DD')
    );

insert into
    travel_settlement (travel_request_id, item_name, item_cost)
values
    (1, 'Tiket travel Do-Car berangkat', 165000),
    (1, 'Hotel', 750000),
    (1, 'Tiket travel Do-Car pulang', 165000),
    (2, 'Tiket pesawat berangkat', 750000),
    (2, 'Hotel', 650000),
    (2, 'Tiket pesawat pulang', 1250000),
    (3, 'Tiket pesawat berangkat', 4750000),
    (3, 'Hotel', 6000000),
    (2, 'Tiket pesawat pulang', 4250000);

insert into
    employee_leave (employee_id, period, regular_quota)
values
    (1, 2020, 16),
    (2, 2020, 12),
    (1, 2021, 16),
    (2, 2021, 12),
    (4, 2021, 12),
    (5, 2021, 12),
    (6, 2021, 12);