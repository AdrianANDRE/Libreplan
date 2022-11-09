package PageObject;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ToolBox {
    //Variable pour utiliser dans vos methodes
    public static WebDriver driver;
    public static Actions action;
    public static WebDriverWait wait;

    //Super constructeur pour avoir la variable dans toutes les classes et éviter de définir le driver à chaque instance
    public ToolBox(WebDriver driver) {
        this.driver = driver;
    }

    public static void startup() {
        //Chemin pour le driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Driver/chromedriver.exe");
        //Instanciation du driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/libreplan");
        // instanciation des wait action
        wait = new WebDriverWait(driver, 10);
        action = new Actions(driver);

    }

    //Prender un screen de l'écran lors d'une erreur
    public static void takeSnapShot(String fileWithPath) throws Exception {
//Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
//Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
//Move image file to new destination
        File DestFile = new File(fileWithPath);
//Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
