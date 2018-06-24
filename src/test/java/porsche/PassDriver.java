package porsche;

import org.openqa.selenium.WebDriver;

public class PassDriver {
	
	static WebDriver driver;
	static String winHandle;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver d) {
		driver = d;
	}

	public static String getWinHandle() {
		return winHandle;
	}

	public static void setWinHandle(String winHandle) {
		PassDriver.winHandle = winHandle;
	}
	
	
	
}
