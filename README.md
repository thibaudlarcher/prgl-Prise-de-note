# Projet MASTER I:<br> Prise de note

1.Description du logiciel de prise de note <br><br>
Petite application permettant de gérer des notes et la prise de note. Nous pouvons créer des notes, les modifier, les rechercher par mots clés, les afficher selon des tris ou les supprimer.<br><br>
2.Créateur <br><br>
[LARCHER Thibaud](https://github.com/thibaudlarcher)<br>
[DUFOUR Arnaud](https://github.com/Whilmaud)<br>
[CARBONNIER Nicolas](https://github.com/CarbonnierNicolas)<br>
[SOTTAS Jean-Charles](https://github.com/dragonpatin)<br><br>
3.Installation<br><br>
Pour pouvoir exécuter le projet veuillez installer maven pour la compilation.
Il faudra également avoir installé le plugin Ascii Doctor sur Google Chrome. Si vous êtes sur mac, veuillez également installer le logiciel Visual Studio Code.
<br>
Cloner ou télécharger le projet. Ensuite exécuter la commande :<br>
```
mvn package
```
Cela crée un fichier .jar.
Pour lancer l'application, exécutez la commande :
```
java -jar prisedenote-1.0.jar
```
ou
```
java -jar prisedenote-1.0.jar commande
```
Pour la liste des commandes, veuillez vous référer au manuel d'utilisation.
<br>
<br>
4.Manuel d'utilisation <br><br>
    Référence fichier 'Manuel_Utilisation.pdf' dans l'archive.
    <br><br>
5.Exemple Scénario <br><br>
    L'utilisateur Change le dossier de sauvegarde. ("Sauvegarde sur le Bureau").<br>
    L'utilisateur créé une note appelé "UneNouvelleNote". On ferme l'editeur sans rien avoir écrit.<br>
    L'utilisateur réouvre la note pour écrire ("Un logiciel de prise de note").<br>
    L'utilisateur créé une nouvelle note sans nom.<br>
    L'utilisateur affiche les notes avec LS.<br>
    L'utilisateur affiche les notes dans View.<br>
    L'utilisateur supprime la nouvelle note créé.<br>
    L'utilisateur affiche les notes avec LS.<br>
    L'utilisateur fait une recherche avec le mot clé "note".<br><br>
6.Explication Conception <br><br>
    L'application respecte le modèle OCP. <br>
    Nous avons une interface commande, toutes les notes héritent de cette interface. Les classes vont alors modifier la méthode pour qu'elles puisent implémenter leurs spécificités.<br><br>
7.Partie Fonctionnelle <br><br>
    Le changement de dossier de sauvegarde.<br>
    La recherche de note.<br>
    La création/suppresion/modification de note.<br>
    L'affichage de note dans le terminal et avec un navigateur<br><br>
8.Partie non Fonctionnelle <br><br>
    Le Changement de logiciel pour l'ouverture des notes
