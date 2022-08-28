package com.base;

import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static Properties property;
	
	public  WebDriver driver;

	public static void loadConfigproperty() {

		try {

			File f = new File(".\\src\\test\\java\\com\\Configure\\Config.properties");

			FileReader fr = new FileReader(f);

			property = new Properties();

			property.load(fr);

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}

	}

	public static String getConfig(String Key)

	{

		loadConfigproperty();

		String value = property.getProperty(Key);

		return value;

	}

	@BeforeTest
	public  void configBrowser() throws Exception {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		String navigateURL = TestBase.getConfig("url");

		driver.get(navigateURL);
		

	}

	@AfterTest
	public  void closeBrowser() {
		System.out.println("2");
		driver.quit();

	}

}
