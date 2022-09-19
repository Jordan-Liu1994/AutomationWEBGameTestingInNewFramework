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

public class SlotsGame extends VariableContainer {

	ReportCreate rCreate = new ReportCreate();
	ResultListener rListener = new ResultListener();

	LoginFE log = new LoginFE();
	CategoryVendorAndGame sportCat = new CategoryVendorAndGame();

	private static String reportName = "SlotsGame";

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
	@Parameters({ "slotsCategoryNumber" })
	public void selectCategory(String slotsCategoryNumber) throws FailedLoginException {
		rCreate.createTest("selectCategory");
		sportCat.selectCategory(slotsCategoryNumber);
	}

	@Test(priority = 3)
	@Parameters({ "slotsMaster", "LKVendor", "PTTCGVendor", "CQ9Vendor", "PGSOFTSlotsGame1", "PGSOFTSlotsGame2", "PGSOFTSlotsGame3", "PTTCGSlotsGame1", "PTTCGSlotsGame2", "PTTCGSlotsGame3", "CQ9SlotsGame1", "CQ9SlotsGame2", "CQ9SlotsGame3", "LKSlotsGame1", "LKSlotsGame2", "LKSlotsGame3", "time" })
	public void selectVendor(String slotsMaster, String LKVendor, String PTTCGVendor, String CQ9Vendor, String PGSOFTSlotsGame1, String PGSOFTSlotsGame2, String PGSOFTSlotsGame3, String PTTCGSlotsGame1, String PTTCGSlotsGame2, String PTTCGSlotsGame3, String CQ9SlotsGame1, String CQ9SlotsGame2, String CQ9SlotsGame3, String LKSlotsGame1, String LKSlotsGame2, String LKSlotsGame3, int time) throws Exception {
		rCreate.createTest("selectVendor");
		if (slotsMaster.equalsIgnoreCase("All")) {
			sportCat.selectMasterSlotsVendor();
			sportCat.openAllListedSlotsGame(PGSOFTSlotsGame1, PGSOFTSlotsGame2, PGSOFTSlotsGame3, time);
			// WIP because all under maintenance
			sportCat.selectSubSlotsVendor(PTTCGVendor);
			sportCat.openAllListedSlotsGame(PTTCGSlotsGame1, PTTCGSlotsGame2, PTTCGSlotsGame3, time);
			sportCat.selectSubSlotsVendor(CQ9Vendor);
			sportCat.openAllListedSlotsGame(CQ9SlotsGame1, CQ9SlotsGame2, CQ9SlotsGame3, time);
			sportCat.selectSubSlotsVendor(LKVendor);
			sportCat.openAllListedSlotsGame(LKSlotsGame1, LKSlotsGame2, LKSlotsGame3, time);
		} else if (slotsMaster.equalsIgnoreCase("PGSOFT")) {
			sportCat.selectMasterSlotsVendor();
			sportCat.openAllListedSlotsGame(PGSOFTSlotsGame1, PGSOFTSlotsGame2, PGSOFTSlotsGame3, time);
		} else if (slotsMaster.equalsIgnoreCase("PTTCG")) {
			sportCat.selectSubSlotsVendor(PTTCGVendor);
			sportCat.openAllListedSlotsGame(PTTCGSlotsGame1, PTTCGSlotsGame2, PTTCGSlotsGame3, time);
		} else if (slotsMaster.equalsIgnoreCase("CQ9")) {
			sportCat.selectSubSlotsVendor(CQ9Vendor);
			sportCat.openAllListedSlotsGame(CQ9SlotsGame1, CQ9SlotsGame2, CQ9SlotsGame3, time);
		} else if (slotsMaster.equalsIgnoreCase("LK")) {
			sportCat.selectSubSlotsVendor(LKVendor);
			sportCat.openAllListedSlotsGame(LKSlotsGame1, LKSlotsGame2, LKSlotsGame3, time);
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
