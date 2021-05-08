package uploadFile;

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
import pages.FileUploadPage;

public class UploadFileTest extends BaseTests {
	@Description("Upload FileTest")
	@Epic("EP007")
	@Severity(SeverityLevel.NORMAL)
	@Feature("feature7: UploadFileTest")
	@Story("story7")
	@Step("step7")
	@Test
	public void testUploadFile() {
		FileUploadPage fileUploadPage = homePage.clickFileUpload();
		String path = System.getProperty("user.dir") + "/FileUpload";
		fileUploadPage.uploadFile(path);
		String message = fileUploadPage.getUploadedFiles();
		assertEquals(message, "FileUpload", "Uploaded files incorrect");
	}
}
