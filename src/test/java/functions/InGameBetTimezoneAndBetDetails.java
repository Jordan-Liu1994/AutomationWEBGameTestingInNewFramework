package functions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseUtilities.ReportCreate;
import baseUtilities.VariableContainer;

public class InGameBetTimezoneAndBetDetails extends VariableContainer {

	ReportCreate rCreate = new ReportCreate();

	public void selectTimeZoneOption() throws InterruptedException {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement timeZoneOption = bDriver.getDriver().findElement(By.xpath("//p[@class='ga_timezone']"));
		if (timeZoneOption.isDisplayed()) {
			timeZoneOption.click();
		} else {
			fail = "selectTimeZoneOption failed";
			rCreate.getExtentTest().fail(fail);
		}
	}

	public void selectTimezone() throws InterruptedException {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement selectTimezone = bDriver.getDriver().findElement(By.xpath("//span[@class='ga_timezone_beijing']"));
		if (selectTimezone.isDisplayed()) {
			selectTimezone.click();
		} else {
			fail = "selectTimezone failed";
			rCreate.getExtentTest().fail(fail);
		}
	}

	public void selectCustomDate() throws InterruptedException {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(5000);
		WebElement selectCustomDate = bDriver.getDriver().findElement(By.xpath("//span[@class='ga_quicksearch_custom']"));
		if (selectCustomDate.isDisplayed()) {
			selectCustomDate.click();
		} else {
			fail = "selectCustomDate failed";
			rCreate.getExtentTest().fail(fail);
		}
	}

	public void selectPast6Days(String pastDate) throws InterruptedException {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(1000);
		WebElement selectPast6Days = bDriver.getDriver().findElement(By.xpath("(//div[@class='text ga_customdate_" + pastDate + "'])[1]"));
		if (selectPast6Days.isDisplayed()) {
			selectPast6Days.click();
		} else {
			fail = "selectPast6Days failed";
			rCreate.getExtentTest().fail(fail);
		}
	}

	public void selectTodayDate() throws InterruptedException {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(5000);
		WebElement selectTodayDate = 	bDriver.getDriver().findElement(By.xpath("//span[@class='ga_quicksearch_today']"));
		if (selectTodayDate.isDisplayed()) {
			selectTodayDate.click();
		} else {
			fail = "selectTodayDate failed";
			rCreate.getExtentTest().fail(fail);
		}
	}
	
	public void goToBetDetails(String gameName) throws InterruptedException {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement goToBetDetails = bDriver.getDriver().findElement(By.xpath("//div[contains(text(),'" + gameName + "')]"));
		if (goToBetDetails.isDisplayed()) {
			goToBetDetails.click();
		} else {
			fail = "goToBetDetails failed";
			rCreate.getExtentTest().fail(fail);
		}
	}
}
