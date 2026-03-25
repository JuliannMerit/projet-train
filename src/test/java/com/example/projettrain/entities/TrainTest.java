package com.example.projettrain.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests pour la classe Train")
class TrainTest {

    private Train train;
    private Conducteur conducteur;

    @BeforeEach
    void setUp() {
        conducteur = Conducteur.builder()
                .email("conducteur@example.com")
                .numeroTel("0123456789")
                .habilitation(Habilitation.TGV)
                .build();
        train = Train.builder()
                .type(TypeMateriel.TGV)
                .nombrePlace(400)
                .conducteur(conducteur)
                .build();
    }

    @Test
    @DisplayName("Constructeur par défaut crée un train vide")
    void testConstructorDefault() {
        Train train2 = new Train();
        assertNull(train2.getId());
        assertNull(train2.getType());
        assertEquals(0, train2.getNombrePlace());
        assertNull(train2.getConducteur());
    }

    @Test
    @DisplayName("Constructeur paramétré initialise correctement les propriétés")
    void testConstructorWithParameters() {
        assertEquals(TypeMateriel.TGV, train.getType());
        assertEquals(400, train.getNombrePlace());
        assertEquals(conducteur, train.getConducteur());
    }

    @Test
    @DisplayName("Getter et Setter pour ID")
    void testIdGetterSetter() {
        Long id = 1L;
        train.setId(id);
        assertEquals(id, train.getId());
    }

    @Test
    @DisplayName("Getter et Setter pour Type de Materiel")
    void testTypeGetterSetter() {
        train.setType(TypeMateriel.INTERCITES);
        assertEquals(TypeMateriel.INTERCITES, train.getType());

        train.setType(TypeMateriel.TER);
        assertEquals(TypeMateriel.TER, train.getType());

        train.setType(TypeMateriel.RER);
        assertEquals(TypeMateriel.RER, train.getType());
    }

    @Test
    @DisplayName("Getter et Setter pour Nombre de Places")
    void testNombrePlaceGetterSetter() {
        train.setNombrePlace(500);
        assertEquals(500, train.getNombrePlace());

        train.setNombrePlace(200);
        assertEquals(200, train.getNombrePlace());

        train.setNombrePlace(0);
        assertEquals(0, train.getNombrePlace());
    }

    @Test
    @DisplayName("Getter et Setter pour Conducteur")
    void testConducteurGetterSetter() {
        Conducteur newConducteur = Conducteur.builder()
                .email("new@example.com")
                .numeroTel("9876543210")
                .habilitation(Habilitation.TER)
                .build();
        train.setConducteur(newConducteur);

        assertEquals(newConducteur, train.getConducteur());
        assertEquals("new@example.com", train.getConducteur().getEmail());
    }

    @Test
    @DisplayName("Un train a toujours un conducteur")
    void testTrainHasConductor() {
        assertNotNull(train.getConducteur());
        assertEquals(conducteur, train.getConducteur());
    }

    @Test
    @DisplayName("Tous les types de materiel sont accessibles")
    void testAllTypeMateriel() {
        for (TypeMateriel type : TypeMateriel.values()) {
            train.setType(type);
            assertEquals(type, train.getType());
        }
    }

    @Test
    @DisplayName("Le nombre de places peut être modifié")
    void testNombrePlaceModification() {
        int initialPlace = train.getNombrePlace();
        train.setNombrePlace(600);

        assertNotEquals(initialPlace, train.getNombrePlace());
        assertEquals(600, train.getNombrePlace());
    }

    @Test
    @DisplayName("Le conducteur peut être changé")
    void testConducteurChange() {
        Conducteur firstConducteur = train.getConducteur();
        Conducteur secondConducteur = Conducteur.builder()
                .email("second@example.com")
                .numeroTel("5555555555")
                .habilitation(Habilitation.INTERCITES)
                .build();

        train.setConducteur(secondConducteur);

        assertNotEquals(firstConducteur.getEmail(), train.getConducteur().getEmail());
        assertEquals("second@example.com", train.getConducteur().getEmail());
    }

    @Test
    @DisplayName("Creer plusieurs trains avec le même conducteur")
    void testMultipleTrainsWithSameConductor() {
        Train train2 = Train.builder()
                .type(TypeMateriel.TER)
                .nombrePlace(250)
                .conducteur(conducteur)
                .build();
        Train train3 = Train.builder()
                .type(TypeMateriel.METRO)
                .nombrePlace(150)
                .conducteur(conducteur)
                .build();

        assertEquals(conducteur, train.getConducteur());
        assertEquals(conducteur, train2.getConducteur());
        assertEquals(conducteur, train3.getConducteur());

        assertEquals("conducteur@example.com", train.getConducteur().getEmail());
        assertEquals("conducteur@example.com", train2.getConducteur().getEmail());
        assertEquals("conducteur@example.com", train3.getConducteur().getEmail());
    }

    @Test
    @DisplayName("Verifier les valeurs initiales du train")
    void testInitialValues() {
        assertEquals(TypeMateriel.TGV, train.getType());
        assertEquals(400, train.getNombrePlace());
        assertNotNull(train.getConducteur());
    }

    @Test
    @DisplayName("Nombre de places accepte et stocke correctement des valeurs positives")
    void testNombrePlaceAvecValeursPositives() {
        train.setNombrePlace(100);
        assertEquals(100, train.getNombrePlace());

        train.setNombrePlace(1);
        assertEquals(1, train.getNombrePlace());

        train.setNombrePlace(1000);
        assertEquals(1000, train.getNombrePlace());
    }
}

