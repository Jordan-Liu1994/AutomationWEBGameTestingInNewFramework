package functions;

import java.util.concurrent.TimeUnit;

import javax.security.auth.login.FailedLoginException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseUtilities.ReportCreate;
import baseUtilities.VariableContainer;

public class LoginFE extends VariableContainer {

	ReportCreate rCreate = new ReportCreate();

	public void loginOptionButton() throws FailedLoginException {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		wait = new WebDriverWait(bDriver.getDriver(), 15);

		WebElement loginOptionButton = bDriver.getDriver().findElement(By.id("header_login"));
		wait.until(ExpectedConditions.elementToBeClickable(loginOptionButton));

		if (loginOptionButton.isEnabled()) {
			String loginOptionButtonText = loginOptionButton.getText();
			loginOptionButton.click();
			rCreate.getExtentTest().info("Clicked " + loginOptionButtonText);
		} else {
			fail = "loginOptionButton failed";
			rCreate.getExtentTest().fail(fail);
			throw new FailedLoginException(fail);
		}
	}

	public void setUserID(String userID) throws FailedLoginException {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		wait = new WebDriverWait(bDriver.getDriver(), 15);

		WebElement setUserID = bDriver.getDriver().findElement(By.id("username"));
		wait.until(ExpectedConditions.visibilityOf(setUserID));

		if (setUserID.isDisplayed()) {
			String setUserIDText = setUserID.getAttribute(attribute);
			setUserID.clear();
			setUserID.sendKeys(userID);
			rCreate.getExtentTest().info(userID + keyIn + setUserIDText);
		} else {
			fail = "setUserID failed";
			rCreate.getExtentTest().warning(fail);
		}
	}

	public void setPassword(String password) throws FailedLoginException {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		WebElement setPassword = bDriver.getDriver().findElement(By.id("password"));

		if (setPassword.isDisplayed()) {
			String setPasswordText = setPassword.getAttribute(attribute);
			setPassword.clear();
			setPassword.sendKeys(password);
			rCreate.getExtentTest().info(password + keyIn + setPasswordText);
		} else {
			fail = "setPassword failed";
			rCreate.getExtentTest().warning(fail);
		}
	}

	public void setCaptcha(String captcha) throws FailedLoginException {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		try {
			WebElement setCaptcha = bDriver.getDriver().findElement(By.id("captcha_code"));

			if (setCaptcha.isDisplayed()) {
				String setCaptcha_Text = setCaptcha.getAttribute(attribute);
				setCaptcha.clear();
				setCaptcha.sendKeys(captcha);
				rCreate.getExtentTest().info(captcha + keyIn + setCaptcha_Text);
			} else {
				fail = "setCaptcha failed";
				rCreate.getExtentTest().warning(fail);
			}
		} catch (NoSuchElementException e) {
			skip = "setCaptcha skipped";
			rCreate.getExtentTest().skip(skip);
		}
	}

	public void setSliderCaptcha() throws FailedLoginException, InterruptedException {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		try {
			Actions builder = new Actions(bDriver.getDriver());
			WebElement setSliderCaptcha = bDriver.getDriver().findElement(By.xpath("//div[@class='gt_slider_knob gt_show']"));

			if (setSliderCaptcha.isDisplayed()) {
				builder.moveToElement(setSliderCaptcha).clickAndHold().moveByOffset(100, 0).release().build().perform();
				rCreate.getExtentTest().info("Dragged captcha slider to the right by 100 pixels");

				Thread.sleep(1000);
				builder.moveByOffset(300, 0).build().perform();
				Thread.sleep(2500);
			} else {
				fail = "setSliderCaptcha failed";
				rCreate.getExtentTest().warning(fail);
			}
		} catch (NoSuchElementException e) {
			skip = "setSliderCaptcha skipped";
			rCreate.getExtentTest().skip(skip);
		}
	}

	public void selectLoginButton() throws FailedLoginException, InterruptedException {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		WebElement selectLoginButton = bDriver.getDriver().findElement(By.id("login_popup_btn"));

		if (selectLoginButton.isEnabled()) {
			String selectLoginButtonText = selectLoginButton.getText();
			selectLoginButton.click();
			rCreate.getExtentTest().info("Clicked " + selectLoginButtonText);
		} else {
			fail = "selectLoginButton failed";
			rCreate.getExtentTest().fail(fail);
			throw new FailedLoginException(fail);
		}
	}

	public void verifyLogIn(String userID) throws FailedLoginException, InterruptedException {
		bDriver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		WebElement userIDName = bDriver.getDriver().findElement(By.xpath("(//a[contains(text(),'" + userID + "')])[1]"));

		if (userIDName.isDisplayed()) {
			rCreate.getExtentTest().info("Account " + userID + " verified");
		} else {
			fail = "verifyLogIn failed";
			rCreate.getExtentTest().warning(fail);
		}
	}
}