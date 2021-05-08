package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public LoadingPage clickLoadingPage() {
		clickLink("Dynamic Loading");
		return new LoadingPage(driver);
	}

	public FramePage clickFrame() {
		clickLink("Frames");
		return new FramePage(driver);
	}

	public DropDownPage clickDropDown() {
		clickLink("Dropdown");
		return new DropDownPage(driver);
	}

	public FileUploadPage clickFileUpload() {
		clickLink("File Upload");
		return new FileUploadPage(driver);
	}

	public LoginPage clickFormAuthentication() {
		clickLink("Form Authentication");
		return new LoginPage(driver);
	}

	public AlertPage clickJavaScriptAlerts() {
		clickLink("JavaScript Alerts");
		return new AlertPage(driver);
	}

	public GeolocationPage clickGeolocation() {
		clickLink("Geolocation");
		return new GeolocationPage(driver);
	}

	public ForgotPasswordPage clickForgotPassword() {
		clickLink("Forgot Password");
		return new ForgotPasswordPage(driver);
	}

	public StatusCodesPage clickStatusCode() {
		clickLink("Status Codes");
		return new StatusCodesPage(driver);
	}

	private void clickLink(String link) {
		driver.findElement(By.linkText(link)).click();
	}
}
