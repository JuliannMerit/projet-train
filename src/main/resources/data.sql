-- Insertion de conducteurs
INSERT INTO conducteurs (email, numero_tel, habilitation) VALUES ('conducteur1@railway.com', '0123456789', 'TGV');
INSERT INTO conducteurs (email, numero_tel, habilitation) VALUES ('conducteur2@railway.com', '0987654321', 'TER');
INSERT INTO conducteurs (email, numero_tel, habilitation) VALUES ('conducteur3@railway.com', '0612345678', 'TOUT');

-- Insertion de trains
INSERT INTO trains (type, nombre_place, conducteur_id) VALUES ('TGV', 400, 1);
INSERT INTO trains (type, nombre_place, conducteur_id) VALUES ('TER', 250, 2);
INSERT INTO trains (type, nombre_place, conducteur_id) VALUES ('INTERCITES', 300, 1);
INSERT INTO trains (type, nombre_place, conducteur_id) VALUES ('METRO', 150, 3);

INSERT INTO gares (id_gare, nom_gare, ville, nombre_quais) VALUES ('1L', 'Nantes Est', 'Nantes', 5);
INSERT INTO gares (id_gare, nom_gare, ville, nombre_quais) VALUES ('2L', 'Rennes Nord', 'Rennes', 3);
INSERT INTO gares (id_gare, nom_gare, ville, nombre_quais) VALUES ('3L', 'Bordeaux Sud', 'Bordeaux', 5);
INSERT INTO gares (id_gare, nom_gare, ville, nombre_quais) VALUES ('4L', 'Montparnasse', 'Paris', 15);