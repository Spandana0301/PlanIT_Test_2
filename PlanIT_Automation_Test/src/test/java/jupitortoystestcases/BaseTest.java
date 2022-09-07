package jupitortoystestcases;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected  WebDriver driver;
	
	@BeforeMethod
	public  void openingBrowser()  {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		driver.get("https://jupiter.cloud.planittesting.com/#/");
		
	}

	@AfterMethod
	public  void closeBrowser() {
		driver.quit();

	}

}
