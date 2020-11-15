VISEUX Eliot et HWANG Ju-Chan

L'objectif de ce TP4 était de comprendre et apprendre le packetage étroitement lié avec les commandes notamment le classpath.
Nous avons notamment abordé la notion de classe principale défini avec un fichier 'manifest'.


Se placer dans le répertoire fichiers-tp4.

Pour générer tous les fichiers nécessaires :
  make
Pour exécuter les tests DateTest :
  make DateTest
Pour exécuter le DateMain sans le fichier .jar :
  make DateMain
Pour exécuter le DateMain du fichier .jar :
  make jar
Pour exécuter DateMain avec le fichier .jar exécutable :
  make jar_exec

PS : Pour plus de détails regarder après cette ligne.





Pour générer la documentation :
  javadoc date -cp src -d docs
Pour voir la documentation se placer dans le répertoire docs et ouvrir dans un navigateur le fichier index.html

Pour compiler la classe Date :
  javac -d classes -cp classes -sourcepath src src/date/Date.java

Pour compiler les tests et les exécuter :
  javac -cp test-1.7.jar test/DateTest.java
  java -jar test-1.7.jar DateTest

Pour compiler la classe principale DateMain :
  javac -d classes -cp classes -sourcepath src src/date/DateMain.java
Pour exécuter le DateMain :
  java -cp classes date.DateMain

Pour générer le fichier .jar :
  cd classes
  jar cvf ../datemain.jar date
  cd ..
Pour visualiser le contenu de l'archive datemain.jar :
  jar tvf datemain.jar
Le ranger dans le répertoire tmp :
  mv datemain.jar tmp
Pour exécuter le DateMain du fichier .jar :
  java -cp tmp/datemain.jar date.DateMain

Pour compiler et exécuter le programme avec le .jar exécutable :
  cd classes
  jar cvfm ../datemain.jar ../manifest-date date
  cd ..
  java -jar datemain.jar
