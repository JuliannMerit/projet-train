package com.example.projettrain.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests pour la classe Course")
class CourseTest {

    private Course course;

    @BeforeEach
    void setUp() {
        course = new Course();
    }

    @Test
    @DisplayName("Constructeur par défaut crée une course vide")
    void testConstructorDefault() {
        assertNull(course.getId());
        assertNull(course.getHeureDepart());
        assertNull(course.getHeureArrivee());
        assertNull(course.getGareOrigine());
        assertNull(course.getGareTerminus());
        assertNotNull(course.getParcours(), "parcours doit être initialisé");
        assertTrue(course.getParcours().isEmpty(), "parcours doit être vide au départ");
        assertNull(course.getTrain());
    }

    @Test
    @DisplayName("Getter et Setter pour ID")
    void testIdGetterSetter() {
        Long id = 10L;
        course.setId(id);
        assertEquals(id, course.getId());
    }

    @Test
    @DisplayName("Getter et Setter pour heureDepart")
    void testHeureDepartGetterSetter() {
        LocalDateTime dep = LocalDateTime.of(2026, 3, 25, 10, 15);
        course.setHeureDepart(dep);
        assertEquals(dep, course.getHeureDepart());
    }

    @Test
    @DisplayName("Getter et Setter pour heureArrivee")
    void testHeureArriveeGetterSetter() {
        LocalDateTime arr = LocalDateTime.of(2026, 3, 25, 12, 45);
        course.setHeureArrivee(arr);
        assertEquals(arr, course.getHeureArrivee());
    }

    @Test
    @DisplayName("Getter et Setter pour gareOrigine")
    void testGareOrigineGetterSetter() {
        Gares origine = new Gares("Gare A", "Ville A", 3);
        course.setGareOrigine(origine);
        assertEquals(origine, course.getGareOrigine());
        assertEquals("Gare A", course.getGareOrigine().getNomGare());
    }

    @Test
    @DisplayName("Getter et Setter pour gareTerminus")
    void testGareTerminusGetterSetter() {
        Gares terminus = new Gares("Gare B", "Ville B", 4);
        course.setGareTerminus(terminus);
        assertEquals(terminus, course.getGareTerminus());
        assertEquals("Ville B", course.getGareTerminus().getVille());
    }

    @Test
    @DisplayName("Getter et Setter pour parcours")
    void testParcoursGetterSetter() {
        List<CourseGare> parcours = new ArrayList<>();
        course.setParcours(parcours);

        assertNotNull(course.getParcours());
        assertSame(parcours, course.getParcours());
    }

    @Test
    @DisplayName("Getter et Setter pour train")
    void testTrainGetterSetter() {
        Conducteur conducteur = new Conducteur("c1@example.com", "0102030405", Habilitation.TGV);
        Train train = new Train(TypeMateriel.TGV, 400, conducteur);

        course.setTrain(train);
        assertEquals(train, course.getTrain());
        assertEquals(TypeMateriel.TGV, course.getTrain().getType());
    }
}

