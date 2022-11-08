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
        Thread.sleep(2000);
        //Accès à la page "participants"
        Participants participantsPage = home.moveToParticipants();
        Thread.sleep(2000);
        //Vérification de la conformité de la page quand elle est sur la liste des participants
        verificationListePartitipants(participantsPage);

    }
    @After
    public void closingUp () {
        driver.quit();
    }

    public void verificationListePartitipants (Participants participantsPage) {
        //Vérifier qu'on est bien sur la page des participants
        assertTrue(participantsPage.titreListeParticipants.isDisplayed());
        //Vérifier que les colonnes du tableau sont conformes à ce qu'on attend
        String[] verifTableau = {"Surnom", "Prénom", "ID", "Code", "En file", "Opérations"};
        for (String name:verifTableau) {
            WebElement titreColonne = driver.findElement(By.xpath("//th/div[@class=\"z-column-cnt\"][contains(text(),'"+name+"')]"));
            assertTrue(titreColonne.isDisplayed());
        }
        //Vérifier la présence des différents champs et boutons décrits dans le cas de test
        //- Un champ de recherche "Filtré par" (champ de saisie + icône représentant une loupe)
        assertTrue(participantsPage.fieldFiltrePar.isDisplayed());
        assertTrue(participantsPage.iconLoupe.isDisplayed());
        //- Un champ "Détails personnels"
        assertTrue(participantsPage.fieldDetailsPerso.isDisplayed());
        //- Un bouton bleu [Plus d'options]
        assertTrue(participantsPage.buttonPlusOptions.isDisplayed());
        //- un bouton vert [Filtre]
        assertTrue(participantsPage.buttonFiltre.isDisplayed());
        //- un bouton [Créer]
        assertTrue(participantsPage.buttonCreer.isDisplayed());

    }
}
