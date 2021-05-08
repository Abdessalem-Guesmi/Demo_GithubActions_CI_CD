package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DescriptionStatusPage {
	private WebDriver driver;
	private By contentStatus = By.id("content");

	public DescriptionStatusPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getDescCode() {
		return driver.findElement(contentStatus).getText();
	}

}
