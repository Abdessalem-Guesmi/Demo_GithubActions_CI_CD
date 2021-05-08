package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Example1LoadingPage {
	private WebDriver driver;
	private By startButton = By.xpath("//button[text()='Start']");
	private By loadingIndicator = By.id("loading");
	private By contentText = By.id("finish");

	public Example1LoadingPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void clickOnStart() {
		driver.findElement(startButton).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));

	}

	public String getMessage() {
		return driver.findElement(contentText).getText();
	}
}
