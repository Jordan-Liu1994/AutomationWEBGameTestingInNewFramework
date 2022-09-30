package runnerLive003;

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

public class BBINLiveGame extends VariableContainer {

	ReportCreate rCreate = new ReportCreate();
	ResultListener rListener = new ResultListener();

	LoginFE log = new LoginFE();
	CategoryVendorAndGame categoryVAG = new CategoryVendorAndGame();

	private static String reportName = "BBINLiveGame";

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
	@Parameters({ "liveCategoryNumber" })
	public void selectCategory(String liveCategoryNumber) throws FailedLoginException, InterruptedException {
		rCreate.createTest("selectCategory");
		categoryVAG.selectCategory(liveCategoryNumber);
	}

	@Test(priority = 3, groups = "vendorAndGame")
	@Parameters({ "liveVendor", "vendorBBIN" })
	public void selectBBINVendorAndGame(String liveVendor, String vendorBBIN) throws Exception {
		rCreate.createTest("selectBBINVendorAndGame");
		if (liveVendor.equalsIgnoreCase("ALL")) {
			categoryVAG.selectLiveVendors(vendorBBIN);
			categoryVAG.selectLiveBBINGame();
			categoryVAG.selectLiveBBINGameOption();
			categoryVAG.selectLiveBBINPlaceABet(vendorBBIN);

		} else if (liveVendor.equalsIgnoreCase("BBIN")) {
			categoryVAG.selectLiveVendors(vendorBBIN);
			categoryVAG.selectLiveBBINGame();
			categoryVAG.selectLiveBBINGameOption();
			categoryVAG.selectLiveBBINPlaceABet(vendorBBIN);
			
		} else {
			skip = "selectBBINVendorAndGame skipped";
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
