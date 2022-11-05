package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class LoginLogout extends ToolBox {
    //Xpath field username
    WebElement userField = driver.findElement(By.xpath("//input[@id=\"textfield\"]"));
    //Xpath field password
    WebElement passwordField = driver.findElement(By.xpath("//input[@id=\"textfield2\"]"));
    //Xpath button "Se connecter"
    WebElement buttonConnect = driver.findElement(By.xpath("//input[@id=\"button\"]"));
    //Xpath button Logout
    WebElement buttonLogout = driver.findElement(By.xpath("//a[@class=\"cerrar_sesion\"]"));

    public LoginLogout(WebDriver driver, WebElement userField) {
        super(driver);
    }
    //Method to login
    public Home login (){
        userField.clear();
        userField.sendKeys("admin");
        passwordField.clear();
        passwordField.sendKeys("admin");
        buttonConnect.click();
        return PageFactory.initElements(driver,Home.class);
    }
    //Method to logout
    public LoginLogout logout(){
        buttonLogout.click();
        return PageFactory.initElements(driver,LoginLogout.class);
    }
}
