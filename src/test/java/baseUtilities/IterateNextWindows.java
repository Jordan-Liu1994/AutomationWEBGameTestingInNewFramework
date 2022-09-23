package baseUtilities;

import java.util.concurrent.TimeUnit;

public class IterateNextWindows extends VariableContainer {

	TakeScreenShot takeSS = new TakeScreenShot();
	ReportCreate rCreate = new ReportCreate();

	String res;

	public void maximizeWindow() {
		bDriver.getDriver().manage().window().maximize();
	}
	
	public void iterateToGameWindow() {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		childWindow = bDriver.getDriver().getWindowHandles().toArray()[1].toString();
		bDriver.getDriver().switchTo().window(childWindow);
		System.out.println(childWindow);
	}
	
	public void iterateToBetRecordWindow() {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		grandChildWindow = bDriver.getDriver().getWindowHandles().toArray()[2].toString();
		bDriver.getDriver().switchTo().window(grandChildWindow);
		System.out.println(grandChildWindow);
	}
	
	public void iterateToBetDetailsWindow() {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		greatGrandChildWindow = bDriver.getDriver().getWindowHandles().toArray()[3].toString();
		bDriver.getDriver().switchTo().window(greatGrandChildWindow);
		System.out.println(greatGrandChildWindow);
	}

	public void screenShotFinalWindow(String vendorName) throws Exception {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		res = vendorName + ".png";
		takeSS.takeSnapShot(res);
		rCreate.getExtentTest().addScreenCaptureFromPath(takeSS.screenShotPathExtent() + res, vendorName);
	}

	public void closeNewWindow() throws Exception {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		bDriver.closeBrowser();
		Thread.sleep(500);
		bDriver.getDriver().switchTo().window(grandChildWindow);
		bDriver.closeBrowser();
		Thread.sleep(500);
		bDriver.getDriver().switchTo().window(childWindow);
		bDriver.closeBrowser();

	}

	public void backToMainWindow(String parentWindowHandle) throws Exception {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		bDriver.getDriver().switchTo().window(parentWindowHandle);
	}
}
