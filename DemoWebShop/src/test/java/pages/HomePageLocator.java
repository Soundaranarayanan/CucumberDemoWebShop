package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocator {
    @FindBy(xpath = "//div[@class='header-links']//a[@class='account']")
    public WebElement homePageUserName;
}