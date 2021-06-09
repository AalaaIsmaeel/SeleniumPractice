package SignUpTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import static org.testng.Assert.assertTrue;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import Pages.HomePage;
import Pages.MyAccount;
import Pages.SignUpPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import utils.BrowserAction;
import utils.EventReporter;
import utils.SpreedSheet;

public class SignUpTest {
	// Declare
	EventFiringWebDriver driver;
	
	HomePage homePage;
	SignUpPage signUp;
	BrowserAction Actions;
	SpreedSheet spreedSheet;
	String firstName, lastName, mobileNumber, email, password,confirmPassword;
	//String fileName = "src/test/resources/TestData/SignUpTestData.xlsx";
	
    

	@BeforeClass
	public void setup() {
		// Calling
		WebDriverManager.chromedriver().setup();
		driver = new EventFiringWebDriver(new ChromeDriver());
		driver.register(new EventReporter());
		homePage = new HomePage(driver);
		Actions = new BrowserAction(driver);
		Actions.maximizeWindow(driver);
		homePage.navigateToHomePage();
		signUp = new SignUpPage(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//SpreedSheet sp= new SpreedSheet(fileName, "Sheet1");
		spreedSheet = new SpreedSheet(new File("src/test/resources/TestData/test.xlsx"));
		spreedSheet.switchToSheet("test1");
	}


	@Test (description="Valid SignUp Scenario with correct date.")

	public void testSuccessfullSignUp() {
	/*	
		
		firstName = SpreedSheet.getData(1, 0);
		lastName = SpreedSheet.getData(1, 1);
		mobileNumber = SpreedSheet.getData(1, 2);
		email = SpreedSheet.getData(1, 3) + SignUpPage.CurrentTime()  + "@gmail.com";
		password = SpreedSheet.getData(1, 4);
		confirmPassword = SpreedSheet.getData(1, 5);
		*/
		homePage.OpenSignUpPage();
		firstName = spreedSheet.getCellData("FirstName", 2);
		lastName = spreedSheet.getCellData("LastName", 2);
		mobileNumber = spreedSheet.getCellData("Mobile Number", 2);
		email = spreedSheet.getCellData("Email", 2) + SignUpPage.CurrentTime()  + "@gmail.com";
		password = spreedSheet.getCellData("Password", 2);
		confirmPassword = spreedSheet.getCellData("ConfirmPassword", 2);
		signUp.signUp(firstName, lastName, mobileNumber, email, password,
				confirmPassword);
		

		MyAccount MyAccountPage = signUp.clickSignUpButton();
		assertTrue(MyAccountPage.getWelcomeMessagetext().contains(firstName + " " + lastName),
				"WelcomeMessage text is correct");

	}

	@AfterClass

	public void teardown() {

		Actions.tearDown();
	}

}
