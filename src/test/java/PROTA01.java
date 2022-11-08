import PageObject.Login;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class PROTA01 {

    WebDriver driver;
    Wait wait;
    Actions action;
    @Test
    public void connect () throws InterruptedException {
        //locate Driver
//        System.setProperty("webdriver.chrome.driver","src/main/java/resources/Driver/chromedriver.exe");
//        driver = new ChromeDriver();
        //
        System.setProperty("webdriver.gecko.driver","src/main/resources/Driver/geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver,15);
        action = new Actions(driver);
        driver.get("http://localhost:8080/libreplan/common/layout/login.zul");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Login log = PageFactory.initElements(driver, Login.class);
        log.login();
        Thread.sleep(5000);


        driver.findElement(By.xpath("//*[@class=\"z-button-cm\"]")).click();


        driver.findElement(By.xpath("//div/input")).sendKeys("PROJET_TEST1");
        driver.findElement(By.xpath("//*[@checked=\"checked\"]")).click(); ////td[3]/span/input
        driver.findElement(By.xpath("//tr[4]/td[2]/div/i/input")).clear();
        driver.findElement(By.xpath("//tr[4]/td[2]/div/i/input")).sendKeys("13/11/2022");
        driver.findElement(By.xpath("//tr[5]/td[2]/div/i/input")).sendKeys("23/11/2022");
        driver.findElement(By.xpath("//td[1]/input")).clear();
        driver.findElement(By.xpath("//td[1]/input")).sendKeys("PRJTEST001");



        //PROJET_TEST 1- Nom : PROJET_TEST1   class="z-textbox"
        //- Modèle : ne pas renseigner le champ
        //- Code : décocher la case "Générer le code" puis saisir la valeur suivante dans le champ de saisie qui devient éditable : "PRJTEST001"  //*[@class="z-checkbox"] et
        // - Date de début : Sélectionner dans le calendrier date J+5
        //- Echeance : Sélectionner dans le calendrier date J+15
        //- Client : ne pas renseigner le champ
        //- Calendrier : laisser la valeur par défaut "Default"

        driver.findElement(By.xpath("//tr[2]/td[contains(.,'Accepter')]")).click(); // /a[contains(@href, 'signonForm')
       // Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@title=\"Annuler l'édition\"]")).click();
       // Thread.sleep(3000);
        //driver.switchTo().frame(1)  ;

        driver.findElement(By.xpath("//*[@class=\"z-messagebox-btn z-button\"]//td[contains(.,'Annuler')]")).click();


        driver.findElement(By.xpath("//*[@title=\"Annuler l'édition\"]")).click();
       // Thread.sleep(3000);

        driver.findElement(By.xpath("//tbody/tr[2]/td[contains(.,'OK')]")).click();

        //td[2]/div/button

        WebElement menuCalendrier = driver.findElement(By.xpath("//td[2]/div/button[contains(.,'Calendrier')]"));
        action.moveToElement(menuCalendrier).perform();
         Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@href=\"/libreplan/planner/index.zul;orders_list\"]")).click();


        driver.findElement(By.xpath("//*[@title=\"Supprimer\"]")).click();
        driver.findElement(By.xpath("//tbody/tr[2]/td[contains(.,'OK')]")).click();


        Thread.sleep(5000);
        log.logout();
        Thread.sleep(2000);
        driver.quit();



    }
}