package login;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginTestUsingPropFile extends BaseTests {
	private static Properties propertiesConf;

	public LoginTestUsingPropFile() {
		try {
			propertiesConf = new Properties();
			String path = System.getProperty("user.dir");
			String propFileName = "/src/test/resources/loginConfig.properties";
			InputStream input = new FileInputStream(path + propFileName);

			propertiesConf.load(input);
		} catch (IOException exception) {
			exception.getCause();
		}
	}

	@Description("Login Test")
	@Epic("EP004")
	@Feature("feature4: LoginTest")
	@Story("story4")
	@Step("step4")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void testSuccessfulLogin() {
		LoginPage loginPage = homePage.clickFormAuthentication();
		loginPage.setUsername(propertiesConf.getProperty("username"));
		loginPage.setPassword(propertiesConf.getProperty("password"));
		SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
		String text = secureAreaPage.getAlertText();
		assertTrue(text.contains("You logged into a secure area!"), "text is not correct");
	}

}
