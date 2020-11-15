VISEUX Eliot et HWANG Ju-Chan

Se placer dans le répertoire Pfc.

Pour générer la documentation :
  make doc
Pour compiler les classes :
  make classes
Pour compiler les tests :
  make genTest
Pour exécuter le test ShapeTest :
  make ShapeTest
Pour exécuter le test PlayerTest :
  make PlayerTest
Pour exécuter le test GameTest :
  make GameTest
Pour compiler la fonction main de GameMain :
  make genGameMain
Pour exécuter le GameMain :
  java -cp classes pfc.GameMain {le nombre de tours que vous voulez}
Pour compiler le jar executable :
  make gen_jar_exec
Pour executer le jar executable :
  java -jar gamemain.jar {le nombre de tours que vous voulez}


POUR AJOUTER UNE NOUVELLE STRATÉGIE :

  Nous avons mis un squelette qui permettra d'ajouter une nouvelle stratégie :
    Voir le fichier SqueletteStrategy.java
  Le code de votre classe peut changer en fonction de votre stratégie.
  Cependant les éléments les plus importants sont :
    -package pfc.strategy; (le fichier doit se trouver dans le répertoire pfc/strategy)
    -import pfc.Shape; (il faut importer les Shape)
    -public class StrategyName implements Strategy{...} (surtout "implements Strategy")
    -au moins un constructeur ce serait bien
    -public Shape chooseShape() (une méthode qui a exactement cette signature car elle implémente l'interface Strategy)
