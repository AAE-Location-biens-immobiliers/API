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
INSERT INTO comptes(id, password, nom, prenom, tel, email, locataire) VALUES('8', 'Julien78', 'Julien', 'Raynal', '0781545409', 'julien.raynal@yahoo.fr', false);


INSERT INTO habitations(id_habitation, climatisation, code, cuisine, description, latitude, lave_linge, longitude, numero, parking, pays, photo, rue, seche_linge, tv, ville, wifi, id_personne) VALUES(1, false, 12345, true, 'Nice F2', '48.42288513910234', true, '-71.0668035306421',518, false, 'Canada', null, 'rue Morin', true, false, 'Chicoutimi', true, 8);
INSERT INTO annonces(id_annonce, description, disponibilite, prix, idhabitation) VALUES(1, 'Cozy place to live', NOW(), 36.00, 1);
