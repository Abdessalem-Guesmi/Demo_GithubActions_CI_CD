package dropdown;

import static org.testng.Assert.assertTrue;

import java.util.List;

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
import io.qameta.allure.TmsLink;
import pages.DropDownPage;

@Epic("EP007")
@Feature("feature7: DropDownTest")

public class DropDownTest extends BaseTests {
	@Description("DropDown Test")

	@Story("story7")
	@Step("step7")
	@Severity(SeverityLevel.NORMAL)
	@TmsLink("focus-case-1637103")
	@Test
	public void testDropDown() {
		DropDownPage downPage = homePage.clickDropDown();
		// downPage.addMultipleAttribute();
		String option = "Option 1";
		downPage.selectFromDropDown(option);
		List<String> selectedOptions = downPage.getSelectedOptions();
		Assert.assertEquals(option, "Option 1", "Incorrect number of selections");
		assertTrue(downPage.getSelectedOptions().contains(option), "Option not selected");
	}
}
