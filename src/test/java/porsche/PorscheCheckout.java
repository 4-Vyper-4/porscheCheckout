package porsche;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PorscheCheckout {
	WebDriver driver;
	String winHandleBefore;
	String winHandleAfter;
	String currentWinhandle;
	String basePriceConfirm;
	Update up = new Update();
	Parameters pa = new Parameters();
	
	@BeforeClass
	public void setupClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

	@Test
	public void testA() throws InterruptedException {
		driver.get("https://www.porsche.com/usa/modelstart/");
		driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div[2]/a[1]/div/div[2]/div/span")).click();
		pa.setBasePrice(driver.findElement(By.xpath("//*[@id=\"m982120\"]/div[1]/div[2]/div[2]")).getText());
		winHandleBefore = driver.getWindowHandle();
		driver.findElement(By.xpath("//*[@id=\"m982120\"]/div[2]/div/a/span")).click();

		Thread.sleep(3000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		winHandleAfter = driver.getWindowHandle();
		driver.switchTo().window(winHandleBefore);
		driver.close();
		driver.switchTo().window(winHandleAfter);
		basePriceConfirm = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[1]/div[2]")).getText();
		basePriceConfirm = TextTrim.TextTrimmer(basePriceConfirm);
		basePriceConfirm = TextTrim.TextTrimmer(basePriceConfirm);
		long basePriceConfirmL = Long.parseLong(basePriceConfirm);
		PassDriver.setDriver(driver);
		PassDriver.setWinHandle((driver.getWindowHandle()));
		Assert.assertEquals(basePriceConfirmL, pa.getBasePrice());
		
	}

	@Test
	public void testB() {
		driver = PassDriver.getDriver();
		currentWinhandle = PassDriver.getWinHandle();
		driver.switchTo().window(currentWinhandle);
		pa.setEquipmentPrice(driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]")).getText());		
		Assert.assertEquals(pa.getEquipmentPrice(), 0);
		
	}

	@Test
	public void testC() {
		driver = PassDriver.getDriver();
		currentWinhandle = PassDriver.getWinHandle();
		driver.switchTo().window(currentWinhandle);
		pa.setTotal(driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[4]/div[2]")).getText());
		pa.setShipCost(driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[3]/div[2]")).getText());
		Assert.assertEquals((pa.getShipCost() + pa.getBasePrice()), pa.getTotal());
		
	}

	@Test
	public void testD() {
		
		driver = PassDriver.getDriver();
		currentWinhandle = PassDriver.getWinHandle();
		driver.switchTo().window(currentWinhandle);
		driver.findElement(By.xpath("//*[@id=\"s_exterieur_x_FJ5\"]/span")).click();
		pa.setColor(driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]")).getText());
		pa.setEquipmentPrice(driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]")).getText());
		Assert.assertEquals(pa.getEquipmentPrice(), pa.getColor());
		pa.setTotal(driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[4]/div[2]")).getText());
		Assert.assertEquals((pa.getShipCost() + pa.getBasePrice() + pa.getEquipmentPrice()), pa.getTotal());
	}

	@Test
	public void testE() {
		driver = PassDriver.getDriver();
		currentWinhandle = PassDriver.getWinHandle();
		driver.switchTo().window(currentWinhandle);
		driver.findElement(By.xpath("//*[@id=\"s_exterieur_x_MXRD\"]/span/span")).click();
		pa.setWheel(driver.findElement(By.xpath("(//li[@data-price ='$3,750'])")).getAttribute("data-price").toString());
		pa.setEquipmentPrice(driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]")).getText());
		Assert.assertEquals((pa.getColor() + pa.getWheel()), pa.getEquipmentPrice());	
	}
	
	@Test
	public void testF() {
		
		driver = PassDriver.getDriver();
		currentWinhandle = PassDriver.getWinHandle();
		driver.switchTo().window(currentWinhandle);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1100)", "");
		driver.findElement(By.xpath("//*[@id=\"s_interieur_x_PP06\"]")).click();
		pa.setSeats(driver.findElement(By.xpath("//*[@id=\"seats_73\"]/div[2]/div[1]/div[3]/div")).getText());
		pa.setEquipmentPrice(driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]")).getText());
		Assert.assertEquals((pa.getColor() + pa.getWheel() + pa.getSeats()), pa.getEquipmentPrice());
		pa.setTotal(driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[4]/div[2]")).getText());
		Assert.assertEquals((pa.getBasePrice() + pa.getEquipmentPrice() + pa.getShipCost()), pa.getTotal());
	}

	@Test
	public void testG() throws InterruptedException {
		
		driver = PassDriver.getDriver();
		currentWinhandle = PassDriver.getWinHandle();
		driver.switchTo().window(currentWinhandle);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)", "");
		driver.findElement(By.xpath("//*[@id=\"IIC_subHdl\"]")).click();
		jse.executeScript("window.scrollBy(0,200)", "");
		driver.findElement(By.xpath("//*[@id=\"vs_table_IIC_x_PEKH_x_c04_PEKH_x_shorttext\"]")).click();
		pa.setInterior(driver.findElement(By.xpath("//*[@id=\"vs_table_IIC_x_PEKH\"]/div[1]/div[2]/div")).getText());
		pa.setEquipmentPrice(driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]")).getText());
		pa.setTotal(driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[4]/div[2]")).getText());
		Assert.assertEquals((pa.getColor() + pa.getSeats() + pa.getWheel() + pa.getInterior()), pa.getEquipmentPrice());
		Assert.assertEquals((pa.getBasePrice() + pa.getEquipmentPrice() + pa.getShipCost()), pa.getTotal());
	}
	
	@Test
	public void testH() {
		driver = PassDriver.getDriver();
		currentWinhandle = PassDriver.getWinHandle();
		driver.switchTo().window(currentWinhandle);
		driver.findElement(By.xpath("//*[@id=\"IMG_subHdl\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"vs_table_IMG_x_M250_x_c11_M250\"]")).click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,100)", "");
		driver.findElement(By.xpath("//*[@id=\"vs_table_IMG_x_M450_x_c91_M450\"]")).click();
		pa.setEquipmentPrice(driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]")).getText());
		pa.setPccb(driver.findElement(By.xpath("//*[@id=\"vs_table_IMG_x_M450\"]/div[1]/div[2]/div")).getText());
		pa.setPdk(driver.findElement(By.xpath("//*[@id=\"vs_table_IMG_x_M250\"]/div[1]/div[2]/div")).getText());
		Assert.assertEquals((pa.getColor()+pa.getInterior()+pa.getPccb()+pa.getPdk()+pa.getSeats()+ pa.getWheel()), pa.getEquipmentPrice());
	}
	
	@Test
	public void testI() {
		driver = PassDriver.getDriver();
		currentWinhandle = PassDriver.getWinHandle();
		driver.switchTo().window(currentWinhandle);
		pa.setTotal(driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[4]/div[2]")).getText());
		Assert.assertEquals((pa.getBasePrice()+pa.getEquipmentPrice()+pa.getShipCost()), pa.getTotal());
		
	}
	
	
}
