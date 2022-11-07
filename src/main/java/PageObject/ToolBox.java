package PageObject;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ToolBox {
    //Variable pour utiliser dans vos methodes
    public  WebDriver driver;
    public  Actions action;
    public  WebDriverWait wait;

    //Super constructeur pour avoir la variable dans toutes les classes et éviter de définir le driver à chaque instance
    public ToolBox(WebDriver driver) {
        this.driver = driver;
    }
}
