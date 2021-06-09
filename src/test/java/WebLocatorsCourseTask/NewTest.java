package WebLocatorsCourseTask;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {
	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeTest
	public void initWebDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		

	}

	@Test
	public void test() {
	//Load page
	driver.get("https://www.google.com/");
	
	//define element for search bar and Enter search phrase
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("q")));
	driver.findElement(By.name("q")).sendKeys("API", Keys.ENTER);

	// Click search button
	//driver.findElement(By.name("Tg7LZd")).click();

	// Wait for results

	wait.until(ExpectedConditions.titleContains("API"));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rso")));

	// Make sure each result contains word "API"

	List<WebElement> resultLinks= driver.findElements(By.id("rso"));
	for(WebElement link:resultLinks)
	{
		assertTrue((link.getText().contains("API")));

	}
	}

}
