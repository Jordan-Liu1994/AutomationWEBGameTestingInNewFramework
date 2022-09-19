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

public class PokerGame extends VariableContainer {

	ReportCreate rCreate = new ReportCreate();
	ResultListener rListener = new ResultListener();

	LoginFE log = new LoginFE();
	CategoryVendorAndGame sportCat = new CategoryVendorAndGame();

	private static String reportName = "PokerGame";

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
	@Parameters({ "pokerCategoryNumber" })
	public void selectCategory(String pokerCategoryNumber) throws FailedLoginException {
		rCreate.createTest("selectCategory");
		sportCat.selectCategory(pokerCategoryNumber);
	}

	@Test(priority = 3)
	@Parameters({ "pokerMaster", "VNDVendor", "time" })
	public void selectVendor(String pokerMaster, String VNDVendor, int time) throws Exception {
		rCreate.createTest("selectVendor");
		if (pokerMaster.equalsIgnoreCase("All")) {
			sportCat.openVNDPokerGame(VNDVendor, time);
		} else if (pokerMaster.equalsIgnoreCase("vnd")) {
			sportCat.openVNDPokerGame(VNDVendor, time);
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
