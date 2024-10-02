-- 1. Urutkan nama-nama karyawan dan statusnya, diurutkan dari yang paling tua ke yang paling muda
select trim(concat(b.first_name, ' ', b.last_name)) as name, date_part('year',age(b.dob)) as age, e.status
from employee e 
join biodata b on e.biodata_id = b.id 
order by age desc;

-- 2. Tampilkan last name dengan huruf capital dimana last name nya diawali dengan huruf ?M?
select 
case when lower(b.last_name) like 'm%' then 
	upper(b.last_name)
else
	b.last_name
end as last_name 
from biodata b ;

-- 3. Buatlah kolom NIP pada table Employee sebagai index
create unique index if not exists idx_employee_nip on employee(nip);

-- 4. Buatlah kolom employee_id pada table employee_leave sebagai kolom unique
alter table employee_leave 
add constraint unique_employee_id unique(employee_id);
--Skipped(error -> logic doesn't make sense)

-- 5. Tampilkan fullname, salary_lama, dan salary_baru. dimana salary baru itu sebesar 10% dari salary lama dan ditampilkan dengan kolom alias GajiBaru
select trim(concat(b.first_name, ' ', b.last_name)) as name, e.salary, (e.salary+e.salary*10/100) as GajiBaru
from employee e 
join biodata b on e.biodata_id = b.id 
order by GajiBaru desc;

-- 6. Tampilkan nama karyawan, jenis perjalanan dinas, dan total pengeluarannya selama perjalanan dinas tersebut
select trim(concat(b.first_name, ' ', b.last_name)) as name, sub.jenis_perjalanan, sub.total_pengeluaran, sub.travel_fee
from employee e 
join biodata b on e.biodata_id = b.id 
join (
	select tr.id, tr.employee_id, tt.name as jenis_perjalanan, sum(ts.item_cost) as total_pengeluaran, tt.travel_fee
	from travel_request tr 
	join travel_settlement ts on ts.travel_request_id = tr.id
	join travel_type tt on tt.id = tr.travel_type_id
	group by 1,2,3,5
) as sub on sub.employee_id = e.id;

select tr.id, tt.name as jenis_perjalanan, sum(ts.item_cost) as total_pengeluaran
	from travel_request tr 
	join travel_settlement ts on ts.travel_request_id = tr.id
	join travel_type tt on tt.id = tr.travel_type_id
	group by 1,2;

-- 7. Buatkan query untuk menampilkan data karyawan yang belum pernah melakukan perjalanan dinas
select b.*, e.nip, e.status, e.salary 
from employee e 
join biodata b on b.id = e.biodata_id 
full join travel_request tr on tr.employee_id = e.id 
where tr.employee_id isnull ;

-- 8. Tampilkan nama lengkap karyawan, jenis cuti, alasan cuti, durasi cuti, dan nomor telepon yang bisa dihubungi untuk masing-masing karyawan yang mengajukan cuti
select trim(concat(b.first_name, ' ', b.last_name)) as nama_karyawan, sub.jenis_cuti, sub.alasan_cuti, sub.durasi_cuti, cp.contact
from employee e 
join biodata b on e.biodata_id = b.id 
join (
	select distinct on (cp.biodata_id) cp.biodata_id, cp."type", cp.contact
	from contact_person cp
	where cp."type" like 'PHONE'
) as cp on cp.biodata_id = b.id 
join (
	select l.name as jenis_cuti, lr.reason as alasan_cuti, age(lr.end_date ,lr.start_date) as durasi_cuti, lr.employee_id
	from leave_request lr 
	join leave l on lr.leave_id = l.id
) as sub on sub.employee_id = e.id;

--tabel cuti
select l.name as jenis_cuti, lr.reason as alasan_cuti, age(lr.end_date ,lr.start_date) as durasi_cuti, lr.employee_id
	from leave_request lr 
	join leave l on lr.leave_id = l.id;
--tabel contact
select distinct on (cp.biodata_id) cp.biodata_id, cp."type", cp.contact
	from contact_person cp
	where cp."type" like 'PHONE';

-- 9. Tampilkan alasan cuti yang sering diajukan karyawan
select lr.reason, count(lr)
from leave_request lr 
group by 1
order by count(lr) desc;

-- 10. Tampilkan last name, bonus, dan salary + bonus untuk karyawan yang namanya mengandung minimal salah satu huruf vokal (a,i,u,e,o) dimana bonus itu sebesar 20% dari salary
select b.last_name, (e.salary * 20 / 100) as bonus, (e.salary+e.salary * 20 / 100) as salary_plus_bonus
from employee e 
join biodata b on b.id = e.biodata_id 
where lower(b.last_name) like '%a%' or 
lower(b.last_name) like '%i%' or 
lower(b.last_name) like '%u%' or 
lower(b.last_name) like '%e%' or 
lower(b.last_name) like '%o%' 
;

-- -----------------------------------------------------------------------------------------------------------
-- 11. Tampilkan data lengkap karyawan dan rata-rata gaji setahun untuk masing-masing dari mereka
select distinct on (e.nip) e.biodata_id, e.nip,e.status,trim(concat(b.first_name, ' ', b.last_name)) as nama_karyawan,
	b.dob,b.pob,b.address,b.marital_status as married,sub."type",sub.contact,f."name",f.status, avg(e.salary*12) as avg_per_year
from employee e 
join biodata b on e.biodata_id = b.id 
join (
	select distinct on (cp.biodata_id) cp.biodata_id, cp."type", cp.contact
	from contact_person cp
) as sub on sub.biodata_id = b.id
full join "family" f on f.biodata_id = b.id
group by 1,2,3,4,5,6,7,8,9,10,11,12;
-- Nomor 12.
-- Tambahkan 3 orang pelamar, dimana 2 di antaranya diterima sebagai karyawan kontrak 
-- dan 1 nya lagi tidak diterima sebagai karyawan. 
-- Lalu tampilkan semua biodata berupa fullname, nip, status karyawan dan salary
insert into biodata (first_name,last_name,dob,pob,address,marital_status)
values 
('Rizky','Pratama',to_date('2001-03-27','YYYY-MM-DD'),'Jakarta','Jl. Merdeka No. 45, Kelurahan Sukamaju, Kecamatan Cimahi, Kota Cimahi, Jawa Barat 40521',false),
('Siti','Nurhaliza',to_date('1990-12-02','YYYY-MM-DD'),'Bekasi','Jl. Kebon Jeruk Raya No. 10, Kelurahan Kebon Jeruk, Kecamatan Kebon Jeruk, Kota Jakarta Barat, DKI Jakarta 11530',true),
('Aditya','Santoso',to_date('1998-08-08','YYYY-MM-DD'),'Bogor','Jl. Diponegoro No. 18, Kelurahan Klojen, Kecamatan Klojen, Kota Malang, Jawa Timur 65111',false)
ON CONFLICT DO NOTHING;

insert into employee (biodata_id,nip,status,salary)
values
(8,'NX007','Kontrak', 18000000),
(9,'NX008','Kontrak',10000000)
on conflict do nothing;

insert into employee_position (employee_id,position_id)
values
(7,4),
(8,4)
on conflict do nothing;

select trim(concat(b.first_name, ' ', b.last_name)) as nama_karyawan, e.nip, e.status , e.salary 
from employee e 
join biodata b on e.biodata_id = b.id
order by e.nip;

-- 13. Tampilkan fullname pelamar yang tanggal lahirnya antara 01-01-1991 s/d 31-12-1991
select trim(concat(b.first_name, ' ', b.last_name)) as nama_karyawan
from biodata b 
where b.dob between to_date('1991-01-01','YYYY-MM-DD') and to_date('1991-12-31','YYYY-MM-DD')
order by age(b.dob) desc;

-- 14. Tampilkan nama-nama pelamar yang tidak diterima sebagai karyawan
select trim(concat(b.first_name, ' ', b.last_name)) as nama_pelamar
from employee e 
full join biodata b on e.biodata_id = b.id
where e.biodata_id isnull;

-- 15. Tampilkan sisa cuti tahun 2020 yang dimiliki oleh karyawan
select trim(concat(b.first_name, ' ', b.last_name)) as nama_karyawan, (el.regular_quota-count(sub)) as sisa_kuota_cuti_2020
from employee_leave el 
join employee e on e.id = el.employee_id 
join biodata b on b.id = e.biodata_id 
join (
	select *
	from leave_request lr 
	where date_part('year',lr.start_date) = 2020
) as sub on sub.employee_id = e.id 
where el."period" like '2020'
group by 1, el.regular_quota , e.nip
order by e.nip
;

-- 16. Tampilkan selisih antara total item cost dengan total travel fee untuk masing-masing karyawan
select trim(concat(b.first_name, ' ', b.last_name)) as name, sub.jenis_perjalanan, sub.total_item_cost, sub.travel_fee, (sub.travel_fee - sub.total_item_cost) as "selisih cost dan fee"
from employee e 
join biodata b on e.biodata_id = b.id 
join (
	select tr.id, tr.employee_id, tt.name as jenis_perjalanan, sum(ts.item_cost) as total_item_cost, tt.travel_fee
	from travel_request tr 
	join travel_settlement ts on ts.travel_request_id = tr.id
	join travel_type tt on tt.id = tr.travel_type_id
	group by 1,2,3,5
) as sub on sub.employee_id = e.id;

-- NOMOR 17. 
-- Tambahkan data cuti tahun 2021 terhadap semua karyawan(termasuk karyawan baru yang sudah ditambahkan pada soal sebelumnya). 
-- Lalu hitung jumlah cuti yang sudah diambil pada tahun 2020 dari masing-masing karyawan.
-- Constraint : Data cuti karyawan baru tidak perlu ditampilkan
INSERT INTO employee_leave (employee_id, period, regular_quota)
SELECT e.id, '2021', 12  -- Assuming 12 leave days as an example
FROM employee e
WHERE NOT EXISTS (
    SELECT 1 
    FROM employee_leave lr 
    WHERE lr.employee_id = e.id AND lr.period like '2021'
);

select trim(concat(b.first_name, ' ', b.last_name)) as nama_karyawan, (count(sub)) as "ambil cuti"
from employee_leave el 
join employee e on e.id = el.employee_id 
join biodata b on b.id = e.biodata_id 
full join (
	select *
	from leave_request lr 
	where date_part('year',lr.start_date) = 2020
) as sub on sub.employee_id = e.id 
where el."period" like '2020'
group by 1 , e.nip
order by e.nip
;

-- NOMOR 18
-- Tampilkan fullname, jabatan, usia, dan jumlah anak dari masing-masing karyawan saat ini 
-- (kalau tidak ada anak tulis 0 (nol) atau '-' saja)
select trim(concat(b.first_name, ' ', b.last_name)) as nama_karyawan, sub.name, date_part('year', age(b.dob)) as usia, coalesce (count(f.status),0) as jumlah_anak
from employee e 
join biodata b on b.id = e.biodata_id 
join (
	select p.name, ep.employee_id
	from employee_position ep 
	join "position" p on p.id = ep.position_id
) as sub on sub.employee_id = e.id 
full join (
	select f.biodata_id, f.status
	from "family" f 
	where lower(f.status) like 'anak'
) as f on f.biodata_id = b.id
group by 1,2,3
;

-- 19. Hitung ada berapa karyawan yang sudah menikah dan yang tidak menikah 
-- (tabel: menikah x orang, tidak menikah x orang)
select 
concat(sum(case when b.marital_status = true then 1 else 0 end), ' orang' ) as menikah, 
concat(sum(case when b.marital_status = false then 1 else 0 end), ' orang' ) as tidak_menikah
from employee e 
join biodata b on b.id = e.biodata_id 
;

-- 20. Jika digabungkan antara cuti dan perjalanan dinas, 
-- berapa hari Raya tidak berada di kantor pada tahun 2020?
create or replace view data_absent as
select e.id, tr.start_date
from employee e 
join (
	select tr.start_date, tr.employee_id
	from travel_request tr
	where date_part('year',tr.start_date) = 2020
) as tr on tr.employee_id = e.id 
union
select e.id, lr.start_date
from employee e 
join (
	select lr.start_date, lr.employee_id
	from leave_request lr 
	where date_part('year',lr.start_date) = 2020
) as lr on lr.employee_id = e.id  
;

select trim(concat(b.first_name, ' ', b.last_name)) as name, concat(count(*), ' hari') as tidak_hadir
from employee e 
join biodata b on e.biodata_id = b.id
join data_absent da on da.id = e.id 
where lower(b.first_name) like 'raya'
group by 1
;