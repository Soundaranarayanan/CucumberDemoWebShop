package action;

import org.openqa.selenium.support.PageFactory;

import pages.HomePageLocator;
import utilities.HelperClass;

public class HomePageAction {
    private HomePageLocator homePageLocators;

    public HomePageAction() {
        this.homePageLocators = new HomePageLocator();
        PageFactory.initElements(HelperClass.getDriver(), homePageLocators);
    }

    public String getHomePageText() {
        return homePageLocators.homePageUserName.getText();
    }
}