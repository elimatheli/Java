# Organisation Sportive

**Author** : Eliot Viseux - Thomas Vanderplancke 


## Howto :

### Récupération du dépôt :

Se mettre dans le dossier souhaité et taper la commande 
```bash
git clone https://gitlab-etu.fil.univ-lille1.fr/vanderplancke/vanderplancke-coo-projet.git
```

### Génération de tous les fichiers :

Se mettre dans le dossier principal là où se trouve le fichier Makefile et taper dans un terminal la commande,
```bash
make all
```
Les fichier .class se trouveront dans un dossier appelé *out*.

### Suppression des fichiers :

Se mettre dans le dossier principal là où se trouve le fichier Makefile et taper dans un terminal la commande,
```bash
make clean
```

### Génération de la documentation :

Se mettre dans le dossier principal là où se trouve le fichier Makefile et taper dans un terminal la commande,
```bash
make doc
```
La documentation se mettra dans un dossier appelé *Doc*.

### Génération de la documentation :

Se mettre dans le dossier principal là où se trouve le fichier Makefile et taper dans un terminal la commande,
```bash
make genTest
```
Les fichiers test se mettront dans le dossier *out*

### Génération de l'archive :

Se mettre dans le dossier principal où le fichier Makefile est présent et dans un terminal taper la commande,
```bash
make gen_jar_exec
```
L'executable se mettra dans le dossier principal sous le nom de *Executable.jar*.

### Execution de l'archive

Pour executer *Executable.jar*, dans le dossier principal ouvrir un terminal

**Si vous voulez une démo générée automatiquement** tapez :
```bash
java -jar Executable.jar demo
```
**Si vous voulez mettre vos propres arguments tapez** juste :
```bash
java -jar Executable.jar
```
et suivez les étapes.

## Principes de conceptions mis en œuvre :

### Test Driven Development

Pour développer ce projet, nous avons pratiqué le TDD (pour « test driven développement ») qui consiste à méler l'écriture des tests unitaires avec la programmation et l'amélioration continue du code. Avec cette méthode on écrit chaque test avant de l'implémenter en code source. L'ensemble des tests unitaires ce trouvent dans le package "test" du dossier src.

### Interface "Match"

Dans une optique d'évolution facile du code concernant les types de matchs, nous avons optés pour une approche de Factory Method, nous avons crée une interface "Match" qui sera la "fabrique" des différents matchs, par exemple nous avons la classe "BalancedMatch" qui en hérite et qui répresente un type de match où les chances de victoires des équipes sont égales, ainsi cela permettra d'ajouter de nouveaux types de match qui implémentent l'interface et de facilement remplacer une classe concraite par une autre.

### Classe abstraite "Compétition"

L'ensemble des compétitions (League, Tournament et Master) héritent de la classe abstraite "Competition". Ces classes ensuite doivent redéfinir la méthode "play" qui permet de distinguer les différentes façons dont les compétitions ont lieu.

### Design Pattern Strategy

Enfin afin de gérer le cas des différentes possibilités de sélection des compétiteurs pour la phase de Tournament, nous avons choisis le pattern Strategy pour gérer cela. Nous avons donc crée l’interface SelectionStrategy, qui implémente la méthode qui changera, ici selectCompetitorsForTournament().
Comme nous implémentons dans notre programme une option avec repêchage des meilleurs troisièmes ou sans repêchage. Nous avons donc deux classes qui implémentent cette interface et correspondent à ces besoins : NormalSelectionStrategy et TwoBestThirdsStrategy qui ont donc toutes les deux des façons de gérer une liste de compétiteurs différemment.

## Diagramme UML du projet

Lien vers le diagramme de classe (fait sur GenMyModel) : https://app.genmymodel.com/api/projects/_OP5lkP8PEeq_35Z1GKTxtw/diagrams/_OP6Mov8PEeq_35Z1GKTxtw/svg
