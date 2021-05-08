package status;

import org.testng.Assert;
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
import pages.DescriptionStatusPage;
import pages.StatusCodesPage;

public class StatusCodeTest extends BaseTests {
	@Description("Status Code Test")
	@Epic("EP006")
	@Severity(SeverityLevel.NORMAL)
	@Feature("feature6: Status Code Test")
	@Story("story6")
	@Step("step6")
	@Test(dataProvider = "dataStatusCode")
	public void testStatusCodes(String code) {
		StatusCodesPage statusCodes = homePage.clickStatusCode();
		DescriptionStatusPage descriptionCode = statusCodes.clickStatusCode(code);
		String desc = descriptionCode.getDescCode();
		Assert.assertTrue(desc.contains(code), "status not found");

	}

	@DataProvider(name = "dataStatusCode")
	public Object[][] dataStatusCode() {
		return new Object[][] { { "200" }, { "301" }, { "404" }, { "500" }, { "521" } };
	}

}
