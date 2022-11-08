package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;


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
    //Vérifier la conformité de la page "Liste des participants"
    public void verificationListePartitipants () {
        //Vérifier qu'on est bien sur la page des participants
        assertTrue(titreListeParticipants.isDisplayed());
        //Vérifier que les colonnes du tableau sont conformes à ce qu'on attend
        String[] verifTableau = {"Surnom", "Prénom", "ID", "Code", "En file", "Opérations"};
        for (String name:verifTableau) {
            WebElement titreColonne = driver.findElement(By.xpath("//th/div[@class=\"z-column-cnt\"][contains(text(),'"+name+"')]"));
            assertTrue(titreColonne.isDisplayed());
        }
        //Vérifier la présence des différents champs et boutons décrits dans le cas de test
        //- Un champ de recherche "Filtré par" (champ de saisie + icône représentant une loupe)
        assertTrue(fieldFiltrePar.isDisplayed());
        assertTrue(iconLoupe.isDisplayed());
        //- Un champ "Détails personnels"
        assertTrue(fieldDetailsPerso.isDisplayed());
        //- Un bouton bleu [Plus d'options]
        assertTrue(buttonPlusOptions.isDisplayed());
        //- un bouton vert [Filtre]
        assertTrue(buttonFiltre.isDisplayed());
        //- un bouton [Créer]
        assertTrue(buttonCreer.isDisplayed());

    }

}
