package base;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.google.common.collect.ImmutableMap;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;

public class BaseTests {
	private static Properties properties;
	public static WebDriver driver;
	protected HomePage homePage;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	public BaseTests() {
		try {
			properties = new Properties();
			String path = System.getProperty("user.dir");
			String propFileName = "/src/test/resources/setup.properties";
			InputStream input = new FileInputStream(path + propFileName);

			properties.load(input);
		} catch (IOException exception) {
			exception.getCause();
		}

	}

	public static WebDriver initialize_driver() {
		if (properties.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			tdriver.set(driver);
		} else if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			tdriver.set(driver);
		}
		return getDriver();

	}

	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}

	@BeforeSuite
	public void setAllureEnvironment() {
		allureEnvironmentWriter(ImmutableMap.<String, String>builder().put("browser", properties.getProperty("browser"))
				.put("Tester", properties.getProperty("Tester"))
				.put("Browser_version", properties.getProperty("chrome")).put("URL", properties.getProperty("URL"))
				.put("System", properties.getProperty("System")).build(),
				System.getProperty("user.dir") + "/allure-results/");
	}

	@BeforeMethod
	public void setUp() {

		initialize_driver();
		driver.get(properties.getProperty("uri"));
		homePage = new HomePage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
