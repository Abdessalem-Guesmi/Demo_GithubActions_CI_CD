package sentEmail;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import pages.EmailSentPage;
import pages.ForgotPasswordPage;

public class SentEmailTest extends BaseTests {
	@Description("Send Email Test")
	@Epic("EP005")
	@Severity(SeverityLevel.MINOR)
	@Feature("feature5: Send Email Test")
	@Story("story5")
	@Step("step5")
	@Test
	public void testSentEmail() {
		ForgotPasswordPage forgetPasswordPage = homePage.clickForgotPassword();
		forgetPasswordPage.enterEmail("abdessalem.guesmi@gmail.com");
		EmailSentPage sentEmail = forgetPasswordPage.clickRetrievePassword();
		String message = sentEmail.getMessage();
		Assert.assertEquals(message, "Your e-mail's been sent!", "message is incorrect");
	}
}
