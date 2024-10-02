--Jawaban untuk soal-soal
--no1
alter table dosen 
	alter nama_dosen type varchar(200);
	
--no2
select m.kode_mahasiswa, m.nama_mahasiswa, j.nama_jurusan, a.deskripsi as agama
from mahasiswa as m
join jurusan as j on j.kode_jurusan = m.kode_jurusan 
join agama as a on a.kode_agama = m.kode_agama 
where m.nama_mahasiswa like 'Budi%';

--no3
select m.*
from mahasiswa as m
join jurusan as j on j.kode_jurusan = m.kode_jurusan 
where j.status_jurusan like 'Non%';

--no4
select distinct on (m.kode_mahasiswa) m.*, n.nilai, u.nama_ujian, u.status_ujian
from mahasiswa as m
join nilai as n on n.kode_mahasiswa = m.kode_mahasiswa 
join ujian as u on u.kode_ujian = n.kode_ujian 
where n.nilai > 80 and u.status_ujian like 'Aktif';

--no5
select j.*
from jurusan j 
where lower(j.nama_jurusan) like '%sistem%';

--no6
select m.kode_mahasiswa, m.nama_mahasiswa, m.alamat, count(n) as banyak_ujian
from mahasiswa m 
join nilai n on n.kode_mahasiswa = m.kode_mahasiswa 
group by m.kode_mahasiswa, m.nama_mahasiswa , m.alamat
having count(n) > 1;

--no7
select m.kode_mahasiswa , m.nama_mahasiswa , j.nama_jurusan , a.deskripsi as agama , sub.nama_dosen ,j.status_jurusan , sub.deskripsi
from mahasiswa m 
join agama a on a.kode_agama = m.kode_agama 
join jurusan j on j.kode_jurusan = m.kode_jurusan 
join (
	select d.nama_dosen, td.deskripsi, d.kode_jurusan
	from dosen d 
	join type_dosen td on d.kode_type_dosen = td.kode_type_dosen
) as sub on sub.kode_jurusan = j.kode_jurusan 
where lower(m.nama_mahasiswa) like '%budi%';

--no8 skip
create view data_mahasiswa as
select m.kode_mahasiswa , m.nama_mahasiswa , j.nama_jurusan , a.deskripsi as agama , sub.nama_dosen ,j.status_jurusan , sub.deskripsi
from mahasiswa m 
join agama a on a.kode_agama = m.kode_agama 
join jurusan j on j.kode_jurusan = m.kode_jurusan 
join (
	select d.nama_dosen, td.deskripsi, d.kode_jurusan
	from dosen d 
	join type_dosen td on d.kode_type_dosen = td.kode_type_dosen
) as sub on sub.kode_jurusan = j.kode_jurusan 
where lower(m.nama_mahasiswa) like '%budi%';	
select * from data_mahasiswa dm ;


--no9
select m.*, sub.nama_ujian, sub.nilai
from mahasiswa m 
full join (
	select n.nilai, u.nama_ujian, n.kode_mahasiswa
	from nilai n 
	join ujian u on u.kode_ujian = n.kode_ujian
) as sub on sub.kode_mahasiswa = m.kode_mahasiswa 
order by m.kode_mahasiswa ;