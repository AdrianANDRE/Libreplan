import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AbstractTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions action;

    @Before
    public void startup(){
        //Chemin pour le driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/Driver/chromedriver.exe");
        //Instanciation du driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/libreplan");
        // instanciation des wait action
        wait = new WebDriverWait(driver,10);
        action = new Actions(driver);

    }

}
