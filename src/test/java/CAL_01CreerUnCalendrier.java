import PageObject.Calendrier;
import PageObject.Home;
import PageObject.Login;
import PageObject.ToolBox;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class CAL_01CreerUnCalendrier extends ToolBox {

    //Permet de faire usage des méthodes de la ToolBox et d'effectuer un suivi du driver instancié dans la classe ToolBox
    public CAL_01CreerUnCalendrier() {
        super(driver);
    }

    //Methode présente dans ToolBox à appeler dans chaque test
    @Before
    public void initialization() {
        ToolBox.startup();
    }


    @Test
    public void connect() throws Exception {
        //Permet d'instancier la classe Login
        Login log = PageFactory.initElements(driver, Login.class);
        //Permet de se login et de donner une variable pour intéragir avec les méthodes de la CLasse Home
        Home home = log.login();
        //Permet d'aller sur la page Ressources/Calendrier avec la mise en place d'une variable pour intéragir avec les méthodes de la classe Calendrier
        Calendrier calendar = home.moveToCalendrier();
        //Contrôle les titres de colonnes du tableau calendrier
        calendar.assertionTableau();
        //Créer le Calendrier Test 01 et effectue des assertions sur divers éléments
        calendar.creatCalendrierTest1();
        //Créer un calendrier dérivé du calendrier Test 01 et vérifie les éléments demandés
        calendar.creatDeriveCalendar();
        //Effectue une copie d'un Calendrier que l'on appelera autrement
        calendar.creatCopyCalendar();
        //Permet de remettre à zero ce que l'on a créer et ainsi effectuer le test autant defois qu'on le désir sans conflit
        calendar.supprCalendar();


    }
    //S'effectue après chaque test
    @After
    public void after() {
        driver.quit();
    }

}
