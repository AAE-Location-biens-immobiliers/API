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
INSERT INTO comptes(id, password, nom, prenom, tel, email, locataire) VALUES('1', 'roger_password', 'Des Jardins', 'Roger', '0675348654', 'roger.desjardins@yahoo.fr', true);
INSERT INTO comptes(id, password, nom, prenom, tel, email, locataire) VALUES('2', 'albert_password', 'Laurent', 'Albert', '0756431850', 'albert.laurent@yahoo.fr', true);
INSERT INTO comptes(id, password, nom, prenom, tel, email, locataire) VALUES('3', 'jean_password', 'Battut', 'Jean', '0876291072', 'jean.battut@yahoo.fr', true);
INSERT INTO comptes(id, password, nom, prenom, tel, email, locataire) VALUES('4', 'martin_password', 'Toby', 'Martin', '0602035602', 'martin.toby@yahoo.fr', true);
INSERT INTO comptes(id, password, nom, prenom, tel, email, locataire) VALUES('5', 'joel_password', 'Fragne', 'Joel', '0792837474', 'joel.fragne@yahoo.fr', true);

INSERT INTO comptes(id, password, nom, prenom, tel, email, locataire) VALUES('6', 'admin1_password', 'prenom1', 'nom1', '0000000000', 'admin1@admin.fr', false);
INSERT INTO comptes(id, password, nom, prenom, tel, email, locataire) VALUES('7', 'admin2_password', 'prenom2', 'nom2', '0000000001', 'admin2@admin.fr', false);
