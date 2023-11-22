package Lecture18;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Wait_Types_Selenium {
	public static WebDriver driver;
	public static WebDriverWait wait;
	@Test
	public void differentWaitTypes() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.tutorialsninja.com/demo/");

		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My Account"))).click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login"))).click();
		
		
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
		
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type = 'submit']"))).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
	}

}
