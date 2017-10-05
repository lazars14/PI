create database pi 

use pi

create table mesto
(
	id int identity(1,1) primary key not null,
	naziv varchar(50) not null,
	pttOznaka char(5) not null
);

create table jedinicaMere
(
	id int identity(1,1) primary key not null,
	naziv char(2) not null,
	constraint chk_naziv check (naziv in('gr', 'kg', 'to', 'mm', 'mg', 'cm', 'me', 'km', 'dl', 'li')) 
);

create table preduzece
(
	id int identity(1,1) primary key not null,
	naziv varchar(50) not null,
	pib char(9) not null,
	adresa varchar(50) not null,
	mesto int not null FOREIGN KEY REFERENCES mesto(id)
);

create table grupaRoba
(
	id int identity(1,1) primary key not null,
	naziv varchar(50) not null,
	preduzece int not null FOREIGN KEY REFERENCES preduzece(id)
);

create table radnik
(
	id int identity(1,1) primary key not null,
	ime varchar(50) not null,
	prezime varchar(50) not null,
	jmbg char(13) not null unique,
	adresa varchar(30) not null,
	radnoMesto varchar(50) not null,
	korisnickoIme varchar(10) not null unique,
	lozinka varchar(10) not null,
	preduzece int not null FOREIGN KEY REFERENCES preduzece(id)
);

create table poslovniPartner
(
	id int identity(1,1) primary key not null,
	tipPartnera varchar(50) not null,
	nazivPartnera varchar(50) not null,
	pib char(9) not null,
	adresa varchar(50) not null,
	preduzece int not null FOREIGN KEY REFERENCES preduzece(id),
	mesto int not null FOREIGN KEY REFERENCES mesto(id),
	constraint chk_tipPartnera check(tipPartnera in ('kupac', 'dobavljac', 'kupac i dobavljac'))
);

create table poslovnaGodina
(
	id int identity(1,1) primary key not null,
	godina date not null,
	zakljucena bit not null,
	preduzece int not null FOREIGN KEY REFERENCES preduzece(id)
);

create table magacin
(
	id int identity(1,1) primary key not null,
	naziv varchar(50) not null,
	preduzece int not null FOREIGN KEY REFERENCES preduzece(id)
);

create table prometniDokument
(
	id int identity(1,1) primary key not null,
	vrstaDokumenta char(2) not null,
	redniBrojDokumenta int not null,
	datumFormiranja date not null,
	datumKnjizenja date not null,
	statusDokumenta char(1) not null,
	magacin int not null FOREIGN KEY REFERENCES magacin(id),
	poslovniPartner int not null FOREIGN KEY REFERENCES poslovniPartner(id),
	constraint chk_vrstaDokumenta check (vrstaDokumenta in ('Pr', 'Ot', 'Mm')),
	constraint chk_statusDokumenta check (statusDokumenta in ('F', 'P', 'S'))
);

create table roba
(
	id int identity(1,1) primary key not null,
	naziv varchar(50) not null,
	pakovanje int not null,
	grupaRobe int not null FOREIGN KEY REFERENCES grupaRoba(id),
	jedinicaMere int not null FOREIGN KEY REFERENCES jedinicaMere(id)
);

create table robnaKartica
(
	id int identity(1,1) primary key not null,
	cena decimal(19,4) not null,
	pocStanjeKol int not null,
	pocStanjeVrednosti decimal(19,4) not null,
	prometUlazaKol int not null,
	prometUlazaVr decimal(19,4) not null,
	prometIzlazaKol int not null,
	prometIzlazaVr decimal(19,4) not null,
	ukKol int not null,
	ukVrednost decimal(19,4) not null,
	poslovnaGodina int not null FOREIGN KEY REFERENCES poslovnaGodina(id),
	magacin int not null FOREIGN KEY REFERENCES magacin(id),
	roba int not null FOREIGN KEY REFERENCES roba(id)
);

create table analitikaMagacinskeKartice
(
	id int identity(1,1) primary key not null,
	redniBroj int not null,
	vrstaPrometa varchar(50) not null,
	smer char(1) not null,
	kolicina int not null,
	cena decimal(19,4) not null,
	vrednost decimal(19,4) not null,
	robnaKartica int not null FOREIGN KEY REFERENCES robnaKartica(id),
	constraint chk_vrstaPrometa check (vrstaPrometa in ('PR', 'OT', 'MM', 'NI', 'PS', 'KOR')),
	constraint chk_smer check (smer in ('U', 'I'))
);

create table stavkaDokumenta
(
	id int identity(1,1) primary key not null,
	kolicina int not null,
	cena decimal(19,4) not null,
	vrednost decimal(19,4) not null,
	analitikaMagacinskeKartice int not null FOREIGN KEY REFERENCES analitikaMagacinskeKartice(id),
	roba int not null FOREIGN KEY REFERENCES roba(id),
	prometniDokument int not null FOREIGN KEY REFERENCES prometniDokument(id),
);


