import PageObject.LoginLogout;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Testing {

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
        wait = new WebDriverWait(driver,10);
        action = new Actions(driver);
        driver.get("http://localhost:8080/libreplan/common/layout/login.zul");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        LoginLogout log = PageFactory.initElements(driver, LoginLogout.class);
        log.login();
        Thread.sleep(5000);
        log.logout();
        Thread.sleep(5000);

    }
}
