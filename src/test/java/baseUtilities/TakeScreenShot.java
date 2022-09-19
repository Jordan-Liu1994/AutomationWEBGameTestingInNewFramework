package baseUtilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot extends VariableContainer {

	private static String userDir = System.getProperty("user.dir");
	private static String pathOfSS = userDir + ".\\src\\test\\resources\\screenshots\\";

	public void takeSnapShot(String fileWithPath) throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) bDriver.getDriver());
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(pathOfSS + fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);

	}

	public String screenShotPathExtent() {
		return pathOfSS;
	}
}