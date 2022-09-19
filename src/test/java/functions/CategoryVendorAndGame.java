package functions;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.security.auth.login.FailedLoginException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import baseUtilities.IterateNextWindows;
import baseUtilities.ReportCreate;
import baseUtilities.VariableContainer;

public class CategoryVendorAndGame extends VariableContainer {

	ReportCreate rCreate = new ReportCreate();
	IterateNextWindows INW = new IterateNextWindows();

	String fail;
	String res;
	String parentWindowHandle;
	Set<String> nextWindowHandle;
	Actions builder;

	public void selectCategory(String categoryNumber) throws FailedLoginException {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement selectCategory = bDriver.getDriver().findElement(By.xpath("(//div[@class='header_menu_item'])[" + categoryNumber + "]"));

		if (selectCategory.isDisplayed()) {
			String selectCategoryText = selectCategory.getText();
			selectCategory.click();
			rCreate.getExtentTest().info("Clicked " + selectCategoryText);
		} else {
			fail = "selectCategory failed";
			rCreate.getExtentTest().fail(fail);
			throw new FailedLoginException(fail);
		}
	}

	public void openVNDSportsGame(String VNDVendor, int time) throws Exception {
		parentWindowHandle = bDriver.getDriver().getWindowHandle();

		WebElement openVNDSportsGame = bDriver.getDriver().findElement(By.xpath("(//div[contains(text(),'" + VNDVendor + "')])[2]"));
		if (openVNDSportsGame.isDisplayed()) {
			openVNDSportsGame.click();
			rCreate.getExtentTest().info("Clicked " + VNDVendor);

			INW.iterateToGameWindow(time, VNDVendor, parentWindowHandle);
		} else {
			fail = "openVNDSportsGame failed";
			rCreate.getExtentTest().fail(fail);
		}
	}

	public void openIBCSportsGame(String IBCVendor, int time) throws Exception {
		parentWindowHandle = bDriver.getDriver().getWindowHandle();

		WebElement openIBCSportsGame = bDriver.getDriver().findElement(By.xpath("(//div[contains(text(),'" + IBCVendor + "')])[1]"));
		if (openIBCSportsGame.isDisplayed()) {
			openIBCSportsGame.click();
			rCreate.getExtentTest().info("Clicked " + IBCVendor);

			INW.iterateToGameWindow(time, IBCVendor, parentWindowHandle);
		} else {
			fail = "openIBCSportsGame failed";
			rCreate.getExtentTest().fail(fail);
		}
	}

	public void openVNDPokerGame(String VNDVendor, int time) throws Exception {
		parentWindowHandle = bDriver.getDriver().getWindowHandle();

		WebElement openVNDPokerGame = bDriver.getDriver().findElement(By.xpath("(//div[contains(text(),'" + VNDVendor + "')])[2]"));
		if (openVNDPokerGame.isDisplayed()) {
			openVNDPokerGame.click();
			rCreate.getExtentTest().info("Clicked " + VNDVendor);

			INW.iterateToGameWindow(time, VNDVendor, parentWindowHandle);
		} else {
			fail = "openVNDPokerGame failed";
			rCreate.getExtentTest().fail(fail);
		}
	}

	public void openSGWINLotteryGame(String SGWINVendor, int time) throws Exception {
		parentWindowHandle = bDriver.getDriver().getWindowHandle();

		WebElement openSGWINLotteryGame = bDriver.getDriver().findElement(By.xpath("(//div[contains(text(),'" + SGWINVendor + "')])[1]"));
		if (openSGWINLotteryGame.isDisplayed()) {
			openSGWINLotteryGame.click();
			rCreate.getExtentTest().info("Clicked " + SGWINVendor);

			INW.iterateToGameWindow(time, SGWINVendor, parentWindowHandle);
		} else {
			fail = "openSGWINLotteryGame failed";
			rCreate.getExtentTest().fail(fail);
		}
	}

	public void openIBCESportsGame(String IBCVendor, int time) throws Exception {
		parentWindowHandle = bDriver.getDriver().getWindowHandle();

		WebElement openSGWINLotteryGame = bDriver.getDriver().findElement(By.xpath("(//div[contains(text(),'" + IBCVendor + "')])[1]"));
		if (openSGWINLotteryGame.isDisplayed()) {
			openSGWINLotteryGame.click();
			rCreate.getExtentTest().info("Clicked " + IBCVendor);

			INW.iterateToGameWindow(time, IBCVendor, parentWindowHandle);
		} else {
			fail = "openIBCESportsGame failed";
			rCreate.getExtentTest().fail(fail);
		}
	}

	public void selectMasterFishVendor() throws Exception {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement selectMasterFishVendor = bDriver.getDriver().findElement(By.xpath("//div[@class='content_block active']"));
		if (selectMasterFishVendor.isDisplayed()) {
			String selectMasterFishVendorText = selectMasterFishVendor.getText();
			rCreate.getExtentTest().info(selectMasterFishVendorText + " already selected");
		} else {
			fail = "selectMasterFishVendor failed";
			rCreate.getExtentTest().fail(fail);
		}
	}

	public void openAllListedCQ9FishGame(String CQ9FishGame1, String CQ9FishGame2, String CQ9FishGame3, int time) throws Exception {
		parentWindowHandle = bDriver.getDriver().getWindowHandle();

		ArrayList<String> arraylist = new ArrayList<String>();
		arraylist.add(CQ9FishGame1);
		arraylist.add(CQ9FishGame2);
		arraylist.add(CQ9FishGame3);

		for (int i = 0; i <= 2; i++) {
			bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			String array = arraylist.get(i);

			WebElement openAllListedCQ9FishGame = bDriver.getDriver().findElement(By.xpath("//div[contains(text(),'" + array + "')]"));
			if (openAllListedCQ9FishGame.isDisplayed()) {
				openAllListedCQ9FishGame.click();
				rCreate.getExtentTest().info("Clicked " + array);

				INW.iterateToGameWindow(time, array, parentWindowHandle);
			} else {
				fail = "openCQ9FishGame failed";
				rCreate.getExtentTest().fail(fail);
			}
		}
	}

	public void selectMasterSlotsVendor() throws Exception {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement selectMasterSlotsVendor = bDriver.getDriver().findElement(By.xpath("//div[@class='content_block active']"));
		if (selectMasterSlotsVendor.isDisplayed()) {
			String selectMasterSlotsVendorText = selectMasterSlotsVendor.getText();
			rCreate.getExtentTest().info(selectMasterSlotsVendorText + " already selected");
		} else {
			fail = "selectMasterSlotsVendor failed";
			rCreate.getExtentTest().fail(fail);
		}
	}

	public void selectSubSlotsVendor(String vendorName) throws Exception {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) bDriver.getDriver();
		js.executeScript("window.scrollBy(0,-1000)");
		Thread.sleep(500);
		
		WebElement selectSubSlotsVendor = bDriver.getDriver().findElement(By.xpath("//div[normalize-space()='" + vendorName + "']//span"));
		if (selectSubSlotsVendor.isDisplayed()) {
			builder = new Actions(bDriver.getDriver());
			Action act = builder.moveToElement(selectSubSlotsVendor).build();
			act.perform();
			selectSubSlotsVendor.click();
			rCreate.getExtentTest().info("Clicked " + vendorName);
		} else {
			fail = "selectSubSlotsVendor failed";
			rCreate.getExtentTest().fail(fail);
		}
	}

	public void openAllListedSlotsGame(String slotsGame1, String slotsGame2, String slotsGame3, int time) throws Exception {
		parentWindowHandle = bDriver.getDriver().getWindowHandle();

		ArrayList<String> arraylist = new ArrayList<String>();
		arraylist.add(slotsGame1);
		arraylist.add(slotsGame2);
		arraylist.add(slotsGame3);

		for (int i = 0; i <= 2; i++) {
			bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			String array = arraylist.get(i);

			WebElement openAllListedCQ9FishGame = bDriver.getDriver().findElement(By.xpath("//div[contains(text(),'" + array + "')]"));
			if (openAllListedCQ9FishGame.isDisplayed()) {
				openAllListedCQ9FishGame.click();
				rCreate.getExtentTest().info("Clicked " + array);

				INW.iterateToGameWindow(time, array, parentWindowHandle);
			} else {
				fail = "openAllListedSlotsGame failed";
				rCreate.getExtentTest().fail(fail);
			}
		}
	}
}