package functions;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class PerformBetting {

	String userDir = System.getProperty("user.dir");
	String imageFolderPath;

	public void performSlotsBetting() throws FindFailed, InterruptedException {
		imageFolderPath = userDir + ".\\src\\test\\resources\\imageBasedSearch\\Slots.sikuli\\";

		Pattern reduceBetAmountButton = new Pattern(imageFolderPath + "reduceBetAmountButton.png");
		Pattern betButton = new Pattern(imageFolderPath + "betButton.png");
		Pattern settingsButton = new Pattern(imageFolderPath + "settingsButton.png");
		Pattern betRecordButton = new Pattern(imageFolderPath + "betRecordButton.png");

		Screen s = new Screen();		

//		REDUCES TO MINIMUM BET AMOUNT FOR CQ9 SLOTS GAME
		int a = 1;
		while (a <= 5) {
			s.wait(reduceBetAmountButton, 10);
			s.find(reduceBetAmountButton);
			s.click(reduceBetAmountButton);
			a++;
		}

		s.wait(betButton, 10);
		s.find(betButton);
		s.click(betButton);
		Thread.sleep(10000);

		s.wait(settingsButton, 10);
		s.find(settingsButton);
		s.click(settingsButton);

		s.wait(betRecordButton, 10);
		s.find(betRecordButton);
		s.click(betRecordButton);
	}
	
	public void performFishBetting() throws FindFailed, InterruptedException {
		imageFolderPath = userDir + ".\\src\\test\\resources\\imageBasedSearch\\Fish.sikuli\\";
		
		Pattern heroFishOption = new Pattern(imageFolderPath + "heroFishOption-1.png");
		Screen s = new Screen();		

//		Thread.sleep(2500);
//		s.wait(heroFishOption, 10);
//		s.find(heroFishOption);
//		s.click(heroFishOption);
		Thread.sleep(1000);
		
		Pattern tutorialAway = new Pattern(imageFolderPath + "tutorialAway.png");
		s.wait(tutorialAway, 10);
		s.find(tutorialAway);
		s.click(tutorialAway);
		
		Pattern autoShootON = new Pattern(imageFolderPath + "autoShootON-1.png");
		s.wait(autoShootON, 10);
		s.find(autoShootON);
		s.click(autoShootON);
		
		Pattern tapToShoot = new Pattern(imageFolderPath + "tapToShoot.png");
		s.wait(tapToShoot, 10);
		s.find(tapToShoot);
		s.click(tapToShoot);
		Thread.sleep(2500);
		
		Pattern autoShootOff = new Pattern(imageFolderPath + "autoShootOff.png");
		s.wait(autoShootOff, 10);
		s.find(autoShootOff);
		s.click(autoShootOff);
		Thread.sleep(5000);

		Pattern settingsButton = new Pattern(imageFolderPath + "settingsButton.png");
		s.wait(settingsButton, 10);
		s.find(settingsButton);
		s.click(settingsButton);

		Pattern betRecordButton = new Pattern(imageFolderPath + "betRecordButton.png");
		s.wait(betRecordButton, 10);
		s.find(betRecordButton);
		s.click(betRecordButton);
	}
}
