package alert;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import pages.AlertPage;

@Epic("EP001")
@Feature("feature1: AlertTest")
public class AlertTest extends BaseTests {
	@Description("Alert Test")
	@Story("story1")
	@Step("step1")
	@Severity(SeverityLevel.NORMAL)
	@TmsLink("focus-case-1637103")
	@Test
	public void testAcceptAlert() {
		AlertPage alertPage = homePage.clickJavaScriptAlerts();
		alertPage.triggerAlert();
		alertPage.alert_clickToAccept();
		assertEquals(alertPage.getResult(), "You successfuly clicked an alert", "Results text incorrect");
	}

	@Test
	public void testGetTextFromAlert() {
		AlertPage alertPage = homePage.clickJavaScriptAlerts();
		alertPage.triggerConfirm();
		String text = alertPage.alert_getText();
		alertPage.alert_clickToDismiss();
		assertEquals(text, "I am a JS Confirm", "Alert text incorrect");
	}

	@Test
	public void testSetInputInAlert() {
		AlertPage alertPage = homePage.clickJavaScriptAlerts();
		alertPage.triggerPrompt();

		String text = "I m abdou";
		alertPage.alert_setInput(text);
		alertPage.alert_clickToAccept();
		assertEquals(alertPage.getResult(), "You entered: " + text, "Results text incorrect");
	}
}
