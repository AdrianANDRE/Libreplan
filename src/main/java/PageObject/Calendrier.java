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
    @FindBy(xpath = "")
    WebElement buttonEnregistrer;
    @FindBy(xpath = "//span[.=\"Période\"]")
    WebElement verifPeriode;
    @FindBy(xpath = "//span[.=\"Réservation\"]")
    WebElement verifReservation;
    @FindBy(xpath = "//span[.=\"Type d'exception\"]")
    WebElement verifException;
//    @FindBy(xpath = "//span[.=\"Période\"]")
//    WebElement verifPeriode;

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
    public void creatCalendrier(){
        buttonCreer.click();
        assertTrue(verifPeriode.isDisplayed());
        assertTrue(verifReservation.isDisplayed());
        assertTrue(verifException.isDisplayed());
        fieldNom.clear();


    }
}
