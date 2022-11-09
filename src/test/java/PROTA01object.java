
import PageObject.Home;
import PageObject.Login;
import PageObject.CreationProjet;
import PageObject.ToolBox;
import org.junit.After;
import org.junit.Before;
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


public class PROTA01object extends ToolBox {
    public PROTA01object() {
        super(driver);
        Wait wait;
        Actions action;
    }
    @Before
    public void initialization() {
        ToolBox.startup();
    }


    @Test
    public void testPROTA01 () throws InterruptedException {
        //Permet d'instancier la classe Login
        Login log = PageFactory.initElements(driver, Login.class);
        //Permet de se login et de donner une variable pour intéragir avec les méthodes de la CLasse Home
        Home home = log.login();

        CreationProjet creation =PageFactory.initElements(driver,CreationProjet.class );
        Thread.sleep(3000);
        creation.creerUnprojet("projet1","001","15/11/2022","22/11/2022");
        creation.testVerifButton1(driver);
        creation.testAnnulerEdition1();
        creation.testAnnulerEdition2();
        creation.afficherProjets(driver);
        creation.supprimerLeProjet();


    }

    @After
    public void after() {
        driver.quit();
    }

}
