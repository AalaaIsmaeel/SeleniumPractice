package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.qameta.allure.Step;

import java.util.Date;





public class SignUpPage {
	private WebDriver driver;
	private By firstnameField = By.name("firstname");
	private By lastnameField = By.name("lastname");
	private By mobilenumberField = By.name("phone");
	private By mailField = By.name("email");
	private By passwordField = By.name("password");
	private By confirmpasswordField = By.name("confirmpassword");
	private By SignUpButton = By.xpath("//button[(@type='submit')]");
			
	

	public SignUpPage(WebDriver driver) {
		this.driver = driver;

	}
 // Method User signup and in the test pass parameters
	
 // Add method and call all these sets in it
	 @Step("Sign up - First Name: [{firstName}], Last Name: [{lastName}], Mobile Number: [{mobileNumber}], Email: [{email}], Password: [{password}] and Confirm Password: [{confirmpassword}]")
	public void signUp(String firstname, String lastname, String mobilenumber, String email,String password,String confirmpassword ) {
		
		driver.findElement(firstnameField).sendKeys(firstname);

		driver.findElement(lastnameField).sendKeys(lastname);
		
		driver.findElement(mobilenumberField).sendKeys(mobilenumber);
		
		driver.findElement(mailField).sendKeys(email);
		
		driver.findElement(passwordField).sendKeys(password);
		
		driver.findElement(confirmpasswordField).sendKeys(confirmpassword);

	}
	
	public static long CurrentTime() {
		
		Date date= new Date();
		long currentTime = date.getTime(); 
		return currentTime;
	}

	
	//TODO: close element cookies then 
	@Step("Submit signup form")
	public MyAccount clickSignUpButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(SignUpButton));
		driver.findElement(SignUpButton).click();
        return new MyAccount(driver);

        
	}

}
