package PageObject;

import org.openqa.selenium.WebDriver;

public class Participants extends ToolBox {
    //constructor
    public Participants(WebDriver driver) {super(driver); }
    //webElements
    /*
    1) PAGE : Affichage de la page "Liste des participants".
La page contient :
- un tableau avec les colonnes suivantes :
    Surnom
    Prénom
    ID
    Code
    En file
    Opérations
- Un champ de recherche "Filtré par" (champ de saisie + icône représentant une loupe)
- Un champ "Détails personnels"
- Un bouton bleu [Plus d'options]
- un bouton vert [Filtre]
- un bouton [Créer]

    2) PAGE : Créer un participant"
    L'onglet "Données personnelles" contient les éléments suivants :
- un bloc "Données de base" avec les champs suivants :
    Code : champ de saisie renseigné avec une valeur par défaut non modifiable et grisé. La case "Générer le code" associée à ce champ est cochée par défaut
    Prénom : champ de saisie non renseigné
    Nom : champ de saisie non renseigné
    ID : champ de saisie non renseigné
    Type : liste déroulante affichant la valeur "Ressource normale" par défaut
- un bloc "Utilisateur lié" contenant les boutons radio suivants :
    Non lié : coché par défaut
    Utilisateur existant
    Créer un nouvel utilisateur
- les boutons [Enregistrer], [Sauver et continuer] et [Annuler]
     */
    //methods
}
