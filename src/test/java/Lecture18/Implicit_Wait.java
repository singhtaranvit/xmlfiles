package Lecture18;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Implicit_Wait {
	public static WebDriver driver;
	public static WebDriverWait wait;

	@Test
	public void differentWaitTypes() {

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
		driver.get("https://www.tutorialsninja.com/demo/");
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");

		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");

	}
}