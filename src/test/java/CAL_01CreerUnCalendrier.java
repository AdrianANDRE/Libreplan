import PageObject.Calendrier;
import PageObject.Home;
import PageObject.Login;
import PageObject.ToolBox;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CAL_01CreerUnCalendrier extends ToolBox {
    public CAL_01CreerUnCalendrier() {
        super(driver);
    }

    @Before
    public void initialization () {
        ToolBox.startup();
    }
    @Test
    public void connect () throws InterruptedException {
        //Permet d'instancier la classe Login
        Login log = PageFactory.initElements(driver, Login.class);
        //Permet de se login et de donner une variable pour intéragir avec les méthodes de la CLasse Home
        Home home = log.login();
        //Permet d'aller sur la page Ressources/Calendrier avec la mise en place d'une variable pour intéragir avec les méthodes de la classe Calendrier
        Calendrier calendar = home.moveToCalendrier();
        calendar.assertionTableau();
        calendar.creatCalendrierTest1();
        calendar.creatDerive();
        calendar.creatCopy();
        calendar.supprCalendar();
        driver.quit();

    }
}
