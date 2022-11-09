package PageObject;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.logging.log4j.Logger;
import static org.junit.Assert.*;

public class Calendrier extends ToolBox {
    //Permet de faire usage des fonctions logger
    private static final Logger log =  LogManager.getLogger(Calendrier.class);
    //Liste des WebElement avec lequel nous allons intéragir
    @FindBy(xpath = "//div[@class=\"z-dottree\"]/following-sibling::span")
    WebElement buttonCreer;
    @FindBy(xpath = "//div/input[contains(@class, 'z-textbox')]")
    WebElement fieldNom;
    @FindBy(xpath = "//td[.=\"Enregistrer\"][@class=\"z-button-cm\"]")
    WebElement buttonEnregistrer;
    @FindBy(xpath = "//td[.=\"Enregistrer et continuer\"][@class=\"z-button-cm\"]")
    WebElement buttonEnregistrerContinuer;
    @FindBy(xpath = "(//td[.=\"Annuler\"][@class=\"z-button-cm\"])[1]")
    WebElement buttonAnnuler;
    @FindBy(xpath = "//span[.=\"Période\"]")
    WebElement verifPeriode;
    @FindBy(xpath = "//span[.=\"Réservation\"]")
    WebElement verifReservation;
    @FindBy(xpath = "//span[.=\"Type d'exception\"]")
    WebElement verifException;
    @FindBy(xpath = "(//div[@class=\"z-row-cnt z-overflow-hidden\"]//input[@type=\"checkbox\"])[1]")
    WebElement checkBoxCode;
    @FindBy(xpath = "//div[@class=\"message_INFO\"]//span[contains(.,\"enregistré\")]")
    WebElement messageInfoCreation;
    @FindBy(xpath = "//span[.=\"Calendrier - Test 1\"]")
    WebElement calendrierTest1;
    @FindBy(xpath = "//span[.=\"Calendrier - Test 1\"]//ancestor::tr//img[@src=\"/libreplan/common/img/ico_derived1.png\"]")
    WebElement buttonDeriveTest1;
    @FindBy(xpath = "//div[@class=\"calendar-tabbox z-tabbox\"]//span[contains(.,\"Calendrier\")]")
    WebElement fieldType;
    @FindBy(xpath = "//span[.=\"Calendrier - Test 1 existe déjà\"]")
    WebElement messageWARNING;
    //Nous effectuons des contrôles via les xpath comme l'exemple ci dessous , en partant du Calendrier - Test 1 je suis sûr que le bouton avec le quel je vais intéragir c'est le bon qui est lié à ce que je désir
    @FindBy(xpath = "//div[.=\"Calendrier - Test 1\"]/ancestor::tr/following-sibling::tr//span[contains(.,\"Test Calendrier Dérivé\")]")
    WebElement deriveTableUnderTest01;
    @FindBy(xpath = "//span[@class=\"z-dottree-ico z-dottree-root-open\"]")
    WebElement dottreeOpen;
    @FindBy(xpath = "//span[.=\"Calendrier - Test 1\"]//ancestor::tr//img[@src=\"/libreplan/common/img/ico_copy1.png\"]")
    WebElement buttonCopyTest1;
    @FindBy(xpath = "//span[@class=\"z-dottree-ico z-dottree-firstspacer\"]/following-sibling::span[.=\"Calendrier - Test 2\"]")
    WebElement inTableButNotUnderTest01;
    @FindBy(xpath = "//span[.=\"Calendrier - Test 2\"]/ancestor::tr//span[@title=\"Supprimer\"]")
    WebElement buttonSupprTest2;
    @FindBy(xpath = "//span[contains(.,\"Dérivé\")]/ancestor::tr//span[@title=\"Supprimer\"]")
    WebElement buttonSupprDerive;
    @FindBy(xpath = "//span[.=\"Calendrier - Test 1\"]/ancestor::tr//span[@title=\"Supprimer\"]")
    WebElement buttonSupprTest1;
    @FindBy(xpath = "//td[.=\"OK\"][@class=\"z-button-cm\"]")
    WebElement buttonOK;


    //Super contructeur
    public Calendrier(WebDriver driver) {
        super(driver);
    }

    public void assertionTableau() {
        String[] verifTableau = {"Nom", "Hérité de la date", "Héritages à jour", "Opérations"};
        for (String name : verifTableau) {
            assertEquals(name, driver.findElement(By.xpath("//th//div[.=\"" + name + "\"]")).getText());


        }
    }

    public void creatCalendrierTest1() throws Exception {
       try {wait.until(ExpectedConditions.elementToBeClickable(buttonCreer)).click();
        //Assertion des vérifications de la page
        assertTrue((wait.until(ExpectedConditions.visibilityOf(verifPeriode))).isDisplayed());
        assertTrue((wait.until(ExpectedConditions.visibilityOf(buttonAnnuler))).isDisplayed());
        assertTrue((wait.until(ExpectedConditions.visibilityOf(verifReservation))).isDisplayed());
        assertTrue((wait.until(ExpectedConditions.visibilityOf(verifException))).isDisplayed());
        //rentre le nom du calendrier
        wait.until(ExpectedConditions.visibilityOf(fieldNom));
        fieldNom.clear();
        fieldNom.sendKeys("Calendrier - Test 1");
        log.info("On rentre le nom Calendrier - Test 1");
        //Vérifie que la checkbox Générer le code est bien selectionné
        wait.until(ExpectedConditions.visibilityOf(checkBoxCode)).isSelected();
        log.info("La checkbo est bien sélectionné");
        wait.until(ExpectedConditions.visibilityOf(buttonEnregistrer)).click();
        assertTrue((wait.until(ExpectedConditions.visibilityOf(messageInfoCreation))).isDisplayed());
        assertTrue((wait.until(ExpectedConditions.visibilityOf(calendrierTest1))).isDisplayed());
        log.info("Le Calendrier - Test 1 est bien présent dans le tableau des calendriers");}
       catch (Exception e){
           takeSnapShot("target/snapshot/libreplan.png");
       }
    }

    public void creatDeriveCalendar() throws Exception {
        try{wait.until(ExpectedConditions.visibilityOf(buttonDeriveTest1)).click();
        assertEquals("", wait.until(ExpectedConditions.visibilityOf(fieldNom)).getAttribute("value"));
        log.info("Le champ nom est bien vide ");
        assertTrue((wait.until(ExpectedConditions.visibilityOf(fieldType))).isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(fieldNom));
        fieldNom.clear();
        fieldNom.sendKeys("Calendrier - Test 1");
        wait.until(ExpectedConditions.visibilityOf(checkBoxCode)).isSelected();
        wait.until(ExpectedConditions.visibilityOf(buttonEnregistrerContinuer)).click();
        wait.until(ExpectedConditions.visibilityOf(messageWARNING)).isDisplayed();
        log.info("Il y a bien la présence d'un message d'erreur comme quoi le nom du calendrier est déjà utilisé");
        wait.until(ExpectedConditions.visibilityOf(fieldNom));
        fieldNom.clear();
        fieldNom.sendKeys("Calendrier - Test Calendrier Dérivé");
        wait.until(ExpectedConditions.visibilityOf(buttonEnregistrerContinuer)).click();
        wait.until(ExpectedConditions.visibilityOf(messageInfoCreation)).isDisplayed();
        log.info("Il y a bien la confirmation de la création du calendrier via un message");
        wait.until(ExpectedConditions.visibilityOf(buttonAnnuler)).click();
        wait.until(ExpectedConditions.visibilityOf(deriveTableUnderTest01)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOf(dottreeOpen)).click();
        assertFalse(deriveTableUnderTest01.isDisplayed());
        log.info("Le calendrier dérivé est bien un élément sous le Calendrier Test 1");}
        catch (Exception e){
            takeSnapShot("target/snapshot/libreplan.png");
        }
    }

    public void creatCopyCalendar() throws Exception {
        try{wait.until(ExpectedConditions.visibilityOf(buttonCopyTest1)).click();
        wait.until(ExpectedConditions.visibilityOf(fieldNom));
        assertEquals("Calendrier - Test 1", fieldNom.getAttribute("value"));
        assertEquals("Calendrier source", fieldType.getText());
        wait.until(ExpectedConditions.visibilityOf(buttonEnregistrerContinuer)).click();
        wait.until(ExpectedConditions.visibilityOf(messageWARNING)).isDisplayed();
        log.info("Le calendrier est déjà présent et un message d'erreur confirme l'écart d'utilisation");
        wait.until(ExpectedConditions.visibilityOf(fieldNom));
        fieldNom.clear();
        fieldNom.sendKeys("Calendrier - Test 2");
        wait.until(ExpectedConditions.visibilityOf(checkBoxCode)).isSelected();
        wait.until(ExpectedConditions.visibilityOf(buttonEnregistrer)).click();
        wait.until(ExpectedConditions.visibilityOf(messageInfoCreation)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOf(inTableButNotUnderTest01)).isDisplayed();
        log.info("Le calendrier est bien présent dans le tableau général");}
        catch (Exception e){
            takeSnapShot("target/snapshot/libreplan.png");
        }


    }

    public void supprCalendar() throws Exception {
        try{
        wait.until(ExpectedConditions.elementToBeClickable(buttonSupprTest2));
        buttonSupprTest2.click();
        buttonOK.click();
        wait.until(ExpectedConditions.elementToBeClickable(buttonSupprDerive));
        buttonSupprDerive.click();
        buttonOK.click();
        wait.until(ExpectedConditions.elementToBeClickable(buttonSupprTest1));
        buttonSupprTest1.click();
        buttonOK.click();
        synchronized (wait){
        wait.wait(2000);
        }}
        catch (Exception e){
        takeSnapShot("target/snapshot/libreplan.png");
        }
    }
}
