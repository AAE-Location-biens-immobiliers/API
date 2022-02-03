###################
#Configuration
###################
# create database db_sharaloc;
# create user 'sharalocuser'@'localhost' identified by 'sharaloc';
# grant all on db_sharaloc.* to 'sharalocuser'@'localhost';
###################
#Comptes
###################
USE db_sharaloc;
INSERT INTO comptes(id, identifiant, password, nom, prenom, tel, email, locataire) VALUES('1', 'roger_login', 'roger_password', 'Des Jardins', 'Roger', '0675348654', 'roger.desjardins@yahoo.fr', true );
INSERT INTO comptes(id, identifiant, password, nom, prenom, tel, email, locataire) VALUES('2', 'albert_login', 'albert_password', 'Laurent', 'Albert', '0756431850', 'albert.laurent@yahoo.fr', true );
INSERT INTO comptes(id, identifiant, password, nom, prenom, tel, email, locataire) VALUES('3', 'jean_login', 'jean_password', 'Battut', 'Jean', '0876291072', 'jean.battut@yahoo.fr', true );
INSERT INTO comptes(id, identifiant, password, nom, prenom, tel, email, locataire) VALUES('4', 'martin_login', 'martin_password', 'Toby', 'Martin', '0602035602', 'martin.toby@yahoo.fr', true );
INSERT INTO comptes(id, identifiant, password, nom, prenom, tel, email, locataire) VALUES('5', 'joel_login', 'joel_password', 'Fragne', 'Joel', '0792837474', 'joel.fragne@yahoo.fr', true );
