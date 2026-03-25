# Configuration H2 et Tests Unitaires - Projet Train

## Résumé des modifications

### 1. **Correction des annotations Lombok**
- Les annotations `@Getter` et `@Setter` ont été déplacées au niveau de la classe (et non d'un seul champ)
- Cela permet à Lombok de générer les getters/setters pour **tous les champs** des classes Train et Conducteur

### 2. **Configuration H2**

#### Fichier principal : `application.properties`
```properties
spring.datasource.url=jdbc:h2:mem:traindb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

**Explications :**
- `jdbc:h2:mem:traindb` : Base de données H2 en mémoire
- `create-drop` : Crée les tables au démarrage et les supprime à l'arrêt
- `show-sql=true` : Affiche les requêtes SQL dans la console

#### Fichier de test : `application-test.properties`
- Configuration similaire mais avec `show-sql=false` pour ne pas polluer les logs de test
- Utilise une base de données de test en mémoire : `jdbc:h2:mem:testdb`

### 3. **Initialisation des données**

Le fichier `data.sql` dans `src/main/resources` :
- Est exécuté automatiquement par Spring Boot après la création des tables
- Insère 3 conducteurs et 4 trains de test
- Les données sont chargées à chaque démarrage (en raison de `create-drop`)

### 4. **Tests Unitaires**

Trois fichiers de test ont été créés/mises à jour :

1. **ConducteurTest.java** : Tests unitaires de la classe Conducteur
   - 11 tests couvrant tous les getters/setters
   - Tests des différents types d'habilitation

2. **TrainTest.java** : Tests unitaires de la classe Train
   - 11 tests couvrant tous les getters/setters
   - Tests de la relation avec Conducteur

3. **TrainConducteurIntegrationTest.java** : Tests d'intégration
   - 9 tests couvrant la relation bidirectionnelle
   - Tests de scénarios réalistes (plusieurs trains par conducteur, etc.)

### 5. **Accès à la console H2**

Une fois l'application démarrée :
- URL : `http://localhost:8080/h2-console`
- JDBC URL : `jdbc:h2:mem:traindb`
- Username : `sa`
- Password : (vide)

Cliquez sur "Connect" pour accéder à la console et explorer les données.

## Exécution des tests

```bash
# Exécuter tous les tests
mvnw.cmd test

# Exécuter un test spécifique
mvnw.cmd test -Dtest=ConducteurTest

# Exécuter les tests d'intégration uniquement
mvnw.cmd test -Dtest=TrainConducteurIntegrationTest
```

## Lancement de l'application

```bash
mvnw.cmd spring-boot:run
```

Les tables seront créées automatiquement et les données de test insérées.

