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

    @FindBy(xpath = "//button[@class=\"z-menu-btn\"][contains(text(),\"Ressources\")]")
    WebElement RessourcesMenu;

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
        wait.until(ExpectedConditions.visibilityOf(RessourcesMenu));
        action.moveToElement(RessourcesMenu).perform();
    }
    //à partir du mouseOver accessResourcesMenu, les coordonnées des différents menus sont les suivantes :
    // participants :   y=25
    // machines :       y=50
    // calendriers :     y=100
    public Participants accessParticipants() {
        accessResourcesMenu();
        action.moveToElement(RessourcesMenu, 50,25).perform();
        action.click().perform();
        return PageFactory.initElements(driver, Participants.class);
    }
    public Calendrier accessCalendriers() {
        accessResourcesMenu();
        action.moveToElement(RessourcesMenu, 50,100).perform();
        action.click().perform();
        return PageFactory.initElements(driver, Calendrier.class);
    }

}
