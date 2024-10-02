-- 1. Urutkan nama-nama karyawan dan statusnya, diurutkan dari yang paling tua ke yang paling muda
select
    trim(concat (b.first_name, ' ', b.last_name)) as name,
    date_part ('year', age (b.dob)) as age,
    e.status
from
    employee e
    join biodata b on e.biodata_id = b.id
order by
    age desc;

-- 2. Tampilkan last name dengan huruf capital dimana last name nya diawali dengan huruf ?M?
select
    case
        when lower(b.last_name) like 'm%' then upper(b.last_name)
        else b.last_name
    end as last_name
from
    biodata b;

-- 3. Buatlah kolom NIP pada table Employee sebagai index
create unique index if not exists idx_employee_nip on employee (nip);

-- 4. Buatlah kolom employee_id pada table employee_leave sebagai kolom unique
alter table employee_leave add constraint unique_employee_id unique (employee_id);

--Skipped(error -> logic doesn't make sense)
-- 5. Tampilkan fullname, salary_lama, dan salary_baru. dimana salary baru itu sebesar 10% dari salary lama dan ditampilkan dengan kolom alias GajiBaru
select
    trim(concat (b.first_name, ' ', b.last_name)) as name,
    e.salary,
    (e.salary + e.salary * 10 / 100) as GajiBaru
from
    employee e
    join biodata b on e.biodata_id = b.id
order by
    GajiBaru desc;

-- 6. Tampilkan nama karyawan, jenis perjalanan dinas, dan total pengeluarannya selama perjalanan dinas tersebut
select
    trim(concat (b.first_name, ' ', b.last_name)) as name,
    sub.jenis_perjalanan,
    sub.total_pengeluaran
from
    employee e
    join biodata b on e.biodata_id = b.id
    join (
        select
            tr.id,
            tr.employee_id,
            tt.name as jenis_perjalanan,
            sum(ts.item_cost) as total_pengeluaran
        from
            travel_request tr
            join travel_settlement ts on ts.travel_request_id = tr.id
            join travel_type tt on tt.id = tr.travel_type_id
        group by
            1,
            2,
            3
    ) as sub on sub.employee_id = e.id;

select
    tr.id,
    tt.name as jenis_perjalanan,
    sum(ts.item_cost) as total_pengeluaran
from
    travel_request tr
    join travel_settlement ts on ts.travel_request_id = tr.id
    join travel_type tt on tt.id = tr.travel_type_id
group by
    1,
    2;

-- 7. Buatkan query untuk menampilkan data karyawan yang belum pernah melakukan perjalanan dinas
select
    b.*,
    e.nip,
    e.status,
    e.salary
from
    employee e
    join biodata b on b.id = e.biodata_id
    full join travel_request tr on tr.employee_id = e.id
where
    tr.employee_id isnull;

-- 8. Tampilkan nama lengkap karyawan, jenis cuti, alasan cuti, durasi cuti, dan nomor telepon yang bisa dihubungi untuk masing-masing karyawan yang mengajukan cuti
select
    trim(concat (b.first_name, ' ', b.last_name)) as nama_karyawan,
    sub.jenis_cuti,
    sub.alasan_cuti,
    sub.durasi_cuti,
    cp.contact
from
    employee e
    join biodata b on e.biodata_id = b.id
    join (
        select distinct
            on (cp.biodata_id) cp.biodata_id,
            cp."type",
            cp.contact
        from
            contact_person cp
        where
            cp."type" like 'PHONE'
    ) as cp on cp.biodata_id = b.id
    join (
        select
            l.name as jenis_cuti,
            lr.reason as alasan_cuti,
            age (lr.end_date, lr.start_date) as durasi_cuti,
            lr.employee_id
        from
            leave_request lr
            join leave l on lr.leave_id = l.id
    ) as sub on sub.employee_id = e.id;

--tabel cuti
select
    l.name as jenis_cuti,
    lr.reason as alasan_cuti,
    age (lr.end_date, lr.start_date) as durasi_cuti,
    lr.employee_id
from
    leave_request lr
    join leave l on lr.leave_id = l.id;

--tabel contact
select distinct
    on (cp.biodata_id) cp.biodata_id,
    cp."type",
    cp.contact
from
    contact_person cp
where
    cp."type" like 'PHONE';

-- 9. Tampilkan alasan cuti yang sering diajukan karyawan
select
    lr.reason,
    count(lr)
from
    leave_request lr
group by
    1
order by
    count(lr) desc;

-- 10. Tampilkan last name, bonus, dan salary + bonus untuk karyawan yang namanya mengandung minimal salah satu huruf vokal (a,i,u,e,o) dimana bonus itu sebesar 20% dari salary
select
    b.last_name,
    (e.salary * 20 / 100) as bonus,
    (e.salary + e.salary * 20 / 100) as salary_plus_bonus
from
    employee e
    join biodata b on b.id = e.biodata_id
where
    lower(b.last_name) like '%a%'
    or lower(b.last_name) like '%i%'
    or lower(b.last_name) like '%u%'
    or lower(b.last_name) like '%e%'
    or lower(b.last_name) like '%o%';

-- -----------------------------------------------------------------------------------------------------------
-- 11. Tampilkan data lengkap karyawan dan rata-rata gaji setahun untuk masing-masing dari mereka
-- Nomor 12.
-- Tambahkan 3 orang pelamar, dimana 2 di antaranya diterima sebagai karyawan kontrak 
-- dan 1 nya lagi tidak diterima sebagai karyawan. 
-- Lalu tampilkan semua biodata berupa fullname, nip, status karyawan dan salary
-- 13. Tampilkan fullname pelamar yang tanggal lahirnya antara 01-01-1991 s/d 31-12-1991
-- 14. Tampilkan nama-nama pelamar yang tidak diterima sebagai karyawan
-- 15. Tampilkan sisa cuti tahun 2020 yang dimiliki oleh karyawan
-- 16. Tampilkan selisih antara total item cost dengan total travel fee untuk masing-masing karyawan
-- NOMOR 17. 
-- Tambahkan data cuti tahun 2021 terhadap semua karyawan(termasuk karyawan baru yang sudah ditambahkan pada soal sebelumnya). 
-- Lalu hitung jumlah cuti yang sudah diambil pada tahun 2020 dari masing-masing karyawan.
-- Constraint : Data cuti karyawan baru tidak perlu ditampilkan
-- NOMOR 18
-- Tampilkan fullname, jabatan, usia, dan jumlah anak dari masing-masing karyawan saat ini 
-- (kalau tidak ada anak tulis 0 (nol) atau '-' saja)
-- 19. Hitung ada berapa karyawan yang sudah menikah dan yang tidak menikah 
-- (tabel: menikah x orang, tidak menikah x orang)
-- 20. Jika digabungkan antara cuti dan perjalanan dinas, 
-- berapa hari Raya tidak berada di kantor pada tahun 2020?