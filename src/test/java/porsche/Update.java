package porsche;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Update {
	String holder;
	
	public void setUpdateTotal(String path) {
		
		WebDriver driver;
		driver = PassDriver.getDriver();
		String winhandle = PassDriver.getWinHandle();
		driver.switchTo().window(winhandle);
		holder = driver.findElement(By.xpath(path)).getText();
		System.out.println(holder);
		
	}
	public String getUpdateTotal() {
		return holder;
	}
	
}
