package Lecture18;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Web_Tables {
public WebDriver driver;

@Test
public void dataTypes() {
	String companyName = "Hubtown";
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://money.rediff.com/gainers");
	List<WebElement> Header = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));
	System.out.println(Header.size());
	for(int i = 0; i< Header.size() ; i++) {
		System.out.print(Header.get(i).getText() + "\t");
	}System.out.println("\n ");
	List<WebElement> companyList = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
	List<WebElement> currentPrice = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[4]"));
	
	for(int i = 0; i< companyList.size() ; i++) {
		if(companyName.equalsIgnoreCase(companyList.get(i).getText())) {
			System.out.println(companyList.get(i).getText() + "-------------------------->"  + currentPrice.get(i).getText());
		}
	}
	
}
}
