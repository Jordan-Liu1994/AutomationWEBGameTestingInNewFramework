package baseUtilities;

import java.util.Iterator;
import java.util.Set;

public class IterateNextWindows extends VariableContainer {

	TakeScreenShot takeSS = new TakeScreenShot();
	ReportCreate rCreate = new ReportCreate();
	
	String res;
	Set<String> nextWindowHandle;

	public void iterateToGameWindow(int time, String vendorName, String parentWindowHandle) throws Exception {
		nextWindowHandle = bDriver.getDriver().getWindowHandles();
		Thread.sleep(500);
		Iterator<String> iterate = nextWindowHandle.iterator();
		while (iterate.hasNext()) {
			String winHandle = iterate.next();
			bDriver.getDriver().switchTo().window(winHandle);
			bDriver.getDriver().manage().window().maximize();
		}
		Thread.sleep(time);
		res = vendorName + ".png";
		takeSS.takeSnapShot(res);
		rCreate.getExtentTest().addScreenCaptureFromPath(takeSS.screenShotPathExtent() + res, vendorName);

		bDriver.closeBrowser();
		bDriver.getDriver().switchTo().window(parentWindowHandle);
	}
}
