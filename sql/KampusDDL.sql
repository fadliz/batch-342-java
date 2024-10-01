create table type_dosen (
	id serial not null primary key,
	kode_type_dosen varchar(10) unique not null,
	deskripsi varchar(50) not null
);

create table dosen (
	id serial not null primary key,
	kode_dosen varchar(10) unique not null,
	nama_dosen varchar(255) not null,
	kode_jurusan varchar(10) not null,
	kode_type_dosen varchar(10) not null
);

create table jurusan (
	id serial not null primary key,
	kode_jurusan varchar(10) unique not null,
	nama_jurusan varchar(255) not null,
	status_jurusan varchar(50) not null
);

create table mahasiswa (
	id serial not null primary key,
	kode_mahasiswa varchar(10) unique not null,
	nama_mahasiswa varchar(255) not null,
	alamat varchar(255) null,
	kode_agama varchar(10) not null,
	kode_jurusan varchar(10) not null
);

create table ujian (
	id serial not null primary key,
	kode_ujian varchar(10) unique not null,
	nama_ujian varchar(50) not null,
	status_ujian varchar(10) not null
);

create table nilai (
	id serial not null primary key,
	kode_mahasiswa varchar(10) not null,
	kode_ujian varchar(10) not null,
	nilai smallint not null
);

create table agama (
	id serial not null primary key,
	kode_agama varchar(10) unique not null,
	deskripsi varchar(50) not null
);

alter table dosen 
	add constraint fk_dosen_jurusan foreign key (kode_jurusan) 
	references jurusan (kode_jurusan);

alter table dosen
	add constraint fk_dosen_type_dosen foreign key (kode_type_dosen)
	references type_dosen (kode_type_dosen);
	
alter table mahasiswa
	add constraint fk_mahasiswa_agama foreign key (kode_agama)
	references agama (kode_agama);

alter table mahasiswa
	add constraint fk_mahasiswa_jurusan foreign key (kode_jurusan)
	references jurusan (kode_jurusan);
	
alter table nilai 
	add constraint fk_nilai_mahasiswa foreign key (kode_mahasiswa)
	references mahasiswa (kode_mahasiswa);

alter table nilai 
	add constraint fk_nilai_ujian foreign key (kode_ujian)
	references ujian (kode_ujian);
	