package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends ToolBox {
    @FindBy(xpath = "//input[@id=\"textfield\"]")
    WebElement userField;

    @FindBy(xpath = "//input[@id=\"textfield2\"]")
    WebElement passwordField;

    @FindBy(xpath = "//input[@id=\"button\"]")
    WebElement buttonConnect;

    @FindBy(xpath = "//a[@class=\"cerrar_sesion\"]")
    WebElement buttonLogout;

    public Login(WebDriver driver) {
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
    public Login logout(){
        buttonLogout.click();
        return PageFactory.initElements(driver, Login.class);

    }
}
