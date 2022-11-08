package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class Participants extends ToolBox {
    //constructor
    public Participants(WebDriver driver) {super(driver); }

    //webElements
    //Page "Liste des participants"
    @FindBy(xpath ="//*[@class=\"z-window-embedded-header\"][contains(text(),\"Liste des participants\")]")
    WebElement titreListeParticipants;
    @FindBy(xpath = "//table[@class='filtering-area z-hbox']//*[contains(text(),\"Plus d'options\")]")
    WebElement buttonPlusOptions;
    @FindBy(xpath = "//table[@class='filtering-area z-hbox']//*[@class='z-button-cm'][contains(text(),'Filtre')]")
    WebElement buttonFiltre;
    @FindBy(xpath = "//*[contains(text(),'Créer')]")
    public WebElement buttonCreer;
    @FindBy(xpath = "//table[@class='filtering-area z-hbox']//input[@class='z-bandbox-inp']")
    WebElement fieldFiltrePar;
    @FindBy(xpath = "//table[@class='filtering-area z-hbox']//input[@class='z-textbox']")
    WebElement fieldDetailsPerso;
    @FindBy(xpath = "//table[@class='filtering-area z-hbox']//*[@class='z-bandbox-btn']")
    WebElement iconLoupe;
    //Page "Créer un participant"
    @FindBy(xpath = "//div[@class='z-tabs-header']//span[@class='z-tab-text'][contains(text(),'Données personnelles')]")
    WebElement blockDonneesPersonnelles;
    @FindBy(xpath = "//fieldset[@class='z-fieldset']//span[contains(text(),'Données de base')]")
    WebElement blockDonneesDeBase;
    @FindBy(xpath = "//fieldset[@class='z-fieldset']//span[contains(text(),'Utilisateur lié')]")
    WebElement blockUtilisateurLie;
    @FindBy(xpath = "//div[@class='z-window-embedded']//span[@class='saveandcontinue-button global-action z-button']//*[contains(text(),'Sauver et continuer')]")
    WebElement buttonSauvegarder;
    @FindBy(xpath = "//div[@class='z-window-embedded']/*/span[@class='save-button global-action z-button']//*[contains(text(),'Enregistrer')]")
    WebElement buttonEnregistrer;
    @FindBy(xpath = "//div[@class='z-window-embedded']/*/span[@class='cancel-button global-action z-button']//*[contains(text(),'Annuler')]")
    WebElement buttonAnnuler;
    @FindBy(xpath = "//div[@class='z-fieldset-cnt']//label[@class='z-radio-cnt'][contains(text(),'Non lié')]")
    WebElement nameRadiobuttonNonLie;
    @FindBy(xpath = "//div[@class='z-fieldset-cnt']//label[@class='z-radio-cnt'][contains(text(),'Utilisateur existant')]")
    WebElement nameRadiobuttonUtilisateurExistant;
    @FindBy(xpath = "//div[@class='z-fieldset-cnt']//label[@class='z-radio-cnt'][contains(text(),'Créer un nouvel utilisateur')]")
    WebElement nameRadiobuttonCreerUtilisateur;
    @FindBy(xpath = "//div[@class='z-fieldset-cnt']//label[@class='z-radio-cnt'][contains(text(),'Non lié')]/preceding-sibling::input")
    WebElement radiobuttonNonLie;
    @FindBy(xpath = "//div[@class='z-fieldset-cnt']//label[@class='z-radio-cnt'][contains(text(),'Utilisateur existant')]/preceding-sibling::input")
    WebElement radiobuttonUtilisateurExistant;
    @FindBy(xpath = "//div[@class='z-fieldset-cnt']//label[@class='z-radio-cnt'][contains(text(),'Créer un nouvel utilisateur')]/preceding-sibling::input")
    WebElement radiobuttonCreerUtilisateur;


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
    //Vérifier la conformité de la page "Créer un participant"
    public void verificationCreerPartitipant () {
        //Vérifier qu'on a les différents blocs et boutons
        assertTrue(blockDonneesPersonnelles.isDisplayed());
        assertTrue(blockDonneesDeBase.isDisplayed());
        assertTrue(blockUtilisateurLie.isDisplayed());
        assertTrue(buttonSauvegarder.isDisplayed());
        assertTrue(buttonEnregistrer.isDisplayed());
        assertTrue(buttonAnnuler.isDisplayed());
        //Vérifier dans les blocs qu'on a les champs requis
        //bloc données de base
        /*
        Code : champ de saisie renseigné avec une valeur par défaut non modifiable et grisé. La case "Générer le code" associée à ce champ est cochée par défaut
        Prénom : champ de saisie non renseigné
        Nom : champ de saisie non renseigné
        ID : champ de saisie non renseigné
        Type : liste déroulante affichant la valeur "Ressource normale" par défaut
         */
        //bloc utilisateur lié
        /*
        Non lié : coché par défaut
        Utilisateur existant
        Créer un nouvel utilisateur
         */
        assertTrue(nameRadiobuttonNonLie.isDisplayed());
        assertTrue(radiobuttonNonLie.isDisplayed());
        assertTrue(radiobuttonNonLie.isSelected());

        assertTrue(nameRadiobuttonUtilisateurExistant.isDisplayed());
        assertTrue(radiobuttonUtilisateurExistant.isDisplayed());
        assertFalse(radiobuttonUtilisateurExistant.isSelected());

        assertTrue(nameRadiobuttonCreerUtilisateur.isDisplayed());
        assertTrue(radiobuttonCreerUtilisateur.isDisplayed());
        assertFalse(radiobuttonCreerUtilisateur.isSelected());
    }

}
