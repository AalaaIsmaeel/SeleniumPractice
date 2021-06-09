/*package WebLocatorsCourseTask;

import static org.testng.AssertJUnit.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleSearch {

	private WebDriver driver;
	private WebDriverWait wait;
	
	@BeforeTest
	public void initWebDriver() {
		driver= new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		
	}
	@Test
	
	//Load page
	driver.get("https://www.google.com/");
	
	//define element for search bar and Enter search phrase
	wait.until(ExpectedConditions.visiblityOfElementLocated(By.name("q")));
	WebElement searchInput= driver.findElement(By.name("q"));
	searchInput.sendkeys("API");
	
	//Click search button
	WebElement searchButton= driver.findElement(By.name("Tg7LZd"));
	seachButton.click();
	
	//Wait for results
	
	wait.until(ExpectedConditions.titleContains("API"));
	wait.until(ExpectedConditions.visiblityOfElementLocated(By.id("rso")));
	
	//Make sure each result contains word "API"
	
	List<WebElement> resultLinks= driver.findElements(By.id("rso")));
	for(WebElement link : resultLinks) {
		assertTrue(link.getText().matches("(?!).*API.*"));
		
	}
}*/
