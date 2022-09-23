package runnerSlots002;

import javax.security.auth.login.FailedLoginException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import baseUtilities.ReportCreate;
import baseUtilities.ResultListener;
import baseUtilities.VariableContainer;
import functions.LoginFE;
import functions.CategoryVendorAndGame;

public class PGSOFTSlotsGame extends VariableContainer {

	ReportCreate rCreate = new ReportCreate();
	ResultListener rListener = new ResultListener();

	LoginFE log = new LoginFE();
	CategoryVendorAndGame categoryVAG = new CategoryVendorAndGame();

	private static String reportName = "PGSOFTSlotsGame";

	@BeforeClass
	@Parameters({ "platform", "browser", "javaVersion", "user" })
	public void startReportAndSetProperty(String platform, String browser, String javaVersion, String user) {
		bDriver.setChromeDriverProperty(driverTypeChrome, driverPathChrome);
		bDriver.startChromeDriver();
		rCreate.generateReport(reportName, platform, browser, javaVersion, user);
	}

	@Test(priority = 0)
	@Parameters({ "url" })
	public void goToSite(String url) {
		rCreate.createTest("goToSite");
		bDriver.getURL(url);
	}

	@Test(priority = 1, groups = "login")
	@Parameters({ "userIDFE" })
	public void login(String userIDFE) throws FailedLoginException, InterruptedException {
		rCreate.createTest("login");
		log.loginOptionButton();
		log.setUserID(userIDFE);
		log.setPassword(passwordFE);
		log.selectLoginButton();
		log.verifyLogIn(userIDFE);
	}

	@Test(priority = 2, groups = "category")
	@Parameters({ "slotsCategoryNumber" })
	public void selectCategory(String slotsCategoryNumber) throws FailedLoginException, InterruptedException {
		rCreate.createTest("selectCategory");
		categoryVAG.selectCategory(slotsCategoryNumber);
	}

	@Test(priority = 3, groups = "vendorAndGame")
	@Parameters({ "slotsVendor", "vendorPGSOFT", "cq9Game1", "cq9Game2", "numberOfGamesToTest", "pastDate" })
	public void selectPGSOFTVendorAndGame(String slotsVendor, String vendorPGSOFT, String pgsoftGame1, String pgsoftGame2, int numberOfGamesToTest, String pastDate) throws Exception {
		rCreate.createTest("selectPGSOFTVendorAndGame");
		if (slotsVendor.equalsIgnoreCase("ALL")) {
			categoryVAG.selectVendors(vendorPGSOFT);
			categoryVAG.selectSlotsGame(vendorPGSOFT, pgsoftGame1, pgsoftGame2, numberOfGamesToTest, pastDate);

		} else if (slotsVendor.equalsIgnoreCase("PGSOFT")) {
			categoryVAG.selectVendors(vendorPGSOFT);
			categoryVAG.selectSlotsGame(vendorPGSOFT, pgsoftGame1, pgsoftGame2, numberOfGamesToTest, pastDate);
			
		} else {
			skip = "selectPGSOFTVendorAndGame skipped";
			rCreate.getExtentTest().skip(skip);
		}
	}

	@AfterMethod
	public void logCaseStatus(ITestResult result) throws Exception {
		rListener.logCaseStatus(result);
	}

	@AfterClass
	public void stopDriver() throws InterruptedException {
		Thread.sleep(1000);
		rCreate.flushTest();
		bDriver.stopDriver();
	}

}
