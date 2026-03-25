-- Insertion de conducteurs
INSERT INTO conducteurs (email, numero_tel, habilitation) VALUES ('conducteur1@railway.com', '0123456789', 'TGV');
INSERT INTO conducteurs (email, numero_tel, habilitation) VALUES ('conducteur2@railway.com', '0987654321', 'TER');
INSERT INTO conducteurs (email, numero_tel, habilitation) VALUES ('conducteur3@railway.com', '0612345678', 'TOUT');

-- Insertion de trains
INSERT INTO trains (type, nombre_place, conducteur_id) VALUES ('TGV', 400, 1);
INSERT INTO trains (type, nombre_place, conducteur_id) VALUES ('TER', 250, 2);
INSERT INTO trains (type, nombre_place, conducteur_id) VALUES ('INTERCITES', 300, 1);
INSERT INTO trains (type, nombre_place, conducteur_id) VALUES ('METRO', 150, 3);

