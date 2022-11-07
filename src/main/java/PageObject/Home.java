package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static junit.framework.Assert.assertTrue;

// Extends ToolBox pour faire usage du super constructeur
public class Home extends ToolBox{

    //WebElement avec les xpath de références
    @FindBy(xpath = "//a[@class=\"cerrar_sesion\"]")
    WebElement buttonLogout;

    //Super contructeur pour faire usage du driver
    public Home(WebDriver driver) {
        super(driver);
    }
    //Methode pour LogOut
    public Login logout(){
        buttonLogout.click();
        return PageFactory.initElements(driver, Login.class);

    }


    public void accessResourcesMenu () {
        WebElement mouseOverRessources = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"z-menu-btn\"][contains(text(),\"Ressources\")]")));
        action.moveToElement(mouseOverRessources).perform();
        mouseOverRessources.click();
    }
    public Participants accessParticipants() {
        WebElement mouseOverParticipants = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@href=\"/libreplan/resources/worker/worker.zul\"]")));
        action.moveToElement(mouseOverParticipants).build().perform();
        return PageFactory.initElements(driver, Participants.class);
    }
}
