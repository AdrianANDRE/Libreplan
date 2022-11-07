import PageObject.Home;
import PageObject.Login;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class TestingAdrian extends AbstractTest {

    @Test
    public void connect () {
        //à effectuer à chaque methode de test pour faire usage de la classe login
        Login log = PageFactory.initElements(driver, Login.class);
        //"Classe de destination" Variable = log."methode"();
        Home home = log.login();
        home.logout();
        driver.quit();





    }
}
