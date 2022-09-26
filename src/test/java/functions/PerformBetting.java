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
	String imageFolderPath;

	public void reduceBetAmountSlots() throws FindFailed {
		imageFolderPath = userDir + ".\\src\\test\\resources\\imageBasedSearch\\Slots.sikuli\\";

		Pattern reduceBetAmountButton = new Pattern(imageFolderPath + "reduceBetAmountButton.png").similar(0.5);

		Screen s = new Screen();

//		REDUCES TO MINIMUM BET AMOUNT FOR CQ9 SLOTS GAME
		int a = 1;
		while (a <= 5) {
			s.wait(reduceBetAmountButton, 10);
			s.find(reduceBetAmountButton);
			s.click(reduceBetAmountButton);
			a++;
		}
	}

	public void betSlots() throws FindFailed, InterruptedException {
		imageFolderPath = userDir + ".\\src\\test\\resources\\imageBasedSearch\\Slots.sikuli\\";

		Pattern betButton = new Pattern(imageFolderPath + "betButton.png").similar(0.5);
		Screen s = new Screen();

		s.wait(betButton, 10);
		s.find(betButton);
		s.click(betButton);
		Thread.sleep(5000);
	}

	public void closeWinSlots() throws FindFailed, InterruptedException {
		imageFolderPath = userDir + ".\\src\\test\\resources\\imageBasedSearch\\Slots.sikuli\\";

		try {
			Pattern closeWinButton = new Pattern(imageFolderPath + "closeWinButton.png").similar(0.8);
			Screen s = new Screen();

			if (s.has(closeWinButton)) {
				s.exists(closeWinButton, 10);
				s.click(closeWinButton);
				Thread.sleep(2500);
			}
		} catch (FindFailed | SkipException e) {
			skip = "Never win skipped";
			rCreate.getExtentTest().skip(skip);
		}
	}

	public void settingsSlots() throws FindFailed {
		imageFolderPath = userDir + ".\\src\\test\\resources\\imageBasedSearch\\Slots.sikuli\\";

		Pattern settingsButton = new Pattern(imageFolderPath + "settingsButton.png").similar(0.5);
		Screen s = new Screen();

		s.wait(settingsButton, 10);
		s.find(settingsButton.similar(0.3));
		s.click(settingsButton);
	}

	public void betRecordSlots() throws FindFailed {
		imageFolderPath = userDir + ".\\src\\test\\resources\\imageBasedSearch\\Slots.sikuli\\";

		Pattern betRecordButton = new Pattern(imageFolderPath + "betRecordButton.png").similar(0.5);
		Screen s = new Screen();

		s.wait(betRecordButton, 10);
		s.find(betRecordButton);
		s.click(betRecordButton);
	}
}
