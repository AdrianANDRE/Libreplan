import PageObject.Calendrier;
import PageObject.Home;
import PageObject.Login;
import PageObject.ToolBox;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class TestingAdrian extends ToolBox {

    public TestingAdrian() {
        super(driver);
    }

    @Before
    public void initialization () {
        ToolBox.startup();
    }
    @Test
    public void connect () throws InterruptedException {
        //à effectuer à chaque methode de test pour faire usage de la classe login
        Login log = PageFactory.initElements(driver, Login.class);
        //"Classe de destination" Variable = log."methode"();
        Home home = log.login();
        Thread.sleep(2000);
        Calendrier calendrier = home.accessCalendriers();
        Thread.sleep(2000);
        driver.quit();





    }
}
