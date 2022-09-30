package functions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.security.auth.login.FailedLoginException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;

import baseUtilities.IterateNextWindows;
import baseUtilities.ReportCreate;
import baseUtilities.VariableContainer;

public class CategoryVendorAndGame extends VariableContainer {

	ReportCreate rCreate = new ReportCreate();
	IterateNextWindows iterateNW = new IterateNextWindows();
	PerformBetting performB = new PerformBetting();
	InGameBetTimezoneAndBetDetails inGameBTZABD = new InGameBetTimezoneAndBetDetails();

	Actions builder;

//	FOR ALL CATEGORIES
	public void selectCategory(String categoryNumber) throws FailedLoginException, InterruptedException {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement selectCategory = bDriver.getDriver().findElement(By.xpath("(//div[@class='header_menu_item'])[" + categoryNumber + "]"));

		if (selectCategory.isDisplayed()) {
			String selectCategoryText = selectCategory.getText();
			Actions builder = new Actions(bDriver.getDriver());
			builder.moveToElement(selectCategory).click().build().perform();
			rCreate.getExtentTest().info("Clicked " + selectCategoryText);
		} else {
			fail = "selectCategory failed";
			rCreate.getExtentTest().fail(fail);
			throw new FailedLoginException(fail);
		}
	}

//	ONLY FOR SLOTS
	public void selectVendors(String vendorName) throws FailedLoginException {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement selectVendors = bDriver.getDriver().findElement(By.xpath("//div[normalize-space()='" + vendorName + "']//span"));

		if (selectVendors.isDisplayed()) {
			String selectVendorsText = selectVendors.getText();
			Actions builder = new Actions(bDriver.getDriver());
			builder.moveToElement(selectVendors).click().build().perform();
			rCreate.getExtentTest().info("Clicked " + selectVendorsText);
		} else {
			fail = "selectVendors failed";
			rCreate.getExtentTest().fail(fail);
		}
	}

	public void selectFishVendors() throws FailedLoginException {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement selectFishVendors = bDriver.getDriver().findElement(By.xpath("//div[@class='content_block active']//span"));

		if (selectFishVendors.isDisplayed()) {
			String selectFishVendorsText = selectFishVendors.getText();
			Actions builder = new Actions(bDriver.getDriver());
			builder.moveToElement(selectFishVendors).click().build().perform();
			rCreate.getExtentTest().info("Clicked " + selectFishVendorsText);
		} else {
			fail = "selectVendors failed";
			rCreate.getExtentTest().fail(fail);
		}
	}

	public void selectSlotsGame(String slotsVendor, String gameName1, String gameName2, int numberOfGamesToTest) throws Exception {
		parentWindow = bDriver.getDriver().getWindowHandle();

		ArrayList<String> gameList = new ArrayList<String>();
		gameList.add(gameName1);
		gameList.add(gameName2);

		for (int i = 0; i <= numberOfGamesToTest; i++) {
			bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			String game = gameList.get(i);
			WebElement selectSlotsGame = bDriver.getDriver().findElement(By.xpath("(//div[@class='title'][contains(text(),'" + game + "')])[1]"));

			if (selectSlotsGame.isDisplayed()) {
				Actions builder = new Actions(bDriver.getDriver());
				builder.moveToElement(selectSlotsGame).click().build().perform();

				iterateNW.iterateToGameWindow();
				iterateNW.maximizeWindow();
				Thread.sleep(10000);
				performB.doSlotsBet();
				Thread.sleep(5000);
				iterateNW.iterateToBetRecordWindow();
				Thread.sleep(2500);
				inGameBTZABD.selectTimeZoneOption();
				inGameBTZABD.selectTimezone();
				inGameBTZABD.selectTodayDate();
				inGameBTZABD.goToBetDetails(game);
				Thread.sleep(2500);
				iterateNW.iterateToBetDetailsWindow();
				Thread.sleep(2500);
				iterateNW.screenShotFinalWindow(game);
				iterateNW.closeNewWindow();
				Thread.sleep(2500);
				iterateNW.backToMainWindow(parentWindow);
			} else {
				fail = "selectSlotsGame failed";
				rCreate.getExtentTest().fail(fail);
			}
		}
	}

	public void selectFishGame(String slotsVendor, String gameName1, String gameName2, int numberOfGamesToTest) throws Exception {
		parentWindow = bDriver.getDriver().getWindowHandle();

		ArrayList<String> gameList = new ArrayList<String>();
		gameList.add(gameName1);
		gameList.add(gameName2);

		for (int i = 0; i <= numberOfGamesToTest; i++) {
			bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			String game = gameList.get(i);
			WebElement selectFishGame = bDriver.getDriver().findElement(By.xpath("//div[contains(text(),'" + game + "')]"));

			if (selectFishGame.isDisplayed()) {
				Actions builder = new Actions(bDriver.getDriver());
				builder.moveToElement(selectFishGame).click().build().perform();

				iterateNW.iterateToGameWindow();
				iterateNW.maximizeWindow();
				Thread.sleep(10000);
				if (game.equalsIgnoreCase(gameName1)) {
					performB.doHeroFishBet();
				}
				if (game.equalsIgnoreCase(gameName2)) {
					performB.doCanonFishBet();
				}
				Thread.sleep(5000);
				iterateNW.iterateToBetRecordWindow();
				Thread.sleep(2500);
				inGameBTZABD.selectTimeZoneOption();
				inGameBTZABD.selectTimezone();
				inGameBTZABD.selectTodayDate();
				inGameBTZABD.goToBetDetails(game);
				Thread.sleep(2500);
				iterateNW.iterateToBetDetailsWindow();
				Thread.sleep(2500);
				iterateNW.screenShotFinalWindow(game);
				iterateNW.closeNewWindow();
				Thread.sleep(2500);
				iterateNW.backToMainWindow(parentWindow);
			} else {
				fail = "selectFishGame failed";
				rCreate.getExtentTest().fail(fail);
			}
		}
	}

	String parentWindow;
	
	public void selectLiveVendors(String vendorName) throws FailedLoginException {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement selectLiveVendors = bDriver.getDriver().findElement(By.xpath("//div[@class='more_game_item']//div//div[contains(text(),'" + vendorName + "')]"));
		parentWindow = bDriver.getDriver().getWindowHandle();
		
		if (selectLiveVendors.isDisplayed()) {
			String selectLiveVendorsText = selectLiveVendors.getText();
			Actions builder = new Actions(bDriver.getDriver());
			builder.moveToElement(selectLiveVendors).click().build().perform();
			rCreate.getExtentTest().info("Clicked " + selectLiveVendorsText);
		} else {
			fail = "selectLiveVendors failed";
			rCreate.getExtentTest().fail(fail);
		}
	}
	
	public void selectLiveBBINGame() throws FailedLoginException, InterruptedException {
		iterateNW.iterateToGameWindow();
		iterateNW.maximizeWindow();
		Thread.sleep(5000);
		
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement selectLiveBBINGame = bDriver.getDriver().findElement(By.xpath("//a[@class='nav-btn cur-btn']"));

		if (selectLiveBBINGame.isDisplayed()) {
			Actions builder = new Actions(bDriver.getDriver());
			builder.moveToElement(selectLiveBBINGame).build().perform();
			rCreate.getExtentTest().info("Hovered over 21 black jack");
		} else {
			fail = "selectLiveBBINGame failed";
			rCreate.getExtentTest().fail(fail);
		}
	}
	
	public void selectLiveBBINGameOption() throws FailedLoginException, InterruptedException {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement selectLiveBBINGameOption = bDriver.getDriver().findElement(By.xpath("(//img[@role='presentation'])[4]"));
		
		if (selectLiveBBINGameOption.isDisplayed()) {
			Actions builder = new Actions(bDriver.getDriver());
			builder.moveToElement(selectLiveBBINGameOption).build().perform();
			rCreate.getExtentTest().info("Hovered over game option");
		} else {
			fail = "selectLiveBBINGameOption failed";
			rCreate.getExtentTest().fail(fail);
		}
		
		WebElement selectLiveBBINGameOptionChoice = bDriver.getDriver().findElement(By.xpath("(//a[@role='button'][normalize-space()='A'])[1]"));
		
		if (selectLiveBBINGameOptionChoice.isDisplayed()) {
			Actions builder = new Actions(bDriver.getDriver());
			builder.moveToElement(selectLiveBBINGameOptionChoice).click().build().perform();
			rCreate.getExtentTest().info("Hovered over game option choice");
		} else {
			fail = "selectLiveBBINGameOptionChoice failed";
			rCreate.getExtentTest().fail(fail);
		}

	}
	
	public void selectLiveBBINPlaceABet(String vendorName) throws Exception {
		iterateNW.iterateToBetRecordWindow();
		iterateNW.maximizeWindow();
		Thread.sleep(15000);
		performB.doLiveBBINBet();
		Thread.sleep(2500);
		iterateNW.iterateToBetDetailsWindow();
		iterateNW.screenShotFinalWindow(vendorName);
		iterateNW.closeNewWindow();
	}
}