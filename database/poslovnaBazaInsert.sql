insert into mesto values ('Novi Sad', '21000');
insert into mesto values ('Beograd', '11000');
insert into mesto values ('Zrenjanin', '23000');
insert into mesto values ('Subotica', '24000');
insert into mesto values ('Nis', '18000');
insert into mesto values ('Vrbas', '21460');
insert into mesto values ('Kragujevac', '34000');
insert into mesto values ('Vrsac', '26300');

insert into jedinicaMere values ('gr');
insert into jedinicaMere values ('kg');
insert into jedinicaMere values ('to');
insert into jedinicaMere values ('mm');
insert into jedinicaMere values ('mg');
insert into jedinicaMere values ('cm');
insert into jedinicaMere values ('me');
insert into jedinicaMere values ('km');
insert into jedinicaMere values ('dl');
insert into jedinicaMere values ('li');

insert into preduzece values ('Mikromarket', '012345678', 'Cirpanova 12', 1);
insert into preduzece values ('Drinkstore', '123456789', 'Milutina Milankovica 10', 2);
insert into preduzece values ('Stark', '234567890', 'Puskinova 10', 3);
insert into preduzece values ('Marbo', '345678901', 'Curuska 20', 4);
insert into preduzece values ('Market1', '456789012', 'Vojvodjanska 15', 2);
insert into preduzece values ('Market2', '567890123', 'Gunduliceva 5', 3);
insert into preduzece values ('Market3', '678901234', 'Stankova 17', 4);

insert into grupaRoba values ('Pica', 2);
insert into grupaRoba values ('Slatkisi', 3);
insert into grupaRoba values ('Grickalice', 4);

insert into poslovniPartner values ('dobavljac', 'Drinkstore(dobavljac za pica)', '123456789', 'Milutina Milankovica 10', 2, 2);
insert into poslovniPartner values ('dobavljac', 'Stark(dobavljac za slatkise)', '234567890', 'Puskinova 10', 3, 3);
insert into poslovniPartner values ('dobavljac', 'Marbo(dobavljac za grickalice)', '345678901', 'Curuska 20', 4, 4);
insert into poslovniPartner values ('kupac', 'Market1(kupac za pica)', '456789012', 'Vojvodjanska 15', 5, 5);
insert into poslovniPartner values ('kupac', 'Market2(kupac za slatkise)', '567890123', 'Gunduliceva 5', 6, 6);
insert into poslovniPartner values ('kupac', 'Market3(kupac za grickalice)', '678901234', 'Stankova 17', 7, 7);

insert into magacin values ('prvi', 1);
insert into magacin values ('drugi', 2);
insert into magacin values ('treci', 3);

insert into poslovnaGodina values ('2017-01-01', 0, 1);

insert into radnik values ('Aleksa', 'Radanov', '1111111111111', 'Cirpanova 49', 'fizikalac', 'aleksa', 'radanov', 1);
insert into radnik values ('Filip', 'Covic', '2222222222222', 'Micurinova 11', 'fizikalac', 'filip', 'covic', 1);
insert into radnik values ('Dejan', 'Davidovac', '3333333333333', 'Puskinova 1', 'vozac', 'dejan', 'davidovac', 1);
insert into radnik values ('Nemanja', 'Dangubic', '1717171717171', 'Dokijeva 17', 'magacioner', 'nemanja', 'dangubic', 1);

insert into radnik values ('Dragan', 'Apic', '4444444444444', 'Alekse Santica 11', 'fizikalac', 'dragan', 'apic', 1);
insert into radnik values ('Stefan', 'Lazarevic', '5555555555555', 'Maksima Gorkog 49', 'fizikalac', 'stefan', 'lazarevic', 1);
insert into radnik values ('Aleksandar', 'Bursac', '6666666666666', 'Mise Dimitrijevica 49', 'vozac', 'aleksandar', 'bursac', 1);
insert into radnik values ('Petar', 'Kocic', '1818181818181', 'Marka Ruzina 17', 'magacioner', 'petar', 'kocic', 1);

insert into radnik values ('Rados', 'Seslija', '7777777777777', 'Ustanicka 49', 'fizikalac', 'rados', 'seslija', 1);
insert into radnik values ('Dusan', 'Kutlesic', '8888888888888', 'Gunduliceva 49', 'fizikalac', 'dusan', 'kutlesic', 1);
insert into radnik values ('Marko', 'Ljubicic', '9999999999999', 'Vojvodjanska 49', 'vozac', 'marko', 'ljubicic', 1);
insert into radnik values ('Luka', 'Mitrovic', '1919191919191', 'Vesina 17', 'magacioner', 'luka', 'mitrovic', 1);

insert into roba values ('Rubinov Vinjak', 1, 1, 10);
insert into roba values ('Coca-cola', 1, 1, 10);
insert into roba values ('Sprite', 1, 1, 10);

insert into roba values ('Napolitanke', 150, 2, 1);
insert into roba values ('Isleri', 200, 2, 1);
insert into roba values ('Medenjaci', 150, 2, 1);

insert into roba values ('Smoki', 100, 3, 1);
insert into roba values ('Cips', 90, 3, 1);
insert into roba values ('Kikiriki', 100, 3, 1);











