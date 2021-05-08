package geolocation;

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
import pages.GeolocationPage;

@Epic("EP002")
@Feature("feature2: Geolocation Test")
public class GeolocationTest extends BaseTests {
	@Description("Geolocation Test")
	@Story("story2")
	@Step("step2")
	@Severity(SeverityLevel.NORMAL)
	@TmsLink("focus-case-1637103")
	@Test
	public void testGeolocation() {
		GeolocationPage geolocation = homePage.clickGeolocation();

		geolocation.clickGeolocationButton();
		String latitude = geolocation.getLatitude();
		System.out.println("your Country: see your: " + latitude);
		String longitude = geolocation.getLongititude();
		System.out.println("your Country: see your: " + longitude);
		Assert.assertTrue(latitude.contains("36.85"), "Latitude not correct");
		Assert.assertTrue(longitude.contains("10.26"), "Longitude not correct");
	}
}
