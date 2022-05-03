insert into Question (number,text) values (1,  'Traversant une dizaine de pays, le Danube est le plus long fleuve d''Europe.');
insert into Question (number,text) values (2,  'La superficie des États-Unis est plus grande que celle de l''Antarctique.');
insert into Question (number,text) values (3,  'Le 4 juillet 1959, Neil Armstrong devient le premier homme à marcher sur la Lune.');

insert into Question (number,text) values (4,'David Bowie est mort deux jours après le lancement de son dernier album, Blackstar.');

insert into Question (number,text) values (5,'Le 16 janvier 2016, la NASA a annoncé avoir réussi à faire éclore la première fleur dans l''espace.');

insert into Question (number,text) values (6,'Dans le conte de Charles Perrault, la belle au bois dormant a deux enfants avec le prince.');

insert into Question (number,text) values (7,'Brian May, le guitariste de Queen, est détenteur d''un PhD en astrophysique.');

insert into Question (number,text) values (8,'Le père de BigFlo et Oli est un chanteur de salsa argentine.');


insert into Question (number,text) values (9,'Once Upon a Time in... Hollywood signe la troisième collaboration entre Leonardo DiCaprio et Quentin Tarantino.');

insert into Question (number,text) values (10,'En 1983, le premier trophée de la Coupe du monde a été volé et n''a jamais été retrouvé.');

--ALTER SEQUENCE QUESTION_SEQ restart 20;

INSERT INTO Answer (id,question_number,agree,date_added) VALUES (1,1,true,'2020-08-12');
INSERT INTO Answer (id,question_number,agree,date_added) VALUES (2,1,false,'2020-08-11');
INSERT INTO Answer (id,question_number,agree,date_added) VALUES (3,1,true,'2020-08-11');
INSERT INTO Answer (id,question_number,agree,date_added) VALUES (4,2,true,'2020-05-30');
INSERT INTO Answer (id,question_number,agree,date_added) VALUES (5,2,true,'2020-05-30');
INSERT INTO Answer (id,question_number,agree,date_added) VALUES (6,2,true,'2020-05-25');
INSERT INTO Answer (id,question_number,agree,date_added) VALUES (7,2,true,'2020-05-22');
INSERT INTO Answer (id,question_number,agree,date_added) VALUES (8,2,true,'2020-06-01');
INSERT INTO Answer (id,question_number,agree,date_added) VALUES (9,3,true,'2020-08-19');
INSERT INTO Answer (id,question_number,agree,date_added) VALUES (10,4,true,'2020-08-17');

ALTER SEQUENCE ANSWER_ID_SEQ restart with 20;
ALTER SEQUENCE QUESTION_ID_SEQ restart with 20;

