import PageObject.Home;
import PageObject.Login;
import PageObject.ToolBox;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CAL_01CreerUnCalendrier extends ToolBox {
    public CAL_01CreerUnCalendrier() {
        super(driver);
    }

    @Test
    public void testOK(){

        Login log = PageFactory.initElements(driver, Login.class);
        Home home = log.login();

    }
}
