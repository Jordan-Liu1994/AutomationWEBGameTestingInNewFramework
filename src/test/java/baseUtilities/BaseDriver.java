package baseUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseDriver {

	static WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	private String driverFolderPath = ".\\src\\test\\resources\\drivers\\";

	public void setChromeDriverProperty(String driverType, String driverPath) {
		System.setProperty(driverType, driverFolderPath + driverPath);
	}

	public void startChromeDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	public void doRefresh() {
		driver.navigate().refresh();
	}

	public void getURL(String url) {
		driver.get(url);
	}

	public void closeBrowser() {
		driver.close();
	}

	public void stopDriver() {
		driver.quit();
	}
}
