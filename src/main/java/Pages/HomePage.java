package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.qameta.allure.Link;
import io.qameta.allure.Step;
import utils.BrowserAction;

      public class HomePage {
    	  
    	  // TODO :add locator
	
		EventFiringWebDriver driver;
		private String URL= "https://www.phptravels.net/en";
		
		// Create constructor for the webdriver to use in the method
		// Start class with default variable 
		public HomePage(EventFiringWebDriver driver) {
			this.driver = driver;
		}
		
      // Navigate to SignUpePage
		@Step("Navigate to SignUp Page")
		public SignUpPage OpenSignUpPage() {
			clickOnMyAccount("//i[@class=\"bx bx-user\"][1]");
			clickOnLink("Sign Up");
			return new SignUpPage(driver);
		}
	
		// clickOnLink "search for access modifier"
		private void clickOnLink(String LinkText) {
			driver.findElement(By.linkText(LinkText)).click();

		}

		private void clickOnMyAccount(String xpathExpression) {

			driver.findElement(By.xpath(xpathExpression)).click();

		}
		
		// navigate to URL as open url will navigate always to homepage
		@Step("Open Website URl")
		@Link("https://www.phptravels.net/")
		 public void navigateToHomePage() {
			 
			 BrowserAction.navigateToURl(driver, URL);
			 
		 }
	
		
}
