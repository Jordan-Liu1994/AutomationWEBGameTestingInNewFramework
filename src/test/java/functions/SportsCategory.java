package functions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.security.auth.login.FailedLoginException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import baseUtilities.IterateNextWindows;
import baseUtilities.ReportCreate;
import baseUtilities.VariableContainer;

public class SportsCategory extends VariableContainer {

	ReportCreate rCreate = new ReportCreate();
	IterateNextWindows INW = new IterateNextWindows();

	WebDriverWait wait;
	String fail;
	String skip;
	String res;
	String parentWindowHandle;
	Set<String> nextWindowHandle;

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

		WebElement openIndividualSportsVendor = bDriver.getDriver().findElement(By.xpath("(//div[contains(text(),'" + VNDVendor + "')])[2]"));
		if (openIndividualSportsVendor.isDisplayed()) {
			openIndividualSportsVendor.click();
			rCreate.getExtentTest().info("Clicked " + VNDVendor);

			INW.iterateToGameWindow(time, VNDVendor, parentWindowHandle);
		} else {
			fail = "openVNDSportsGame failed";
			rCreate.getExtentTest().fail(fail);
		}
	}

	public void openIBCSportsGame(String IBCVendor, int time) throws Exception {
		parentWindowHandle = bDriver.getDriver().getWindowHandle();

		WebElement openIndividualSportsVendor = bDriver.getDriver().findElement(By.xpath("(//div[contains(text(),'" + IBCVendor + "')])[1]"));
		if (openIndividualSportsVendor.isDisplayed()) {
			openIndividualSportsVendor.click();
			rCreate.getExtentTest().info("Clicked " + IBCVendor);

			INW.iterateToGameWindow(time, IBCVendor, parentWindowHandle);
		} else {
			fail = "openIBCSportsGame failed";
			rCreate.getExtentTest().fail(fail);
		}
	}
}