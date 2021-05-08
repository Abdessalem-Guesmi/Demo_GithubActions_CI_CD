package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GeolocationPage {
	private WebDriver driver;
	private By geolocationButton = By.xpath("//button[text()='Where am I?']");
	private By contentText = By.id("demo");
	private By latitude = By.id("lat-value");
	private By longitude = By.id("long-value");

	public GeolocationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickGeolocationButton() {
		driver.findElement(geolocationButton).click();

	}

	public String getLatitude() {
		return driver.findElement(latitude).getText();
	}

	public String getLongititude() {
		return driver.findElement(longitude).getText();
	}

}
