import PageObject.Home;
import PageObject.Login;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class CAL_01CreerUnCalendrier extends AbstractTest{

    @Test
    public void testOK(){

        Login log = PageFactory.initElements(driver, Login.class);
        Home home = log.login();

    }
}
