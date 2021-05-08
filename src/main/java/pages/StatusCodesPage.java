package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StatusCodesPage {
	private WebDriver driver;

	public StatusCodesPage(WebDriver driver) {
		this.driver = driver;
	}

	public DescriptionStatusPage clickStatusCode(String code) {
		clickLinkCode(code);
		return new DescriptionStatusPage(driver);
	}

	private void clickLinkCode(String link) {
		driver.findElement(By.linkText(link)).click();
	}
}
