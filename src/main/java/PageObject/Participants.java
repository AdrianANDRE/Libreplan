package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Participants extends ToolBox {
    //constructor
    public Participants(WebDriver driver) {super(driver); }
    //webElements
    @FindBy(xpath ="//*[@class=\"z-window-embedded-header\"][contains(text(),\"Liste des participants\")]")
    public WebElement titreListeParticipants;
    @FindBy(xpath = "//table[@class='filtering-area z-hbox']//*[contains(text(),\"Plus d'options\")]")
    public WebElement buttonPlusOptions;
    @FindBy(xpath = "//table[@class='filtering-area z-hbox']//*[@class='z-button-cm'][contains(text(),'Filtre')]")
    public WebElement buttonFiltre;
    @FindBy(xpath = "//*[contains(text(),'Créer')]")
    public WebElement buttonCreer;
    @FindBy(xpath = "//table[@class='filtering-area z-hbox']//input[@class='z-bandbox-inp']")
    public WebElement fieldFiltrePar;
    @FindBy(xpath = "//table[@class='filtering-area z-hbox']//input[@class='z-textbox']")
    public WebElement fieldDetailsPerso;
    @FindBy(xpath = "//table[@class='filtering-area z-hbox']//*[@class='z-bandbox-btn']")
    public WebElement iconLoupe;
    /*
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
