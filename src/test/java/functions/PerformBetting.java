package functions;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.SkipException;

import baseUtilities.ReportCreate;
import baseUtilities.VariableContainer;

public class PerformBetting extends VariableContainer {

	ReportCreate rCreate = new ReportCreate();

	String userDir = System.getProperty("user.dir");

	public void doSlotsBet() throws FindFailed, InterruptedException {
		String imageFilePath = userDir + "\\src\\test\\resources\\images\\slots.sikuli\\";

		Pattern betButton = new Pattern(imageFilePath + "betButton1.1.png");
		Pattern reduceBetAmountButton = new Pattern(imageFilePath + "reduceBetAmountButton.png").similar(0.5);
		Pattern settingButton = new Pattern(imageFilePath + "settingButton.png");
		Pattern betRecordButton = new Pattern(imageFilePath + "betRecordButton.png");
		Pattern closeWinButton = new Pattern(imageFilePath + "closeWinButton.png");

		Screen s = new Screen(0);

		if (s.exists(reduceBetAmountButton) != null) {
			int a = 1;
			while (a <= 5) {
				s.wait(reduceBetAmountButton, 10);
				s.find(reduceBetAmountButton);
				s.click(reduceBetAmountButton);
				a++;
			}
		} else {
			fail = "reduceBetAmountButton failed";
			rCreate.getExtentTest().fail(fail);
		}

		if (s.exists(betButton) != null) {
			s.wait(betButton, 10);
			s.find(betButton);
			s.click(betButton);
		} else {
			fail = "settingButton failed";
			rCreate.getExtentTest().fail(fail);
		}

		Thread.sleep(5000);

		try {
			if (s.exists(closeWinButton) != null) {
				s.wait(betButton, 10);
				s.exists(closeWinButton, 10);
				s.click(closeWinButton);
			} else {
				skip = "Never win skipped";
				rCreate.getExtentTest().skip(skip);
			}
		} catch (FindFailed | SkipException e) {
			System.out.println(e);
		}

		if (s.exists(settingButton) != null) {
			s.wait(settingButton, 10);
			s.find(settingButton);
			s.click(settingButton);
		} else {
			fail = "settingButton failed";
			rCreate.getExtentTest().fail(fail);
		}

		if (s.exists(betRecordButton) != null) {
			s.wait(betRecordButton, 10);
			s.find(betRecordButton);
			s.click(betRecordButton);
		} else {
			fail = "betRecordButton failed";
			rCreate.getExtentTest().fail(fail);
		}
	}

	public void doHeroFishBet() throws FindFailed, InterruptedException {
		String imageFilePath = userDir + "\\src\\test\\resources\\images\\heroFish.sikuli\\";

		Pattern heroFishGameOption = new Pattern(imageFilePath + "heroFishGameOption.png").similar(0.5);
		Pattern tutorialClose = new Pattern(imageFilePath + "tutorialClose.png").similar(0.5);
		Pattern betAreaOneShot = new Pattern(imageFilePath + "betAreaOneShot.png");
		Pattern settingButton = new Pattern(imageFilePath + "settingButton.png");
		Pattern betRecordButton = new Pattern(imageFilePath + "betRecordButton.png");

		Screen s = new Screen(0);

		if (s.exists(heroFishGameOption) != null) {
			s.wait(heroFishGameOption, 10);
			s.find(heroFishGameOption);
			s.click(heroFishGameOption);
		} else {
			fail = "heroFishGameOption failed";
			rCreate.getExtentTest().fail(fail);
		}

		if (s.exists(tutorialClose) != null) {
			s.wait(tutorialClose, 10);
			s.find(tutorialClose);
			s.click(tutorialClose);
		} else {
			fail = "tutorialClose failed";
			rCreate.getExtentTest().fail(fail);
		}

		if (s.exists(betAreaOneShot) != null) {
			s.wait(betAreaOneShot, 10);
			s.find(betAreaOneShot);
			s.click(betAreaOneShot);
		} else {
			fail = "betAreaOneShot failed";
			rCreate.getExtentTest().fail(fail);
		}

		Thread.sleep(5000);
		
		if (s.exists(settingButton) != null) {
			s.wait(settingButton, 10);
			s.find(settingButton);
			s.click(settingButton);
		} else {
			fail = "settingButton failed";
			rCreate.getExtentTest().fail(fail);
		}

		if (s.exists(betRecordButton) != null) {
			s.wait(betRecordButton, 10);
			s.find(betRecordButton);
			s.click(betRecordButton);
		} else {
			fail = "betRecordButton failed";
			rCreate.getExtentTest().fail(fail);
		}
	}
	
	public void doCanonFishBet() throws FindFailed, InterruptedException {
		String imageFilePath = userDir + "\\src\\test\\resources\\images\\canonFish.sikuli\\";

		Pattern canonFishGameOption = new Pattern(imageFilePath + "canonFishGameOption.png").similar(0.5);
		Pattern closeTutorialButton = new Pattern(imageFilePath + "closeTutorialButton.png");
		Pattern closeTutorialButton2 = new Pattern(imageFilePath + "closeTutorialButton2.png");
		Pattern betAreaOneShot = new Pattern(imageFilePath + "betAreaOneShot.png").similar(0.5);
		Pattern settingButton = new Pattern(imageFilePath + "settingButton.png");
		Pattern betRecordButton = new Pattern(imageFilePath + "betRecordButton.png");

		Screen s = new Screen(0);

		if (s.exists(closeTutorialButton) != null) {
			s.wait(closeTutorialButton, 10);
			s.find(closeTutorialButton);
			s.click(closeTutorialButton);
		} else {
			fail = "closeTutorialButton failed";
			rCreate.getExtentTest().fail(fail);
		}
		
		if (s.exists(canonFishGameOption) != null) {
			s.wait(canonFishGameOption, 10);
			s.find(canonFishGameOption);
			s.click(canonFishGameOption);
		} else {
			fail = "heroFishGameOption failed";
			rCreate.getExtentTest().fail(fail);
		}
		
		if (s.exists(closeTutorialButton2) != null) {
			s.wait(closeTutorialButton2, 10);
			s.find(closeTutorialButton2);
			s.click(closeTutorialButton2);
		} else {
			fail = "closeTutorialButton2 failed";
			rCreate.getExtentTest().fail(fail);
		}

		if (s.exists(betAreaOneShot) != null) {
			s.wait(betAreaOneShot, 10);
			s.find(betAreaOneShot);
			s.click(betAreaOneShot);
		} else {
			fail = "betAreaOneShot failed";
			rCreate.getExtentTest().fail(fail);
		}

		Thread.sleep(5000);
		
		if (s.exists(settingButton) != null) {
			s.wait(settingButton, 10);
			s.find(settingButton);
			s.click(settingButton);
		} else {
			fail = "settingButton failed";
			rCreate.getExtentTest().fail(fail);
		}

		if (s.exists(betRecordButton) != null) {
			s.wait(betRecordButton, 10);
			s.find(betRecordButton);
			s.click(betRecordButton);
		} else {
			fail = "betRecordButton failed";
			rCreate.getExtentTest().fail(fail);
		}
	}
	
	public void doLiveBBINBet() throws FindFailed, InterruptedException {
		String imageFilePath = userDir + "\\src\\test\\resources\\images\\liveBBIN.sikuli\\";

		Pattern saveButton = new Pattern(imageFilePath + "saveButton.png");
		Pattern noBetAllowed = new Pattern(imageFilePath + "noBetAllowed.png");
		Pattern betAmount = new Pattern(imageFilePath + "betAmount.png");
		Pattern betPosition = new Pattern(imageFilePath + "betPosition.png");
		Pattern confirmBetButton = new Pattern(imageFilePath + "confirmBetButton.png");
		Pattern betRecordButton = new Pattern(imageFilePath + "betRecordButton.png");

		Screen s = new Screen(0);
		
		if (s.exists(saveButton) != null) {
			s.wait(saveButton, 10);
			s.find(saveButton);
			s.click(saveButton);
		} else {
			skip = "saveButton skipped";
			rCreate.getExtentTest().skip(skip);
		}
		
		if (s.exists(betAmount) != null) {
			s.wait(betAmount, 10);
			s.find(betAmount);
			s.click(betAmount);
		} else {
			fail = "betAmount failed";
			rCreate.getExtentTest().fail(fail);
		}
		
		if(s.exists(noBetAllowed) != null) {
			Thread.sleep(15000);
		} else {
			skip = "noBetAllowed skipped";
			rCreate.getExtentTest().skip(skip);
		}
		
		if (s.exists(betPosition) != null) {
			s.wait(betPosition, 10);
			s.find(betPosition);
			s.click(betPosition);
		} else {
			fail = "betPosition failed";
			rCreate.getExtentTest().fail(fail);
		}

		if (s.exists(confirmBetButton) != null) {
			s.wait(confirmBetButton, 10);
			s.find(confirmBetButton);
			s.click(confirmBetButton);
		} else {
			fail = "confirmBetButton failed";
			rCreate.getExtentTest().fail(fail);
		}

		Thread.sleep(20000);

		if (s.exists(betRecordButton) != null) {
			s.wait(betRecordButton, 10);
			s.find(betRecordButton);
			s.click(betRecordButton);
		} else {
			fail = "betRecordButton failed";
			rCreate.getExtentTest().fail(fail);
		}
	}
}
