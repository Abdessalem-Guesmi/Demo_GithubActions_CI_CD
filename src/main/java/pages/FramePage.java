package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramePage {
	private WebDriver driver;
	private By nestedLink = By.linkText("iFrame");

	public FramePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public IFramesPage clickNestedFrames() {
		driver.findElement(nestedLink).click();
		return new IFramesPage(driver);
	}
}
