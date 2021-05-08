package wait;

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
import pages.Example2LoadingPage;
import pages.LoadingPage;

public class Example2LoadingTest extends BaseTests {
	@Description("Example2 -->Loading Test")
	@Epic("EP008")
	@Severity(SeverityLevel.CRITICAL)
	@Feature("feature8: LoadingTest")
	@Story("story8")
	@Step("step8")
	@Test
	public void testWaitExmaple2() {
		LoadingPage loadingPage = homePage.clickLoadingPage();
		Example2LoadingPage example2LoadingPage = loadingPage.clickOnExmple2();
		example2LoadingPage.clickOnStart();
		String textContent = example2LoadingPage.getMessage();
		assertEquals(textContent, "Hello World!", "message not found");
	}
}
