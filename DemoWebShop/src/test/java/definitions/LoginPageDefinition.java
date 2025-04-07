package definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import action.HomePageAction;
import action.LoginPageAction;
import utilities.ExcelReader;
import utilities.HelperClass;

public class LoginPageDefinition {
    private WebDriver driver = HelperClass.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    private LoginPageAction objLogin = new LoginPageAction();
    private HomePageAction objHomePage = new HomePageAction();

    @Given("user is on the Login Page {string}")
    public void loginTest(String url) {
        HelperClass.openPage(url);
    }
@When("user enters username and password")
    public void goToHomePage() {
        objLogin.login();
    }
 @When("user enters username {string} and password {string}")
    public void goToHomePageWithCredentials(String username, String password) {
        objLogin.setUserName(username);
        objLogin.setPassword(password);
        objLogin.clickLogin();
    }
 @Then("User should be able to login successfully and new page open")
    public void verifyLogin() {
        WebElement welcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")));
        Assert.assertTrue(welcomeMessage.getText().contains("Log out"), "Login failed");
    }
 @Then("User should see an Error Message {string}")
    public void verifyErrorMessage(String errorMessage) {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[1]/div/span")));
        Assert.assertTrue(errorElement.getText().contains(errorMessage), "Error message not found.");
    } @When("the user provides an email")
    public void the_user_provides_an_email(DataTable dataTable) {
    	
        List<Map<String, String>> emailList = dataTable.asMaps();
          String email = emailList.get(0).get("Email");
        WebElement emailInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("newsletter-email")));
        emailInput.sendKeys(email);
    }
   @And("the user clicks the Subscribe button")
    public void the_user_clicks_the_subscribe_button() {
         WebElement subscribeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("newsletter-subscribe-button")));
        subscribeButton.click();
    }
   @Then("the user should  see the subscription confirmation text")
   public void the_user_should_see_the_subscription_confirmation_text() {
	   
	   By confirmationTextLocator = By.xpath("//*[@id=\"newsletter-result-block\"]");
	   wait.until(ExpectedConditions.textToBePresentInElementLocated(confirmationTextLocator, "Thank you"));
	   String actual = driver.findElement(confirmationTextLocator).getText();

	   
//      WebElement confirmationText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newsletter-result-block")));
//      String actual = confirmationText.getText();
      String expected="Thank you for signing up! A verification email has been sent. We appreciate your interest.";
//      System.out.println("ACTUAL TEXT: " + actual);
//      System.out.println("EXPECTED TEXT: " + expected);
//
      Assert.assertEquals(actual.trim(), expected.trim());

   }
   
   
   @And("the user provides an Invalid email")
   public void  InvalidEmail(DataTable dataTable) {
       List<Map<String, String>> data = dataTable.asMaps();
       String email = data.get(0).get("Email");
       String expectedError = data.get(0).get("ErrorMessage");

       WebElement emailInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("newsletter-email")));
       emailInput.clear();
       emailInput.sendKeys(email);

   }
   @Then("the user should see an error message")
   public void the_user_should_see_an_error_message() {

	   By confirmationTextLocator = By.id("newsletter-result-block");
	   wait.until(ExpectedConditions.textToBePresentInElementLocated(confirmationTextLocator, "Enter valid email"));
	   String actual = driver.findElement(confirmationTextLocator).getText();
	   String expected = "Enter valid email";
	   Assert.assertEquals(actual.trim(), expected.trim());

   }




   @When("the user clicks on the Computers category and selects Desktops")
   public void the_user_clicks_on_the_Computer_category_and_selects_Desktops() {

       WebElement computerLink = wait.until(ExpectedConditions.elementToBeClickable(
           By.xpath("/html/body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul/li[2]/a")));
       computerLink.click();

       WebElement desktopLink = wait.until(ExpectedConditions.elementToBeClickable(
           By.xpath("/html/body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul/li[2]/ul/li[1]/a")));
       desktopLink.click();
   }

 @When("the user clicks on the first desktop product")
 public void the_user_clicks_on_the_first_desktop_product() {
 driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[1]/a/img")).click();
 }
 @When("the user clicks the Add to cart button")
 public void the_user_clicks_the_Add_to_cart_button() {
    driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-72\"]")).click();
 }
 @When("the user navigates to the shopping cart")
 public void the_user_navigates_to_the_shopping_cart() {
   driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]")).click();
	 
 }
 @When("the user agrees to the terms of service")
 public void the_user_agrees_to_the_terms_of_service() {

	 driver.findElement(By.xpath("//*[@id=\"termsofservice\"]")).click();
 }


 @And("the user clicks the Checkout button")
 public void the_user_clicks_the_Checkout_button() {
	 driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
 }
 
 
 
 
 @And("the user should see the billing address page and enter details from Excel")
 public void the_user_should_see_the_billing_address_page_and_enter_details_from_excel() {
	 driver.findElement(By.xpath("//*[@id=\"billing-address-select\"]")).click();
	 driver.findElement(By.xpath("//*[@id=\"billing-address-select\"]/option[3]")).click();
	 
	 
	 
	 driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]")).click();
	 driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]/option[2]")).click();
	 
     String filePath = "./Excel/BillingDetails.xlsx";
     Map<String, String> billingData = ExcelReader.getBillingData(filePath, "BillingData");

     WebDriver driver = HelperClass.getDriver();
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

   WebElement city = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingNewAddress_City")));
     WebElement address1 = driver.findElement(By.id("BillingNewAddress_Address1"));
     WebElement zip = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
     WebElement phone = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
     WebElement continueBtn = driver.findElement(By.xpath("//input[@title='Continue']"));

     city.clear();
     city.sendKeys(billingData.get("City"));
     address1.clear();
     address1.sendKeys(billingData.get("Address1"));
     zip.clear();
     zip.sendKeys(billingData.get("Zip"));
     phone.clear();
     phone.sendKeys(billingData.get("Phone"));

     continueBtn.click();
 }

 @And("the user clicks the In Store Pickup checkbox and clicks the Continue button")
 public void clickInStorePickupAndContinue() {
driver.findElement(By.xpath("//*[@id=\"PickUpInStore\"]")).click();
driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/input")).click();
 }
 @And("the user chooses Cash on Delivery as the payment method and clicks the Continue button")
   public void chooseCashOnDeliveryAndContinue() {
    driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input")).click();
   }
@And("the user clicks the Continue button under Payment Information")
 public void clickContinueUnderPaymentInformation() {
    driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input")).click();
 }

 @And("the user clicks the Confirm button under Confirm Order")
 public void clickContinueUnderConfirmOrder() {
driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input")).click();
 }

 @Then("the user should see the order confirmation message")
 public void verifyOrderConfirmationMessage() {
WebElement Thank = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[1]/strong"));
Assert.assertTrue(Thank.getText().contains("Your order has been successfully processed!"));
 }

}

