-- Insertion de conducteurs
INSERT INTO conducteurs (cp, email, numero_tel, habilitation) VALUES (1, 'conducteur1@railway.com', '0123456789', 'TGV');
INSERT INTO conducteurs (cp, email, numero_tel, habilitation) VALUES (2, 'conducteur2@railway.com', '0987654321', 'TER');
INSERT INTO conducteurs (cp, email, numero_tel, habilitation) VALUES (3, 'conducteur3@railway.com', '0612345678', 'TOUT');

-- Insertion de trains
INSERT INTO trains (id, type, nombre_place, conducteur_id) VALUES (1, 'TGV', 400, 1);
INSERT INTO trains (id, type, nombre_place, conducteur_id) VALUES (2, 'TER', 250, 2);
INSERT INTO trains (id, type, nombre_place, conducteur_id) VALUES (3, 'INTERCITES', 300, 1);
INSERT INTO trains (id, type, nombre_place, conducteur_id) VALUES (4, 'METRO', 150, 3);
