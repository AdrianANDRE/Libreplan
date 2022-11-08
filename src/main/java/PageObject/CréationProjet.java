package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CréationProjet {



        public CréationProjet(WebDriver driver) {

            super();
        }
        @FindBy(xpath = "//*[@class=\"z-button-cm\"]" )
        public WebElement ajouter;

        @FindBy(xpath = "//div/input")
        public WebElement nomProjet;

        @FindBy(xpath = "//*[@checked=\"checked\"]")
        public WebElement décocher;

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

        @FindBy(xpath = "//td[2]/div/button")
        public WebElement menuCalendrier;

        @FindBy(xpath = "//td[2]/div/button")
        public WebElement menuProjet;

        @FindBy(xpath = "//tr[4]/td[2]/div/i/input")
        public WebElement debutProjet;

        @FindBy(xpath = "//tr[5]/td[2]/div/i/input")
        public WebElement finProjet;

        @FindBy(xpath = "//*[@title=\"Supprimer\"]")
        public WebElement supprimerProjet;








        public void créerUnprojet(WebDriver driver, String nomDuProjet, String numerosProjet, String dateDebutprojet, String dateFinProjet) {
                ajouter.click();
                nomProjet.sendKeys("nomDuProjet");
                décocher.click();
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







        public void changeNumArticle(WebDriver driver, String number) {
            codeProjet.clear();

            codeProjet.sendKeys("2");
        }




}
