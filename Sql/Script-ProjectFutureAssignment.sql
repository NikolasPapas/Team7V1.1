DROP DATABASE IF EXISTS project;
CREATE DATABASE IF NOT EXISTS project;
USE project;


CREATE TABLE Owner(
	OWNER_ID binary(16) NOT NULL PRIMARY KEY,
	OWNER_Name nvarchar(100) NOT NULL
    );
 
 
CREATE TABLE Insurance(
	INSU_ID binary(16) NOT NULL PRIMARY KEY,
	INSU_DayFrom date NOT NULL,
	INSU_DayTo date NOT NULL
);
	
    
CREATE TABLE Vehicle(
	VEHI_ID binary(16) NOT NULL PRIMARY KEY,
	VEHI_OwnerID binary(16) NOT NULL,
	VEHI_InsuID binary(16) NOT NULL,
	VEHI_Plate nvarchar(8) NOT NULL
);


/****** Object:  ForeignKey [FK_Vehicle_Owner] ******/
ALTER TABLE Vehicle ADD FOREIGN KEY(VEHI_OwnerID)
REFERENCES Owner (OWNER_ID);

/****** Object:  ForeignKey [FK_Vehicle_Insurance] ******/
ALTER TABLE Vehicle ADD FOREIGN KEY(VEHI_InsuID)
REFERENCES Insurance (INSU_ID);


/****** Owner [OWNER_ID ,OWNER_Name] ******/
insert into Owner values('82D58D49','Greg');
insert into Owner values('8CEE7A83','Oleg');
insert into Owner values('561E2D88','Pete');
insert into Owner values('28106345','Paul');
insert into Owner values('7012F5C7','Aura');
insert into Owner values('2E3074E7','Phil');


/****** Insurance [INSU_ID ,INSU_DayFrom, INSU_DayTo] ******/
insert into Insurance values ('3C86A592', '2018-7-04', '2016-7-04');
insert into Insurance values ('70C311F5', '2018-8-05', '2017-8-05');
insert into Insurance values ('82FF24BB', '2018-9-06', '2018-9-06');
insert into Insurance values ('EB812BF6', '2018-1-07', '2019-1-07');
insert into Insurance values ('52727945', '2018-4-09', '2018-6-10');
insert into Insurance values ('37757c10', '2018-6-10', '2018-8-11');
insert into Insurance values ('100177a0', '2018-6-10', '2019-8-11');
insert into Insurance values ('7539c39a', '2018-6-10', '2018-8-11');


/******   Vehicle  [VEHI_ID ,VEHI_OwnerID, VEHI_InsuID, VEHI_Plate] ******/
insert into Vehicle values ('dc887763','82D58D49', '3C86A592','ABC-1234');
insert into Vehicle values ('82ed54ba','8CEE7A83', '70C311F5','CBA-2341');
insert into Vehicle values ('5de8115e','561E2D88', '82FF24BB','BCA-3412');
insert into Vehicle values ('5bbb98fa','28106345', 'EB812BF6','BAC-4123');
insert into Vehicle values ('b9950fa6','7012F5C7', '52727945','CAB-4213');
insert into Vehicle values ('7903819b','2E3074E7', '37757c10','FET-4231');
insert into Vehicle values ('cad46de5','2E3074E7', '100177a0','CAB-4313');
insert into Vehicle values ('7eb88f8b','7012F5C7', '7539c39a','FET-4232');