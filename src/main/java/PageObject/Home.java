package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static junit.framework.Assert.assertTrue;

// Extends ToolBox pour faire usage du super constructeur
public class Home extends ToolBox {

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
    public Login logout() {
        buttonLogout.click();
        return PageFactory.initElements(driver, Login.class);

    }

    public void accessResourcesMenu() {
        wait.until(ExpectedConditions.visibilityOf(RessourcesMenu));
        action.moveToElement(RessourcesMenu).perform();
    }

    //Methodes qui font usages de la classe Enum Menu pour définir des xpaths => voir methode xpathSelectMenu
    public Participants moveToParticipants() {
        accessResourcesMenu();
        xpathSelectMenu(MenuRessources.Participants).click();
        return PageFactory.initElements(driver, Participants.class);
    }

    public Machines moveToMachines() {
        accessResourcesMenu();
        xpathSelectMenu(MenuRessources.Machines).click();
        return PageFactory.initElements(driver, Machines.class);
    }

    public Calendrier moveToCalendrier() {
        accessResourcesMenu();
        xpathSelectMenu(MenuRessources.Calendriers).click();
        return PageFactory.initElements(driver, Calendrier.class);
    }

    public Critere moveToCritère() {
        accessResourcesMenu();
        xpathSelectMenu(MenuRessources.Critère).click();
        return PageFactory.initElements(driver, Critere.class);
    }

    public Avancement moveToAvancement() {
        accessResourcesMenu();
        driver.findElement(By.xpath("(//div[@class=\"z-menu-item-cm\"]//a[contains(text(),\"avancement\")])[3]")).click();
        return PageFactory.initElements(driver, Avancement.class);
    }


    public WebElement xpathSelectMenu(MenuRessources menuRessources) {
        return driver.findElement(By.xpath("(//div[@class=\"z-menu-item-cm\"]//a[contains(text(),\"" + menuRessources + "\")])"));
    }
}
