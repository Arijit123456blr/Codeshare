package BestWestern.BestWestern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class BestWestern {

	@Test
	public static void Western() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String baseUrl = "https://www.bestwestern.com";
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		try {
			Boolean Status_Login_Link = driver.findElement(By.xpath("//input[@id=\"destination-input\"]"))
					.isDisplayed();
			if (Status_Login_Link) {
				System.out.println("Page Loaded Successfully and Login ink displayed");
				Assert.assertTrue(Status_Login_Link);
			}

			driver.findElement(By.xpath("//input[@id=\"destination-input\"]")).sendKeys("Dallas");
			WebElement element = driver.findElement(By.xpath("(//li[@class='suggestion'])[3]"));

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			driver.findElement(By.xpath("(//button[contains(text(),'Find My Hotel')])[2]")).click();

			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			// change search
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'Change Search')]"))));
			
			driver.findElement(By.xpath("//button[contains(text(),'Change Search')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='destination-input']")).sendKeys("Kolkata");
			WebElement element1 = driver.findElement(By.xpath("(//li[@class='suggestion'])[2]"));

			JavascriptExecutor executor1 = (JavascriptExecutor) driver;
			executor1.executeScript("arguments[0].click();", element1);
			driver.findElement(By.xpath("//button[@id='btn-modify-stay-update']")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
