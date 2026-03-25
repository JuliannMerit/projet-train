# UI (interface graphique)

Ce dossier contient une **UI desktop très basique en Swing**, séparée du code Spring Boot.

## Pourquoi Swing ?
- Dépendances : **aucune** (JDK uniquement)
- Démarrage rapide pour un exemple d'IHM
- N'interfère pas avec Spring Boot (vous pouvez lancer l'un ou l'autre)

## Comment lancer l'exemple
L'exemple est la classe `com.example.projettrain.ui.BasicSwingUI`.

Idées d'évolution :
- Brancher la liste sur la base (via un `GaresRepository` Spring Data)
- Ajouter des écrans (trains, conducteurs), ou passer à JavaFX si besoin

