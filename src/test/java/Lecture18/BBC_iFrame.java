package Lecture18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BBC_iFrame {
	WebDriver driver;
	@Test
	public void findIframes() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bbc.com");
		Thread.sleep(2000);
		//List<WebElement> iframe = driver.findElements(By.xpath("iframe"));
		//System.out.println(iframe.size());
		//driver.switchTo().frame(1);
		driver.findElement(By.xpath("//*[@id = 'close']")).click();

}
}