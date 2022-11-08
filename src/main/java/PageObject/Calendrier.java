package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Calendrier extends ToolBox {
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

    @FindBy(xpath = "//span[.=\"Dérivé du calendrier Calendrier - Test 1\"]")
    WebElement fieldType;

    @FindBy(xpath = "//span[.=\"Calendrier - Test 1 existe déjà\"]")
    WebElement messageWARNING;


    //Super contructeur
    public Calendrier(WebDriver driver) {
        super(driver);
    }
    //TODO faire map <int,String>
    // map<int, string> map = new hashmap<>()
    //map.put(1, "nom")
    //Vérifie les nom de la première ligne du tableau une fois sur l'écran calendrier
    public void assertionTableau(){
        String[] verifTableau = {"Nom", "Hérité de la date", "Héritages à jour", "Opérations"};
        for (String name:verifTableau){
            assertEquals(name,driver.findElement(By.xpath("//th//div[.="+name+"]")).getText());
        }

    }
    public void creatCalendrierTest1(){
        buttonCreer.click();
        //Assertion des vérifications de la page
        assertTrue(verifPeriode.isDisplayed());
        assertTrue(buttonAnnuler.isDisplayed());
        assertTrue(verifReservation.isDisplayed());
        assertTrue(verifReservation.isDisplayed());
        assertTrue(verifException.isDisplayed());
        //rentre le nom du calendrier
        fieldNom.clear();
        fieldNom.sendKeys("Calendrier - Test 1");
        //Vérifie que la checkbox Générer le code est bien selectionné
        checkBoxCode.isSelected();
        buttonEnregistrer.click();
        messageInfoCreation.isDisplayed();
        calendrierTest1.isDisplayed();

    }
    public void creatDerive(){
        buttonDeriveTest1.click();
        assertEquals("",fieldNom.getAttribute("value"));
        fieldType.isDisplayed();
        fieldNom.sendKeys("Calendrier - Test 1");
        checkBoxCode.isSelected();
        buttonEnregistrerContinuer.click();
        messageWARNING.isDisplayed();
        fieldNom.sendKeys("Calendrier - Test Calendrier Dérivé");
        buttonEnregistrerContinuer.click();



    }
    public void creatDeriveOK(){
        buttonDeriveTest1.click();
        assertEquals("",fieldNom.getAttribute("value"));
        fieldType.isDisplayed();
        fieldNom.sendKeys("Calendrier - Test 1");
        checkBoxCode.isSelected();
        buttonEnregistrerContinuer.click();
        messageWARNING.isDisplayed();
        fieldNom.sendKeys("Calendrier - Test 1");



    }
}
