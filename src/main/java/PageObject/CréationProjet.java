package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;


public class CréationProjet {



        public CréationProjet(WebDriver driver) {

            super();
        }
        @FindBy(xpath = "//*[@class=\"z-button-cm\"]" )
        public WebElement ajouter;

        @FindBy(xpath = "//div/input")
        public WebElement nomProjet;

        @FindBy(xpath = "//*[@checked=\"checked\"]")
        public WebElement decocher;

        @FindBy(xpath = "//td[1]/input")
        public WebElement codeProjet;

        @FindBy(xpath = "//tr[2]/td[contains(.,'Accepter')]")
        public WebElement accepter;



        @FindBy(xpath = "//*[@title=\"Annuler l'édition\"]")
        public WebElement annulerEdition;

        @FindBy(xpath = "//*[@class=\"z-messagebox-btn z-button\"]//td[contains(.,'Annuler')]")
        public WebElement annuler;

        @FindBy(xpath = "//tbody/tr[2]/td[contains(.,'OK')]")
        public WebElement ok;

        @FindBy(xpath = "//td[2]/div/button[contains(.,'Calendrier')]")
        public WebElement menuCalendrier;

        @FindBy(xpath = "//*[@href=\"/libreplan/planner/index.zul;orders_list\"]")
        public WebElement menuProjet;

        @FindBy(xpath = "//tr[4]/td[2]/div/i/input")
        public WebElement debutProjet;

        @FindBy(xpath = "//tr[5]/td[2]/div/i/input")
        public WebElement finProjet;

        @FindBy(xpath = "//*[@title=\"Supprimer\"]")
        public WebElement supprimerProjet;

        @FindBy(xpath = "//tr[6]/td[2]/div/span/i/input")
        public WebElement champClient;

        @FindBy(xpath = "//tr[2]/td[2]/div/span/i/input")
        public WebElement modele;















        public void créerUnprojet(WebDriver driver, String nomDuProjet, String numerosProjet, String dateDebutprojet, String dateFinProjet) {
                ajouter.click();
                assertTrue(decocher.isDisplayed());
                assertTrue(nomProjet.getText().isEmpty());
                assertTrue(debutProjet.isDisplayed());
                assertTrue(finProjet.getText().isEmpty());
                assertTrue(accepter.isDisplayed());
                assertTrue(annuler.isDisplayed());
                assertTrue(champClient.getText().isEmpty());






                nomProjet.sendKeys("nomDuProjet");
                decocher.click();
                codeProjet.clear();
                codeProjet.sendKeys("numerosProjet");
                debutProjet.clear();
                debutProjet.sendKeys("dateDebutprojet");
                finProjet.sendKeys("dateFinProjet");
                accepter.click();

        }

        public void supprimerLeProjet(WebDriver driver){
                supprimerProjet.click();
                ok.click();

        }

        public void testAnnulerEdition1(WebDriver driver){
                annulerEdition.click();
                annuler.click();


        }
        public void testAnnulerEdition2(WebDriver driver){
                annulerEdition.click();
                ok.click();
        }

        public void afficherProjets(WebDriver driver){

                Actions a = new Actions(driver);
                a.moveToElement(menuCalendrier).perform();
                menuProjet.click();
        }


}
