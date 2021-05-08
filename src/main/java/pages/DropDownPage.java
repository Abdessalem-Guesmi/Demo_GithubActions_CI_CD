package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage {
	private WebDriver driver;
	private By dropdown = By.id("dropdown");

	public DropDownPage(WebDriver driver) {

		this.driver = driver;
	}

	public void selectFromDropDown(String option) {
		Select dropd = new Select(driver.findElement(dropdown));
		dropd.selectByVisibleText(option);
	}

	public List<String> getSelectedOptions() {
		Select dropd = new Select(driver.findElement(dropdown));
		List<WebElement> selectedElements = dropd.getAllSelectedOptions();
		return selectedElements.stream().map(e -> e.getText()).collect(Collectors.toList());
	}

	/*
	 * public void addMultipleAttribute() { String script =
	 * "arguments[0].setAttribute('multiple','')"; String script2 =
	 * "background.color=red"; ((JavascriptExecutor) driver).executeScript(script2,
	 * new Select(driver.findElement(dropdown))); }
	 */
}
