package runners;

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

public class FishGame extends VariableContainer {

	ReportCreate rCreate = new ReportCreate();
	ResultListener rListener = new ResultListener();

	LoginFE log = new LoginFE();
	CategoryVendorAndGame sportCat = new CategoryVendorAndGame();

	private static String reportName = "FishGame";

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
		log.setCaptcha(captchaFE);
		log.setSliderCaptcha();
		log.selectLoginButton();
		log.verifyLogIn(userIDFE);
	}

	@Test(priority = 2)
	@Parameters({ "fishCategoryNumber" })
	public void selectCategory(String fishCategoryNumber) throws FailedLoginException {
		rCreate.createTest("selectCategory");
		sportCat.selectCategory(fishCategoryNumber);
	}

	@Test(priority = 3)
	@Parameters({ "fishMaster", "CQ9FishGame1", "CQ9FishGame2", "CQ9FishGame3", "time" })
	public void selectVendor(String fishMaster, String CQ9FishGame1, String CQ9FishGame2, String CQ9FishGame3, int time) throws Exception {
		rCreate.createTest("selectVendor");
		if (fishMaster.equalsIgnoreCase("All")) {
			sportCat.selectMasterFishVendor();
			sportCat.openAllListedCQ9FishGame(CQ9FishGame1, CQ9FishGame2, CQ9FishGame3, time);
		} else if (fishMaster.equalsIgnoreCase("CQ9")) {
			sportCat.selectMasterFishVendor();
			sportCat.openAllListedCQ9FishGame(CQ9FishGame1, CQ9FishGame2, CQ9FishGame3, time);
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
