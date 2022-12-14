import PageObject.Home;
import PageObject.Login;
import PageObject.Participants;
import PageObject.ToolBox;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertTrue;

public class GRE01 extends ToolBox {

    public GRE01() {
        super(driver);
    }

    @Before
    public void initialization () {
        ToolBox.startup();
    }
    @Test
    public void test () throws InterruptedException {
        //Instanciation page de login
        Login log = PageFactory.initElements(driver, Login.class);
        //Accès page d'accueil après s'être login
        Home home = log.login();
        //Accès à la page "participants"
        Participants participantsPage = home.moveToParticipants();

        //Vérification de la conformité de la page quand elle est sur la liste des participants
        participantsPage.verificationListePartitipants();
        participantsPage.buttonCreer.click();
        Thread.sleep(1000);

        //Vérification de la conformité de la page quand elle est sur la création de participant
        participantsPage.verificationCreerPartitipant();
        Thread.sleep(1000);

        //Création d'un participant - cas passant
        participantsPage.inputDonneesDeBase("Jean", "DU", "jdu", "Ressource normale");
        participantsPage.inputUtilisateurLie("jdu", "$jdumdp1", "$jdumdp1", "jdu@test.fr");
        Thread.sleep(1000);
        participantsPage.buttonEnregistrer.click();
        Thread.sleep(1000);

    }
    @After
    public void closingUp () throws InterruptedException {
        //Suppression des user créés : aller sur la page des utilisateurs, où qu'on soit sur le site à la fin du test
        driver.get("http://localhost:8080/libreplan/resources/worker/worker.zul");
        Thread.sleep(1000);
        //Suppression des utilisateurs créés
        Participants.deleteUser("jdu");
        //Comme jdu est aussi un utilisateur lié une seconde popup apparaît, où il faut cliquer "Oui" cette fois. Cette méthode est à omettre pour ceux créés sans utilisateur lié
        Participants.deleteUserLie();
        Thread.sleep(1000);
        //Fermeture du driver
        driver.quit();
    }


}
