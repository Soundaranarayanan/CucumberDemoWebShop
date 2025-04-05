package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocator {
    @FindBy(id = "Email")
    public WebElement userName;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(xpath = "//input[@value='Log in']")
    public WebElement login;
}