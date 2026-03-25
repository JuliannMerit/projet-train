package com.example.projettrain.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests pour la classe Conducteur")
class ConducteurTest {

    private Conducteur conducteur;

    @BeforeEach
    void setUp() {
        conducteur = new Conducteur("email@example.com", "0123456789", Habilitation.TGV);
    }

    @Test
    @DisplayName("Constructeur par défaut crée un conducteur")
    void testConstructorDefault() {
        Conducteur conducteur2 = new Conducteur();
        assertNull(conducteur2.getCp());
        assertNull(conducteur2.getEmail());
        assertNull(conducteur2.getNumeroTel());
        assertNull(conducteur2.getHabilitation());
        assertNull(conducteur2.getTrains());
    }

    @Test
    @DisplayName("Constructeur paramétré initialise correctement les propriétés")
    void testConstructorWithParameters() {
        assertEquals("email@example.com", conducteur.getEmail());
        assertEquals("0123456789", conducteur.getNumeroTel());
        assertEquals(Habilitation.TGV, conducteur.getHabilitation());
    }

    @Test
    @DisplayName("Getter et Setter pour CP (identifiant)")
    void testCpGetterSetter() {
        Long cp = 1L;
        conducteur.setCp(cp);
        assertEquals(cp, conducteur.getCp());
    }

    @Test
    @DisplayName("Getter et Setter pour Email")
    void testEmailGetterSetter() {
        String newEmail = "newemail@example.com";
        conducteur.setEmail(newEmail);
        assertEquals(newEmail, conducteur.getEmail());
    }

    @Test
    @DisplayName("Getter et Setter pour Numero de Tel")
    void testNumeroTelGetterSetter() {
        String newNumero = "9876543210";
        conducteur.setNumeroTel(newNumero);
        assertEquals(newNumero, conducteur.getNumeroTel());
    }

    @Test
    @DisplayName("Getter et Setter pour Habilitation")
    void testHabilitationGetterSetter() {
        conducteur.setHabilitation(Habilitation.INTERCITES);
        assertEquals(Habilitation.INTERCITES, conducteur.getHabilitation());

        conducteur.setHabilitation(Habilitation.TER);
        assertEquals(Habilitation.TER, conducteur.getHabilitation());

        conducteur.setHabilitation(Habilitation.TOUT);
        assertEquals(Habilitation.TOUT, conducteur.getHabilitation());
    }

    @Test
    @DisplayName("Getter et Setter pour Liste de Trains")
    void testTrainsGetterSetter() {
        List<Train> trains = new ArrayList<>();
        trains.add(new Train(TypeMateriel.TGV, 300, conducteur));
        trains.add(new Train(TypeMateriel.TER, 200, conducteur));

        conducteur.setTrains(trains);

        assertEquals(2, conducteur.getTrains().size());
        assertEquals(TypeMateriel.TGV, conducteur.getTrains().get(0).getType());
        assertEquals(TypeMateriel.TER, conducteur.getTrains().get(1).getType());
    }

    @Test
    @DisplayName("Un conducteur peut avoir plusieurs trains")
    void testConducteurMultipleTrains() {
        List<Train> trains = new ArrayList<>();
        Train train1 = new Train(TypeMateriel.TGV, 400, conducteur);
        Train train2 = new Train(TypeMateriel.INTERCITES, 250, conducteur);
        Train train3 = new Train(TypeMateriel.TER, 150, conducteur);

        trains.add(train1);
        trains.add(train2);
        trains.add(train3);

        conducteur.setTrains(trains);

        assertEquals(3, conducteur.getTrains().size());
        assertTrue(conducteur.getTrains().contains(train1));
        assertTrue(conducteur.getTrains().contains(train2));
        assertTrue(conducteur.getTrains().contains(train3));
    }

    @Test
    @DisplayName("Tous les types d'habilitation sont accessibles")
    void testAllHabilitationTypes() {
        for (Habilitation hab : Habilitation.values()) {
            conducteur.setHabilitation(hab);
            assertEquals(hab, conducteur.getHabilitation());
        }
    }

    @Test
    @DisplayName("Email et Numero de Tel peuvent être modifiés")
    void testEmailAndTelModification() {
        String initialEmail = conducteur.getEmail();
        String initialTel = conducteur.getNumeroTel();

        conducteur.setEmail("modified@example.com");
        conducteur.setNumeroTel("1111111111");

        assertNotEquals(initialEmail, conducteur.getEmail());
        assertNotEquals(initialTel, conducteur.getNumeroTel());
        assertEquals("modified@example.com", conducteur.getEmail());
        assertEquals("1111111111", conducteur.getNumeroTel());
    }
}

