package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}
