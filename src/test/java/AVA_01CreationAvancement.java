import PageObject.Home;
import PageObject.Login;
import PageObject.ToolBox;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AVA_01CreationAvancement extends ToolBox {


    public AVA_01CreationAvancement() {
        super(driver);
    }

    @Before
    public void initialization() {
        ToolBox.startup();
    }

    @Test
    public void connect() throws InterruptedException {
//        //à effectuer à chaque methode de test pour faire usage de la classe login
        Login log = PageFactory.initElements(driver, Login.class);
//        //"Classe de destination" Variable = log."methode"();
        Home home = log.login();
        home.moveToAvancement();
        Thread.sleep(2000);
//        home.logout();
        driver.quit();
    }
}
