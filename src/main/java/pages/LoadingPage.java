package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoadingPage {
	private WebDriver driver;
	private String linkXpath_Format = ".//a[contains(text(), '%s')]";
	private By example1 = By.xpath(String.format(linkXpath_Format, "Example 1"));
	private By example2 = By.xpath(String.format(linkXpath_Format, "Example 2"));

	public LoadingPage(WebDriver driver) {

		this.driver = driver;
	}

	public Example1LoadingPage clickOnExmple1() {
		driver.findElement(example1).click();
		return new Example1LoadingPage(driver);
	}

	public Example2LoadingPage clickOnExmple2() {
		driver.findElement(example2).click();
		return new Example2LoadingPage(driver);
	}

}
