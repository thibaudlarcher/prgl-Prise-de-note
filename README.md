# Projet MASTER I:<br> Prise de note

1.Description du logiciel de prise de note <br><br>
Petite application qui permet de gérer des notes. Nous pouvons créer des notes, les modifier, les rechercher par mots clé, les afficher selon des tris ou les supprimer.<br><br>
2.Créateur <br><br>
[LARCHER Thibaud](https://github.com/thibaudlarcher)<br>
[DUFOUR Arnaud](https://github.com/Whilmaud)<br>
[CARBONNIER Nicolas](https://github.com/CarbonnierNicolas)<br>
[SOTTAS Jean-Charles](https://github.com/dragonpatin)<br><br>
3.Installation<br><br>
Pour pouvoir exécuter le projet veuillez installer maven pour la compilation.
Cloner ou télécharger le projet. Ensuite exécuter la commande :<br>
```
mvn package
```
Cela crée un fichier .jar.
Pour lancer l'application exécuter la commande :
```
java -jar prisedenote-1.0.jar
```
ou
```
java -jar prisedenote-1.0.jar commande
```
<br>
4.Manuel d'utilisation <br><br>
    Référence fichier 'Manuel_Utilisation.pdf' dans l'archive.
    <br><br>
5.Exemple Scénario <br><br>
    L'utilisateur Change le dossier de sauvegarde. ("Sauvegarde sur le Bureau").<br>
    L'utilisateur créé une note appelé "UneNouvelleNote". On ferme l'editeur sans rien avoire écrit.<br>
    L'utilisateur réouvre la note pour écire ("Un logiciel de prise de note").<br>
    L'utilisateur créé une nouvelle note sans nom.<br>
    L'utilisateur affiche les notes avec LS.<br>
    L'utilisateur affiche les notes dans View.<br>
    L'utilisateur supprime la nouvelle note créé.<br>
    L'utilisateur affiche les notes avec LS.<br>
    L'utilisateur fait une recherche avec le mot clé "note".<br><br>
6.Explication Conception <br><br>
    L'application respecte le modéle OCP. <br>
    Nous avons une interface commande, toutes les note hérite de cette interface. Les classe vont alors modifier la méthode pour qu'elle puise implémenter leurs spécificité.<br><br>
7.Partie Fonctionnelle <br><br>
    Le changement de dossier de sauvegarde.<br>
    La recherche de note.<br>
    La création/suppresion/modification de note.<br>
    L'affichage de note dans le terminal et avec un navigateur<br><br>
8.Partie non Fonctionnelle <br><br>
    Le Changement de logiciel pour l'ouverture des notes
