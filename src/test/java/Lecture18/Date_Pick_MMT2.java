package Lecture18;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Date_Pick_MMT2 {
	public static WebDriver driver;
	public WebDriverWait wait;

	@Test
	public void calendarNavigation() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		//WebElement iframeElement = driver.findElement(By.name("notification-frame-~55850c31"));
		driver.switchTo().frame(3);
		driver.findElement(By.xpath("//*[@id='webklipper-publisher-widget-container-notification-close-div']/i")).click();
		driver.switchTo().parentFrame();
		WebElement calendar = driver.findElement(By.xpath("//*[@id = 'datepicker']"));
		calendar.click();
		System.out.println(calendar);
		wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("//*[@id='departure']"))).click();
		selectDateCalendar("22","December","2023");
	}

	public void selectDateCalendar(String calendarDay, String calendarMonth, String calendarYear) throws Exception {
		if(Integer.parseInt(calendarDay)>31) {
		System.out.println("Invalid date because days of month should be less than 31");	
		return;
		}
		if(Integer.parseInt(calendarDay)>29 && calendarMonth.equals("February")) {
			System.out.println("Invalid date because days of February should be less than 29");	
			return;
		}
		
		
		String monthYear = driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println("The currrent month and year is  " + "---->" + monthYear);
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//*[@class = 'ui-icon ui-icon-circle-triangle-e']")).click();
		//monthYear = driver.findElement(By.className("ui-datepicker-title")).getText();
		//System.out.println("The next month and year is  " + "---->" + monthYear);
		// To split the string we use split keyword
		
		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];
		
		while (!(month.equals(calendarMonth) && year.equals(calendarYear))) {
			driver.findElement(By.xpath("//a[@title  = 'Next']")).click();
			Thread.sleep(500);
			monthYear = driver.findElement(By.className("ui-datepicker-title")).getText();
			month = monthYear.split(" ")[0];
			year = monthYear.split(" ")[1];
		}
		Thread.sleep(1000);
		String dynamicXpath ="//td[@data-handler='selectDay']/a[text()='" + calendarDay + "']";
;
		driver.findElement(By.xpath(dynamicXpath)).click();

	}
		}

