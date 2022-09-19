package baseUtilities;

import org.testng.ITestResult;

public class ResultListener extends VariableContainer {

	TakeScreenShot takeSS = new TakeScreenShot();
	ReportCreate rCreate = new ReportCreate();
	String res;
	
	public void logCaseStatus(ITestResult result) throws Exception {
		String resultOfCaseStatus = result.getName();
		if (result.getStatus() == ITestResult.SUCCESS) {
			rCreate.getExtentTest().pass("Step = " + resultOfCaseStatus + " is passed!");
		}
		if (result.getStatus() == ITestResult.SKIP) {
			rCreate.getExtentTest().skip("Step = " + resultOfCaseStatus + " is skipped!");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			rCreate.getExtentTest().fail("Step = " + resultOfCaseStatus + " is failed!");
			res = resultOfCaseStatus + " fail.png";
			takeSS.takeSnapShot(res);
			rCreate.getExtentTest().addScreenCaptureFromPath(takeSS.screenShotPathExtent() + res, resultOfCaseStatus);
		}
	}
}