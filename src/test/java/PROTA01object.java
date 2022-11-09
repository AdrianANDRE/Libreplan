
import PageObject.Login;
import PageObject.CreationProjet;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;



import static org.junit.Assert.assertTrue;


public class PROTA01object {WebDriver driver;
    Wait wait;
    Actions action;
    @Test
    public void testPROTA01 () throws InterruptedException {
        //locate Driver
//        System.setProperty("webdriver.chrome.driver","src/main/java/resources/Driver/chromedriver.exe");
//        driver = new ChromeDriver();
        //
        System.setProperty("webdriver.gecko.driver","src/main/resources/Driver/geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver,15);
        action = new Actions(driver);
        driver.get("http://localhost:8080/libreplan/common/layout/login.zul");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Login log = PageFactory.initElements(driver, Login.class);
        log.login();
        Thread.sleep(5000);

        CreationProjet creation =PageFactory.initElements(driver,CreationProjet.class );
        creation.creerUnprojet("projet1","001","15/11/2022","22/11/2022");
        creation.testAnnulerEdition1();
        creation.testAnnulerEdition2();
        creation.afficherProjets(driver);






    }







}
