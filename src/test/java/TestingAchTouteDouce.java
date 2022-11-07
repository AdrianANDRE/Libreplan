import PageObject.Home;
import PageObject.Login;
import PageObject.Participants;
import PageObject.ToolBox;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static junit.framework.Assert.assertTrue;

public class TestingAchTouteDouce extends ToolBox {

    public TestingAchTouteDouce() {
        super(driver);
    }

    @Before
    public void initialization () {
        ToolBox.startup();
    }
    @Test
    public void connect () throws InterruptedException {
        //à effectuer à chaque methode de test pour faire usage de la classe login
        Login log = PageFactory.initElements(driver, Login.class);
        //"Classe de destination" Variable = log."methode"();
        Home home = log.login();
        home.accessResourcesMenu();
        Thread.sleep(2000);
        home.accessParticipants();
        Thread.sleep(2000);
//        Participants participantsPage = home.accessParticipants();
        //move to ressources
//        WebElement mouseOverRessources = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"z-menu-btn\"][contains(text(),\"Ressources\")]")));
//        action.moveToElement(mouseOverRessources).build().perform();
        //move to participants
//        WebElement mouseOverParticipants = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@href=\"/libreplan/resources/worker/worker.zul\"]")));
        // participants :   y=25
        // machines :       y=50
        // calendrier :     y=100
//        action.moveToElement(mouseOverRessources, 50,25).build().perform();
//        home.logout();
//        driver.quit();


    }
}
