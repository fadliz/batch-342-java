insert into type_dosen (kode_type_dosen, deskripsi) values 
('T001', 'Tetap'),
('T002', 'Honorer'),
('T003', 'Expertise');

insert into ujian (kode_ujian, nama_ujian, status_ujian) values
('U001','Algoritma','Aktif'),
('U002','Aljabar','Aktif'),
('U003','Statistika','Non Aktif'),
('U004','Etika Profesi','Non Aktif'),
('U005','Bahasa Inggris','Aktif');

insert into agama (kode_agama,deskripsi) values
('A001','Islam'),
('A002','Kristen'),
('A003','Katolik'),
('A004','Hindu'),
('A005','Budha');

insert into jurusan (kode_jurusan,nama_jurusan,status_jurusan) values
('J001','Teknik Informatika', 'Aktif'),
('J002','Management Informatika', 'Aktif'),
('J003','Sistem Informasi', 'Non Aktif'),
('J004','Sistem Komputer', 'Aktif'),
('J005','Komputer Akuntansi', 'Non Aktif');

insert into dosen (kode_dosen,nama_dosen,kode_jurusan,kode_type_dosen) values
('D001','Prof. Dr. Retno Wahyuningsih','J001','T002'),
('D002','Prof. Roy M. Sutikno','J002','T001'),
('D003','Prof. Hendri A. Verburgh','J003','T002'),
('D004','Prof. Risma Suparwata','J004','T002'),
('D005','Prof. Amir Sjarifuddin Madjid, MM, MA','J005','T001');

insert into mahasiswa (kode_mahasiswa,nama_mahasiswa,alamat,kode_agama,kode_jurusan) values
('M001','Budi Gunawan','Jl. Mawar No 3 RT 05 Cicalengka, Bandung','A001','J001'),
('M002','Rinto Raharjo','Jl. Kebagusan No. 33 RT04 RW06 Bandung','A002','J002'),
('M003','Asep Saepudin','Jl. Sumatera No. 12 RT02 RW01, Ciamis','A001','J003'),
('M004','M. Hafif Isbullah','Jl. Jawa No 01 RT01 RW01, Jakarta Pusat','A001','J001'),
('M005','Cahyono','Jl. Niagara No. 54 RT01 RW09, Surabaya','A003','J002');

insert into nilai (kode_mahasiswa,kode_ujian,nilai) values
('M004','U001',90),
('M001','U001',80),
('M002','U003',85),
('M004','U002',95),
('M005','U005',70);