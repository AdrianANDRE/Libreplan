package PageObject;
import org.openqa.selenium.WebDriver;

public class ToolBox {
    //Variable pour utiliser dans vos methodes
    public static WebDriver driver;

    //Super constructeur pour avoir la variable dans toutes les classes et éviter de définir le driver à chaque instance
    public ToolBox(WebDriver driver) {
        this.driver = driver;
    }
}
