drop database if exists laScopa;
create database laScopa;
use scopa;
drop user if exists 'admin'@'%';
create user 'admin'@'%' identified by 'admin';

create table account_(
id					int not null auto_increment,
username 			varchar(50) unique,
psw 				varchar(15),
attivo 				boolean,
primary key(id)
);

create table giocatore_(
id_account 			int,
nickname			varchar(30) unique,
avatar 				varchar(50),
primary key (id_account),
foreign key (id_account) references account_(id) on delete cascade
);

create table gestoreUtenti_(
id_account			int,
nome 				varchar(30),
cognome				varchar(30),
primary key (id_account),
foreign key (id_account) references account_(id) on delete cascade
);

create table partita_(
id_partita 			int not null auto_increment,
data_ 				date,
giocatore_uno		varchar(30),
giocatore_due 		varchar(30),
punteggio_uno 		int default null,
punteggio_due 		int default null,
vincitore 			varchar(30) default null,
primary key (id_partita),
foreign key (giocatore_uno) references giocatore_(nickname) on delete cascade,
foreign key (giocatore_due) references giocatore_(nickname) on delete cascade
);

create table punteggio_(
id_punteggio		int not null auto_increment,
id_partita			int,
giocatore			varchar(30),
scope				int default 0,
carte_lunghe		int default 0,
sette_denari		int default 0,
carte_denari		int default 0,
settanta			int default 0,
totale				int default 0,
primary key (id_punteggio),
foreign key (id_partita) references partita_(id_partita) on delete cascade/*,
foreign key (giocatore) references giocatore_(nickname) on delete cascade*/
);

delimiter $$
create procedure laScopa.insertGiocatore( in _username varchar(50),
										in _password varchar(15),
                                        in _nickname varchar(30),
                                        in _avatar_path varchar(50))
begin
	declare __id_account int default 0;
	declare exit handler for sqlexception
	begin 
		rollback;
		signal sqlstate '45000' set message_text = 'eccezione SQL';
	end;
	
    start transaction;
	insert into account_(username,psw) values(_username,_password);
    set __id_account = last_insert_id();
    if __id_account > 0 then
		insert into giocatore_(id_account,nickname,avatar) values(__id_account,_nickname,_avatar_path);
        commit;
	end if;
end$$
delimiter ;

delimiter $$
create procedure laScopa.insertGestoreUtenti( in _username varchar(50),
											in _password varchar(15),
                                            in _nickname varchar(30),
                                            in _nome varchar(30),
                                            in _cognome varchar(30))
begin
	declare __id_account int default 0;
    declare exit handler for sqlexception
	begin 
		rollback;
		signal sqlstate '45000' set message_text = 'eccezione SQL';
	end;
    start transaction;
	insert into account_(username,psw) values(_username,_password);
    set __id_account = last_insert_id();
    if __id_account > 0 then
		insert into gestoreUtenti_(id_account,nome,cognome) values(__id_account,_nome,_cognome);
        commit;
	end if;
end$$
delimiter ;

delimiter $$
create procedure laScopa.insertPartita(   in _giocatore_uno varchar(30),
										in _giocatore_due varchar(30),
                                        in _data date,
                                        in _vincitore varchar(30))
begin
	declare __id_partita int default 0;
    declare exit handler for sqlexception
	begin 
		rollback;
		signal sqlstate '45000' set message_text = 'eccezione SQL';
	end;
    start transaction;
	insert into partita_(giocatore_uno,giocatore_due,data_,vincitore) values(_giocatore_uno,_giocatore_due,_data,_vincitore);
    set __id_partita = last_insert_id();
    if __id_partita > 0 then
		insert into punteggio_(id_partita,giocatore) values(__id_partita,_giocatore_uno);
        insert into punteggio_(id_partita,giocatore) values(__id_partita,_giocatore_due);
        commit;
	end if;
end$$
delimiter ;

delimiter $$
create procedure laScopa.insertPunteggio( in _id_partita int,
										in _giocatore varchar(30), 
                                        in _scope int, 
                                        in _carte_lunghe int, 
                                        in _sette_denari int, 
                                        in _settanta int, 
                                        in _carte_denari int, 
                                        in _totale int)
begin
    declare exit handler for sqlexception
	begin 
		rollback;
		signal sqlstate '45000' set message_text = 'eccezione SQL';
	end;
    start transaction;
	insert into punteggio_(id_partita,giocatore,scope,carte_lunghe,sette_denari,settanta,carte_denari,totale) 
		values(_id_partita,_giocatore,_scope,_carte_lunghe,_sette_denari,_settanta,_carte_denari,_totale);
    commit;
end$$
delimiter ;


delimiter $$
create procedure laScopa.insertPartitaFull(   in _giocatore_uno varchar(30),
											in _giocatore_due varchar(30),
											in _data date,
											in _vincitore varchar(30),
											in _scope_uno int, 
											in _carte_lunghe_uno int, 
											in _sette_denari_uno int, 
											in _settanta_uno int, 
											in _carte_denari_uno int, 
											in _totale_uno int,
											in _scope_due int, 
											in _carte_lunghe_due int, 
											in _sette_denari_due int, 
											in _settanta_due int, 
											in _carte_denari_due int, 
											in _totale_due int)
begin
	declare __id_partita int default 0;
    declare exit handler for sqlexception
	begin 
		rollback;
		signal sqlstate '45000' set message_text = 'eccezione SQL';
	end;
    start transaction;
	insert into partita_(giocatore_uno,giocatore_due,data_,vincitore) values(_giocatore_uno,_giocatore_due,_data,_vincitore);
    set __id_partita = last_insert_id();
    if __id_partita > 0 then
		call insertPunteggio(__id_partita,_giocatore_uno,_scope_uno,_carte_lunghe_uno,_sette_denari_uno,_settanta_uno,_carte_denari_uno,_totale_uno);
        call insertPunteggio(__id_partita,_giocatore_due,_scope_due,_carte_lunghe_due,_sette_denari_due,_settanta_due,_carte_denari_due,_totale_due);
		commit;
    end if;
    
end$$
delimiter ;

delimiter $$
create procedure laScopa.disattivaAccount(in _nickname varchar(30))
begin
	declare __id_account int default 0;
    declare exit handler for sqlexception
	begin 
		rollback;
		signal sqlstate '45000' set message_text = 'eccezione SQL';
	end;
    start transaction;
    set __id_account = (select giocatore_.id_account from giocatore_ where giocatore_.nickname = _nickname);
    if (__id_account > 0) then
		update account_ set account_.attivo = false where account_.id = __id_account;
		commit;
    end if;
end$$
delimiter ;


/*
delimiter $$
create procedure laScopa.decretaVincitore(in _idPartita int,in _nickname varchar(30))
begin
	declare __giocatore_uno varchar(30) default '';
    declare __giocatore_due varchar(30) default '';
    declare exit handler for sqlexception
	begin 
		rollback;
		signal sqlstate '45000' set message_text = 'eccezione SQL';
	end;
	set __giocatore_uno = (select giocatore_uno from partita_ where partita.id_partita = idPartita);
    set __giocatore_uno = (select giocatore_due from partita_ where partita.id_partita = idPartita);
    start transaction;
    if __giocatore_uno = _nickname  or __giocatore_due = _nickname then
		update partita set partita.vincitore = _nickname where partita.id_partita = _idPartita;
		commit;
	end if;
end$$
delimiter ;
*/