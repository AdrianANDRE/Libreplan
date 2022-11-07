import PageObject.Home;
import PageObject.Login;
import PageObject.ToolBox;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class TestingAdrian extends ToolBox {

    public TestingAdrian() {
        super(driver);
    }

    @Test
    public void connect () {
//        //à effectuer à chaque methode de test pour faire usage de la classe login
        Login log = PageFactory.initElements(driver, Login.class);
//        //"Classe de destination" Variable = log."methode"();
        Home home = log.login();
//        home.logout();
//        home.moveToCalendrier();

        driver.quit();





    }
}
