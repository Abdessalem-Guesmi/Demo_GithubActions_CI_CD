package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Example2LoadingPage {
	private WebDriver driver;
	private By startButton = By.xpath("//button[text()='Start']");
	private By loadingIndicator = By.id("loading");
	private By contentText = By.id("finish");

	public Example2LoadingPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void clickOnStart() {
		driver.findElement(startButton).click();
		/* FLUENT WAIT */
		FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));

	}

	public String getMessage() {
		return driver.findElement(contentText).getText();
	}
}
