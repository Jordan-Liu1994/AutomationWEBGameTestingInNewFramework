package baseUtilities;

import org.openqa.selenium.support.ui.WebDriverWait;

public class VariableContainer {

	protected static BaseDriver bDriver = new BaseDriver();
	
	protected static String driverTypeChrome = "webdriver.chrome.driver";
	protected static String driverPathChrome = "chromedriver.exe";
	
	protected static String step = "Step = ";
	protected static String attribute = "placeholder";
	protected static String keyIn = " keyed in ";
	protected static String keyOut = " removed from ";
	
	protected static String passwordFE = "test123";
	protected static String captchaFE = "123456";
	
	protected static WebDriverWait wait;
	protected static String fail;
	protected static String res;
	protected static String skip;
	protected static String parentWindow;
	protected static String childWindow;
	protected static String grandChildWindow;
	protected static String greatGrandChildWindow;
}
