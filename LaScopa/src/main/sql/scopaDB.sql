/*drop database if exists LaScopa;*/

create database if not exists LaScopa;

/*drop user if exists 'admin'@'%';*/

create user if not exists 'admin'@'localhost' identified by 'admin';

grant all privileges on LaScopa.* to 'admin'@'localhost';

use LaScopa;

create table if not exists account_(
	id					integer not null auto_increment,
	username 			varchar(50) unique,
	psw 				varchar(15),
	attivo 				boolean,
    
	primary key(id)
);

create table if not exists giocatore_(
	id_account 			integer,
	avatar 				varchar(50),
	disponibile 		boolean,
    
	foreign key (id_account) references account_(id) on delete cascade
);

create table if not exists gestoreUtenti_(
	id_account			integer,
	nome 				varchar(30),
	cognome				varchar(30),
    
	foreign key (id_account) references account_(id) on delete cascade
);

create table if not exists partita_(
	id_partita 			integer not null auto_increment,
	data_ 				date,
	giocatore_uno		int,
	giocatore_due 		int,
	punteggio_uno 		int default null,
	punteggio_due 		int default null,
	vincitore 			int default null,
    
	primary key (id_partita),
	foreign key (giocatore_uno) references giocatore_(id_account) on delete cascade,
	foreign key (giocatore_due) references giocatore_(id_account) on delete cascade
);

create table if not exists punteggio_(
	id_punteggio		integer not null auto_increment,
	id_partita			integer,
	id_giocatore		integer,
	scope				int default 0,
	carte_lunghe		int default 0,
	sette_d_oro			int default 0,
	carte_denari		int default 0,
	settanta			int default 0,
	totale				int default 0,
    
	primary key (id_punteggio),
	foreign key (id_partita) references partita_(id_partita) on delete cascade,
	foreign key (id_giocatore) references giocatore_(id_account) on delete cascade
);

/*insert into account_ (username,psw,attivo) values('angelo','fiorillo',true);
insert into account_ (username,psw,attivo) values('simone','cristiano',true);
insert into account_(username,psw) values ('admin','password');
insert into giocatore_(id_account,avatar,disponibile) values (1,'c:\angelo\fiorillo\mio_path',true);
insert into giocatore_(id_account,avatar,disponibile) values (2,'c:\simone\cristiano\mio_path',true);
insert into gestoreUtenti_(id_account,nome,cognome,email) values (3,'pippo','franco','mia_email');

insert into partita_(data_,giocatore_uno,giocatore_due) values ('2022-01-28',1,2);
insert into punteggio_(id_partita,id_giocatore) values(1,1);
insert into punteggio_(id_partita,id_giocatore) values(1,2);

update partita_ set partita_.punteggio_uno = 1 where partita_.id_partita = 1;
update partita_ set partita_.punteggio_due = 2 where partita_.id_partita = 1;*/
