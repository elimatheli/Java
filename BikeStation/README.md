#dépôt du TP3 de POO des étudiants Eliot VISEUX et Ju-Chan HWANG.

Comme décrit au début du TP3, l'objectif de ce TP3 était :
  -d’apprendre à écrire une classe, (abordé au TP2 aussi)
  -d’apprendre à rédiger une documentation, (abordé au TP2 aussi)
  -d’utiliser une méthodologie rigoureuse basée sur les tests unitaires. (NOUVEAU)
Notamment nous avons appris à utiliser les commandes UNIX pour la compilation et l'exécution des classes et des tests; sans oublier le "main".

Pour générer la documentation se placer dans le dossier fichiers-tp et faire les commandes :
  javadoc Bike.java -d docs/Bike
  javadoc BikeStation.java -d docs/BikeStation
Pour consulter la documentation ouvrir dans un navigateur index.html qui se trouve dans les répertoires docs/Bike et docs/BikeStation.

Pour compiler les classes du projet se placer dans le répertoire fichier-tp et faire les commandes :
  javac Bike.java
  javac BikeMain.java
  javac BikeStation.java
  javac BikeStationMain.java

Pour compiler les tests (toujours dans le même répertoire) faire les commandes :
  javac -classpath test-1.7.jar test/BikeTest.java
  javac -classpath test-1.7.jar test/BikeStationTest.java
Pour exécuter les tests faire les commandes :
  java -jar test-1.7.jar BikeTest
  java -jar test-1.7.jar BikeStationTest

Pour exécuter les programmes "main" faire les commandes :
  java BikeMain
  java BikeStationMain <unEntier>

  exemples de cas avec succès:
    java BikeStationMain 0
    java BikeStationMain 1

  exemples de cas avec échec:
    java BikeStationMain 2
    java BikeStationMain 5
