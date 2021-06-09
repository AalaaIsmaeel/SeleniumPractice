package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

public class MyAccount {
	private WebDriver driver;

	public MyAccount(WebDriver driver) {
		this.driver = driver;
	}

	private By welcomemessage = By.xpath("//div[(@class='col-md-8')]");

	@Step("Get Welcome Message text")
	public String getWelcomeMessagetext() {

		return driver.findElement(welcomemessage).getText();
	}

}
