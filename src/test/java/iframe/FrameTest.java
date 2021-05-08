package iframe;

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
import pages.FramePage;
import pages.IFramesPage;

public class FrameTest extends BaseTests {
	@Description("Frame Test")
	@Epic("EP003")
	@Feature("feature3: FrameTest")
	@Story("story3")
	@Step("step3")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void testFrame() {
		FramePage framePage = homePage.clickFrame();
		IFramesPage iFramesPage = framePage.clickNestedFrames();
		String text1 = "Hello ";
		String text2 = "Automation";
		iFramesPage.clearTextArea();

		iFramesPage.setTextArea(text1);
		iFramesPage.decreaseIndention();

		iFramesPage.setTextArea(text2);
		assertEquals(iFramesPage.getTextFromEditor(), text1 + text2, "not Equal!!");
	}
}
