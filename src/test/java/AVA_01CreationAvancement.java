import PageObject.Home;
import PageObject.Login;
import PageObject.ToolBox;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
//à effectuer à chaque methode de test pour faire usage de la classe login
        Login log = PageFactory.initElements(driver, Login.class);
//"Classe de destination" Variable = log."methode"();
        Home home = log.login();
 //aller à la page Types d'avancements
        home.moveToAvancement();
        Thread.sleep(2000);




//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 02 --- Affichage de la page "Types d'avancement Liste"
        //xpath pour vérifier le titre de la page ::: *[contains(text(),"Types d'avancement Liste")]
        assertTrue(driver.findElement(By.xpath("//*[contains(text(),\"Types d'avancement Liste\")]")).isDisplayed());

        //Vérifier si la page affiche un tableau avec les colonnes :
        //Nom
        assertTrue(driver.findElement(By.xpath("//th//div[.=\"Nom\"]")).isDisplayed());
        //Activé
        assertTrue(driver.findElement(By.xpath("//th//div[.=\"Activé\"]")).isDisplayed());
        //Prédéfini
        assertTrue(driver.findElement(By.xpath("//th//div[.=\"Prédéfini\"]")).isDisplayed());
        //Opérations
        assertTrue(driver.findElement(By.xpath("//th//div[.=\"Opérations\"]")).isDisplayed());

        //Vérifier si la page affiche un bouton "créer"
        //*[@class="create-button global-action z-button"]
        assertTrue(driver.findElement(By.xpath("//*[@class=\"create-button global-action z-button\"]")).isDisplayed());

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 03 --- Créer un type d'avancement - Accès au formulaire de création : Cliquer sur le bouton [Créer].
        driver.findElement(By.xpath("//*[@class=\"create-button global-action z-button\"]")).click();
        Thread.sleep(2000);
        //Vérifier l'affichage de la page "Créer Type d'avancement"
        assertTrue(driver.findElement(By.xpath("//*[contains(text(),\"Créer Type d'avancement\")]")).isDisplayed());

        //Vérifier que la page contient un tableau intitulé "Modifier"
        assertTrue(driver.findElement(By.xpath("//span[.=\"Modifier\"]")).isDisplayed());

        //Vérifier la colonne "Nom d'unité"
        assertTrue(driver.findElement(By.xpath("//td//div//span[.=\"Nom d'unité\"]")).isDisplayed());
        //Vérifier que le champ de saisie est non renseigné
        assertTrue(driver.findElement(By.xpath("//div[@class=\"z-row-cnt z-overflow-hidden\"]/input[contains(@class,\"focus\")]")).isDisplayed());

        //Vérifier la colonne "Actif"
        assertTrue(driver.findElement(By.xpath("//td//div//span[.=\"Actif\"]")).isDisplayed());
        // NE MAAAAAAAAAAAAAAAAAAAAAARCHE PAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAS //////////////////////
        //Vérifier que la case à cocher est cochée par défaut
        //div[@class='z-row-cnt z-overflow-hidden']//span[@class="z-checkbox"][1]
        //input[@checked="checked"]
        //div[@class='z-row-cnt z-overflow-hidden']//span[@class="z-checkbox"][1]//input[@checked="checked"]
       // assertTrue(driver.findElement(By.xpath("//div[@class='z-row-cnt z-overflow-hidden']//span[@class=\"z-checkbox\"][1]//input[@checked=\"checked\"]")).isDisplayed());

        //Vérifier la colonne "Valeur maximum par défaut"
        assertTrue(driver.findElement(By.xpath("//td//div//span[.=\"Valeur maximum par défaut\"]")).isDisplayed());
        //Valeur maximum par défaut : champ de saisie avec pour valeur par défaut "100,00"
        WebElement valeurMaxWe = driver.findElement(By.xpath("(//input[@size=\"11\"])[1]"));
        System.out.println(valeurMaxWe.getAttribute("value"));
        assertEquals("100,00", valeurMaxWe.getAttribute("value"));

        //Vérifier la colonne "Précision"
        assertTrue(driver.findElement(By.xpath("//td//div//span[.=\"Précision\"]")).isDisplayed());
        //Précision : champ de saisie avec pour valeur par défaut "0,1000"
        WebElement precision = driver.findElement(By.xpath("//td//div//span[.=\"Précision\"]/following::input[1]"));
        System.out.println(precision.getAttribute("value"));
        assertEquals("0,1000", precision.getAttribute("value"));

        //Vérifier la colonne "Type"
        assertTrue(driver.findElement(By.xpath("//td//div//span[.=\"Type\"]")).isDisplayed());
        //Type : Valeur non modifiable "User"
        // NE MAAAAAAAAAAAAAAAAAAAAAARCHE PAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAS //////////////////////


        //Vérifier la colonne "Pourcentage"
        assertTrue(driver.findElement(By.xpath("//td//div//span[.=\"Pourcentage\"]")).isDisplayed());
        //Pourcentage : case à cocher décochée par défaut
        // NE MAAAAAAAAAAAAAAAAAAAAAARCHE PAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAS //////////////////////


        //Vérifier l'affichage du bouton "Enregistrer"
        assertTrue(driver.findElement(By.xpath("//td[contains(text(),\"Enregistrer\")]")).isDisplayed());

        //Vérifier l'affichage du bouton "Sauver et continuer"
        assertTrue(driver.findElement(By.xpath("//td[contains(text(),\"Sauver et continuer\")]")).isDisplayed());

        //Vérifier l'affichage du bouton "Annuler"
        assertTrue(driver.findElement(By.xpath("//td[contains(text(),\"Annuler\")]")).isDisplayed());

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//04 --- Créer un type d'avancement - sans pourcentage
//        1 - Renseigner les éléments du tableau "Modifier" avec les valeurs suivantes :
//        Nom d'unité : Type avancement - Test 1
//        Actif : décocher la case
//                Valeur maximum par défaut : saisir la valeur "10,00"
//        Précision : laisser la valeur par défaut
//        Type : Valeur non modifiable "User"
//        Pourcentage : ne pas cocher la case
//                2 - Cliquer sur le bouton [Enregistrer].



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //home.logout();
        driver.quit();
    }
}
