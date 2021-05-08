package login;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
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

public class LoginTest extends BaseTests {
	@Description("Login Test")
	@Epic("EP004")
	@Feature("feature4: LoginTest")
	@Story("story4")
	@Step("step4")
	@Severity(SeverityLevel.CRITICAL)
	@Test(dataProvider = "dataForLogin")
	public void testSuccessfulLogin(String username, String password) {
		LoginPage loginPage = homePage.clickFormAuthentication();
		loginPage.setUsername(username);
		loginPage.setPassword(password);
		SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
		String text = secureAreaPage.getAlertText();
		assertTrue(text.contains("You logged into a secure area!"), "text is not correct");
	}

	@DataProvider(name = "dataForLogin")
	public Object dataForLogin() {
		Object[][] data = new Object[2][2];
		data[0][0] = "tomsmith";
		data[0][1] = "SuperSecretPassword!";

		data[1][0] = "kimsmith";
		data[1][1] = "SuperSecretPassword";
		return data;

	}
}
