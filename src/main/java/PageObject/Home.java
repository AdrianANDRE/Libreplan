package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Extends ToolBox pour faire usage du super constructeur
public class Home extends ToolBox{

    //WebElement avec les xpath de références
    @FindBy(xpath = "//a[@class=\"cerrar_sesion\"]")
    WebElement buttonLogout;
    @FindBy(xpath = "//a[@href=\"/libreplan/calendars/calendars.zul\"]")
    WebElement buttonCalendrier;
    @FindBy(xpath = "//button[.=\"Ressources \"]")
    WebElement menuRessouces;

    //Super contructeur pour faire usage du driver
    public Home(WebDriver driver) {
        super(driver);
    }
//    public Calendrier moveToCalendrier (WebDriverWait wait) {
//        Actions action = new Actions(driver);
//        WebElement ressources = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"scheduler_default_event_inner\" and contains(text(),\"test\")]")));
//        action.moveToElement(ressources).build().perform();
//        buttonCalendrier.click();
//        return PageFactory.initElements(driver,Calendrier.class);



    //Methode pour LogOut
    public Login logout(){
        buttonLogout.click();
        return PageFactory.initElements(driver, Login.class);

    }
}
