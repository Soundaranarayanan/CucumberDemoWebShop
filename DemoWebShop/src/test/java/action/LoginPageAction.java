package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import pages.LoginPageLocator;
import utilities.HelperClass;



public class LoginPageAction {
    private LoginPageLocator loginPageLocators;
    private String strUserName, strPassword;

    public LoginPageAction() {
        this.loginPageLocators = new LoginPageLocator();
        PageFactory.initElements(HelperClass.getDriver(), loginPageLocators);
    }

    public void setUserName(String strUserName) {
        loginPageLocators.userName.sendKeys(strUserName);
    }

    public void setPassword(String strPassword) {
        loginPageLocators.password.sendKeys(strPassword);
    }

    public void clickLogin() {
        loginPageLocators.login.click();
    }
    
    

    public void login() {
        try (FileInputStream fileInput = new FileInputStream("C:\\Users\\admi\\git\\repository51\\DemoWebShop\\src\\test\\resources\\testdata.properties")) {
            Properties prop = new Properties();
            prop.load(fileInput);
            strUserName = prop.getProperty("username");
            strPassword = prop.getProperty("password");

            this.setUserName(strUserName);
            this.setPassword(strPassword);
            this.clickLogin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}