package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;


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
    public
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

    @FindBy(xpath = "//div[@class='z-fieldset-cnt']//label[@class='z-checkbox-cnt'][contains(text(),'Générer le code')]/preceding-sibling::input")
    WebElement checkboxGenererCode;
    @FindBy(xpath = "//div[@class='z-fieldset-cnt']//input[@class='z-textbox z-textbox-disd z-textbox-text-disd'][@disabled]" )
    WebElement fieldCodeDesactive;
    @FindBy(xpath = "//div[@class='z-fieldset-cnt']//span[@class='z-label'][contains(text(),'Prénom')]" )
    WebElement casePrenom;
    @FindBy(xpath = "//div[@class='z-fieldset-cnt']//span[@class='z-label'][contains(text(),'Code')]" )
    WebElement caseCode;
    @FindBy(xpath = "//div[@class='z-fieldset-cnt']//span[@class='z-label'][contains(text(),'Prénom')]/ancestor::tr/following-sibling::tr[2]//span[contains(text(),'Nom')]" )
    WebElement caseNom;
    @FindBy(xpath = "//div[@class='z-fieldset-cnt']//span[@class='z-label'][contains(text(),'ID')]" )
    WebElement caseID;
    @FindBy(xpath = "//div[@class='z-fieldset-cnt']//span[@class='z-label'][contains(text(),'Type')]")
    WebElement caseType;
    @FindBy(xpath = "//div[@class='z-fieldset-cnt']//span[@class='z-label'][contains(text(),'Prénom')]/ancestor::td/following-sibling::td/descendant::input")
    WebElement fieldPrenom;
    @FindBy(xpath = "//div[@class='z-fieldset-cnt']//span[@class='z-label'][contains(text(),'Prénom')]/ancestor::tr/following-sibling::tr[2]//span[contains(text(),'Nom')]/ancestor::td/following-sibling::td/descendant::input")
    WebElement fieldNom;
    @FindBy(xpath = "//div[@class='z-fieldset-cnt']//span[@class='z-label'][contains(text(),'ID')]/ancestor::td/following-sibling::td/descendant::input")
    WebElement fieldID;
    @FindBy(xpath = "//div[@class='z-fieldset-cnt']//span[@class='z-label'][contains(text(),'Type')]/ancestor::tr/descendant::select")
    WebElement dropdownType;
    @FindBy(xpath = "//div[@class='z-panel-header '][contains(text(),'Nouvel utilisateur')]")
    WebElement titrepanelUtilisateurLieNouveau;
    // sous menus pour l'utilisateur à lier existant : //div[@class='z-panel-header '][contains(text(),'Nouvel utilisateur')]/following-sibling::div[@class='z-panel-body']
    @FindBy(xpath = "//div[@class='z-panel-header '][contains(text(),'Nouvel utilisateur')]/following-sibling::div[@class='z-panel-body']/descendant::span[@class='z-label'][contains(text(),'Nom')]/ancestor::tr/descendant::input")
    WebElement fieldNomUtilLieNouveau;
    @FindBy(xpath = "//div[@class='z-panel-header '][contains(text(),'Nouvel utilisateur')]/following-sibling::div[@class='z-panel-body']/descendant::span[@class='z-label'][contains(text(),'Mot')]/ancestor::tr/descendant::input")
    WebElement fieldmdpUtilLieNouveau;
    @FindBy(xpath = "//div[@class='z-panel-header '][contains(text(),'Nouvel utilisateur')]/following-sibling::div[@class='z-panel-body']/descendant::span[@class='z-label'][contains(text(),'mot')]/ancestor::tr/descendant::input")
    WebElement fieldconfmdpUtilLieNouveau;
    @FindBy(xpath = "//div[@class='z-panel-header '][contains(text(),'Nouvel utilisateur')]/following-sibling::div[@class='z-panel-body']/descendant::span[@class='z-label'][contains(text(),'mail')]/ancestor::tr/descendant::input")
    WebElement fieldmailUtilLieNouveau;

    @FindBy(xpath = "//div[@class='z-panel-header '][contains(text(),'Utilisateur existant')]")
    WebElement titrepanelUtilisateurLieExistant;

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
        //Code : champ de saisie renseigné avec une valeur par défaut non modifiable
        assertTrue(caseCode.isDisplayed());
        assertTrue(fieldCodeDesactive.isDisplayed());
        //La case "Générer le code" associée à ce champ est cochée par défaut
        assertTrue(checkboxGenererCode.isDisplayed());
        assertTrue(checkboxGenererCode.isSelected());
        //Prénom : champ de saisie, non renseigné
        assertTrue(casePrenom.isDisplayed());
        assertTrue(fieldPrenom.getText().isEmpty());
        //Nom : champ de saisie, non renseigné
        assertTrue(caseNom.isDisplayed());
        assertTrue(fieldNom.getText().isEmpty());
        //ID : champ de saisie, non renseigné
        assertTrue(caseID.isDisplayed());
        assertTrue(fieldID.getText().isEmpty());
        //Type : liste déroulante affichant la valeur "Ressource normale" par défaut
        assertTrue(caseType.isDisplayed());
        Select select = new Select(dropdownType);
        String dropdownDefaultValue = select.getFirstSelectedOption().getText();
        assertEquals("Ressource normale",dropdownDefaultValue);

        //bloc utilisateur lié : vérifier que les radio buttons sont présents avec leur label
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
    public void inputDonneesDeBase (String prenom, String nom, String ID, String type) {
        //renseigner le bloc "données de base"
        fieldPrenom.sendKeys(prenom);
        fieldNom.sendKeys(nom);
        fieldID.sendKeys(ID);
        Select select = new Select(dropdownType);
        select.selectByVisibleText(type);
    }
    public void inputUtilisateurLie (String username, String password, String passwordConfirmation, String email) {
        radiobuttonCreerUtilisateur.click();
        fieldNomUtilLieNouveau.sendKeys(username);
        fieldmdpUtilLieNouveau.sendKeys(password);
        fieldconfmdpUtilLieNouveau.sendKeys(passwordConfirmation);
        fieldmailUtilLieNouveau.sendKeys(email);
    }
    public static void deleteUser(String id) {
        WebElement buttonDeleteUser = driver.findElement(By.xpath("//span[@class='z-label'][contains(text(),'"+id+"')]/ancestor::tr//descendant::img[@src='/libreplan/common/img/ico_borrar1.png']"));
        buttonDeleteUser.click();
        WebElement buttonOKpopUpSuppression = driver.findElement(By.xpath("//td[@class='z-button-cm'][contains(text(),'OK')]"));
        buttonOKpopUpSuppression.click();
    }
    public static void deleteUserLie () {
        WebElement buttonOKSuppressionUtilLie = driver.findElement(By.xpath("//td[@class='z-button-cm'][contains(text(),'Oui')]"));
        buttonOKSuppressionUtilLie.click();
    }

}
