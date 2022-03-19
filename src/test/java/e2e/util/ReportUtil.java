package e2e.util;

import e2e.context.WebDriverContext;
import e2e.report.ExtentReportManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.relevantcodes.extentreports.LogStatus;

/**
 * The Class is responsible for Reporting
 *
 * @author Aarthy
 */
public class ReportUtil {

	/**
	 * Adds the screen shot.
	 *
	 * @param message the message
	 */
	public static void addScreenShot(String message) {
		String base64Image = "data:image/png;base64,"
				+ ((TakesScreenshot) WebDriverContext.getDriver()).getScreenshotAs(OutputType.BASE64);
		ExtentReportManager.getCurrentTest().log(LogStatus.INFO, message,
				ExtentReportManager.getCurrentTest().addBase64ScreenShot(base64Image));
	}

	/**
	 * Adds the screen shot.
	 *
	 * @param status  the status
	 * @param message the message
	 */
	public static void addScreenShot(LogStatus status, String message) {
		String base64Image = "data:image/png;base64,"
				+ ((TakesScreenshot) WebDriverContext.getDriver()).getScreenshotAs(OutputType.BASE64);
		ExtentReportManager.getCurrentTest().log(status, message,
				ExtentReportManager.getCurrentTest().addBase64ScreenShot(base64Image));
	}

	public static void logMessage(String message, String details) {
		ExtentReportManager.getCurrentTest().log(LogStatus.INFO, message, details);
	}

	public static void logMessage(LogStatus status, String message, String details) {
		ExtentReportManager.getCurrentTest().log(status, message, details);
	}
}
