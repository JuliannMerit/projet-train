package com.example.projettrain.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.test.context.ActiveProfiles;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests d'intégration Train-Conducteur")
@ActiveProfiles("test")
class TrainConducteurIntegrationTest {

    private Conducteur conducteur;
    private Train train1;
    private Train train2;
    private Train train3;

    @BeforeEach
    void setUp() {
        conducteur = new Conducteur("captain@railway.com", "0612345678", Habilitation.TOUT);
        train1 = new Train(TypeMateriel.TGV, 400, conducteur);
        train2 = new Train(TypeMateriel.TER, 250, conducteur);
        train3 = new Train(TypeMateriel.INTERCITES, 300, conducteur);
    }

    @Test
    @DisplayName("Un conducteur peut être lié à plusieurs trains")
    void testConducteurLinkedToMultipleTrains() {
        List<Train> trains = new ArrayList<>();
        trains.add(train1);
        trains.add(train2);
        trains.add(train3);

        conducteur.setTrains(trains);

        assertEquals(3, conducteur.getTrains().size());
        assertEquals(train1, conducteur.getTrains().getFirst());
        assertEquals(train2, conducteur.getTrains().get(1));
        assertEquals(train3, conducteur.getTrains().get(2));
    }

    @Test
    @DisplayName("Chaque train a un conducteur unique")
    void testEachTrainHasUniqueConductor() {
        assertEquals(conducteur, train1.getConducteur());
        assertEquals(conducteur, train2.getConducteur());
        assertEquals(conducteur, train3.getConducteur());

        assertEquals(conducteur.getEmail(), train1.getConducteur().getEmail());
        assertEquals(conducteur.getEmail(), train2.getConducteur().getEmail());
        assertEquals(conducteur.getEmail(), train3.getConducteur().getEmail());
    }

    @Test
    @DisplayName("Vérifier la relation bidirectionnelle Train-Conducteur")
    void testBidirectionalRelationship() {
        List<Train> trains = new ArrayList<>();
        trains.add(train1);
        trains.add(train2);
        conducteur.setTrains(trains);

        // Vérifier depuis le conducteur
        assertEquals(2, conducteur.getTrains().size());

        // Vérifier depuis chaque train
        for (Train train : conducteur.getTrains()) {
            assertEquals(conducteur, train.getConducteur());
            assertEquals("captain@railway.com", train.getConducteur().getEmail());
        }
    }

    @Test
    @DisplayName("Un conducteur peut avoir une habilitation adaptée à ses trains")
    void testConducteurHabilitationMatchesTrains() {
        conducteur.setHabilitation(Habilitation.TGV);
        train1.setType(TypeMateriel.TGV);
        train2.setType(TypeMateriel.TGV);

        List<Train> trains = new ArrayList<>();
        trains.add(train1);
        trains.add(train2);
        conducteur.setTrains(trains);

        assertEquals(Habilitation.TGV, conducteur.getHabilitation());
        for (Train train : conducteur.getTrains()) {
            // Les deux trains sont de type TGV
            assertEquals(TypeMateriel.TGV, train.getType());
        }
    }

    @Test
    @DisplayName("Modifier les propriétés d'un train lié à un conducteur")
    void testModifyTrainPropertiesWithConductor() {
        List<Train> trains = new ArrayList<>();
        trains.add(train1);
        conducteur.setTrains(trains);

        // Modifier le train
        train1.setNombrePlace(500);
        train1.setType(TypeMateriel.INTERCITES);

        // Vérifier que les modifications sont bien appliquées
        assertEquals(500, conducteur.getTrains().getFirst().getNombrePlace());
        assertEquals(TypeMateriel.INTERCITES, conducteur.getTrains().getFirst().getType());
        assertEquals(conducteur, conducteur.getTrains().getFirst().getConducteur());
    }

    @Test
    @DisplayName("Changer le conducteur d'un train")
    void testChangeConductorForTrain() {
        Conducteur newConductor = new Conducteur("newcaptain@railway.com", "0698765432", Habilitation.TER);

        train1.setConducteur(newConductor);

        assertEquals(newConductor, train1.getConducteur());
        assertEquals("newcaptain@railway.com", train1.getConducteur().getEmail());
        assertNotEquals(conducteur.getEmail(), train1.getConducteur().getEmail());
    }

    @Test
    @DisplayName("Vérifier les informations complètes d'un conducteur avec ses trains")
    void testCompleteConductorInformation() {
        List<Train> trains = new ArrayList<>();
        trains.add(train1);
        trains.add(train2);
        trains.add(train3);
        conducteur.setTrains(trains);

        // Vérifier les infos du conducteur
        assertEquals("captain@railway.com", conducteur.getEmail());
        assertEquals("0612345678", conducteur.getNumeroTel());
        assertEquals(Habilitation.TOUT, conducteur.getHabilitation());
        assertEquals(3, conducteur.getTrains().size());

        // Vérifier chaque train
        int totalPlaces = 0;
        for (Train train : conducteur.getTrains()) {
            assertNotNull(train.getType());
            assertTrue(train.getNombrePlace() > 0);
            assertEquals(conducteur, train.getConducteur());
            totalPlaces += train.getNombrePlace();
        }

        assertEquals(950, totalPlaces); // 400 + 250 + 300
    }

    @Test
    @DisplayName("Créer plusieurs conducteurs avec leurs propres trains")
    void testMultipleConductorsWithTheirTrains() {
        Conducteur conductor1 = new Conducteur("conductor1@railway.com", "0611111111", Habilitation.TGV);
        Conducteur conductor2 = new Conducteur("conductor2@railway.com", "0622222222", Habilitation.TER);

        Train trainC1 = new Train(TypeMateriel.TGV, 400, conductor1);
        Train trainC2 = new Train(TypeMateriel.TER, 250, conductor2);

        List<Train> trainsC1 = new ArrayList<>();
        trainsC1.add(trainC1);
        conductor1.setTrains(trainsC1);

        List<Train> trainsC2 = new ArrayList<>();
        trainsC2.add(trainC2);
        conductor2.setTrains(trainsC2);

        // Vérifier que chaque conducteur a ses propres trains
        assertEquals(1, conductor1.getTrains().size());
        assertEquals(1, conductor2.getTrains().size());
        assertEquals("conductor1@railway.com", conductor1.getTrains().getFirst().getConducteur().getEmail());
        assertEquals("conductor2@railway.com", conductor2.getTrains().getFirst().getConducteur().getEmail());
    }

    @Test
    @DisplayName("Vérifier que les modifications sont persistantes dans la relation")
    void testRelationshipPersistenceAfterModification() {
        List<Train> trains = new ArrayList<>();
        trains.add(train1);
        conducteur.setTrains(trains);

        // Modifier le conducteur
        conducteur.setEmail("newemail@railway.com");

        // Vérifier que les trains récupèrent le conducteur modifié
        assertEquals("newemail@railway.com", train1.getConducteur().getEmail());

        // Modifier le train
        train1.setNombrePlace(450);

        // Vérifier que les modifications du train sont visibles depuis le conducteur
        assertEquals(450, conducteur.getTrains().getFirst().getNombrePlace());
    }
}

