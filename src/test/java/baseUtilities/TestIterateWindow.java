package baseUtilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestIterateWindow extends VariableContainer {

	WebElement newWindow;
	String parentWindow;
	String childWindow;
	String grandWindow;

	@BeforeClass
	public void setup() {
		bDriver.setChromeDriverProperty(driverTypeChrome, driverPathChrome);
		bDriver.startChromeDriver();
	}

	@Test(priority = 0)
	public void toSite() {
		bDriver.getURL("https://the-internet.herokuapp.com/windows");
	}

	@Test(priority = 1)
	public void openNewWindow() throws InterruptedException {
		parentWindow = bDriver.getDriver().getWindowHandle();
		System.out.println("Parent = " + parentWindow);

		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		newWindow = bDriver.getDriver().findElement(By.xpath("//a[normalize-space()='Click Here']"));
		newWindow.click();
		Thread.sleep(1500);

		childWindow = bDriver.getDriver().getWindowHandles().toArray()[1].toString();
		bDriver.getDriver().switchTo().window(childWindow);
	}

	@Test(priority = 2)
	public void doSomething() throws InterruptedException {
		System.out.println("Child = " + childWindow);

		bDriver.getDriver().switchTo().window(parentWindow);
		Thread.sleep(1500);
		newWindow.click();
		Thread.sleep(1500);
	}

	@Test(priority = 3)
	public void openNewWindow2() throws InterruptedException {
		grandWindow = bDriver.getDriver().getWindowHandles().toArray()[2].toString();
		bDriver.getDriver().switchTo().window(grandWindow);
		System.out.println("Grandchild = " + grandWindow);
		Thread.sleep(1500);
		bDriver.closeBrowser();
		Thread.sleep(1500);
	}

	@Test(priority = 4)
	public void closeBrowsers() throws InterruptedException {
		bDriver.getDriver().switchTo().window(childWindow);
		System.out.println("Back to child = " + childWindow);
		bDriver.closeBrowser();
		Thread.sleep(1500);
	}
	
	@Test(priority = 5)
	public void backToDefault() throws InterruptedException {
		bDriver.getDriver().switchTo().window(parentWindow);
	}

	@AfterClass
	public void end() throws InterruptedException {
		Thread.sleep(1500);
		bDriver.stopDriver();
	}

}
