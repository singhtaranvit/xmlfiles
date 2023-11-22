package Lecture18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class IFrame_Find {
	public WebDriver driver;
	public WebDriverWait wait;

	@Test
	public void findIframes() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com");
		Thread.sleep(2000);
		WebElement iframe3 = driver.findElement(By.xpath("//*[@title ='notification-frame-~55850c31']"));
		driver.switchTo().frame(iframe3);
		driver.findElement(By.xpath("//*[@id='webklipper-publisher-widget-container-notification-close-div']")).click();
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//*[@id='SW']/div[1]/div[2]/div[2]/div/section/span")).click();
		WebElement departure = driver
				.findElement(By.xpath("//*[@id=\'root\']/div/div[2]/div/div/div/div[2]/div[1]/div[3]/label"));
		departure.click();
		String monthYear = driver.findElement(By.xpath("//*[@class='DayPicker-Caption']")).getText();
		System.out.println("Current month and year is " + "----->" + monthYear);
		selectDateCalendar("Tue","January", "2", "2024");
	}

	public void selectDateCalendar(String calendarDay ,String calendarMonth, String calendarDate,  String calendarYear)
			throws Exception {
		if (Integer.parseInt(calendarDate) > 31) {
			System.out.println("Invalid date because days of month should be less than 31");
			return;
		}
		if (Integer.parseInt(calendarDate) > 29 && calendarMonth.equals("February")) {
			System.out.println("Invalid date because days of February should be less than 29");
			return;
		}
		Thread.sleep(500);
		String monthYear = driver.findElement(By.xpath("//*[@class='DayPicker-Caption']")).getText();
		System.out.println("Current month and year is " + "----->" + monthYear);
		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];

		while (!(month.equals(calendarMonth) && year.equals(calendarYear))) {
			driver.findElement(By.xpath("//*[@aria-label = 'Next Month']")).click();
			Thread.sleep(500);
			monthYear = driver.findElement(By.xpath("//*[@class='DayPicker-Caption']")).getText();
			month = monthYear.split(" ")[0];
			year = monthYear.split(" ")[1];
		}
		System.out.println("Current month and year is " + "----->" + monthYear);
		Thread.sleep(1000);
		String dynamicXpath = "//*[@aria-label='" + calendarDay + " " + calendarMonth + " " + calendarDate + " " + calendarYear + "']";
		driver.findElement(By.xpath(dynamicXpath)).click();

	}

}
// WebElement iframe1 = driver.findElement
// (By.xpath("//*[@title='webengage-engagement-callback-frame']"));
// driver.switchTo().frame(iframe1);
// WebElement iframe2 = driver.findElement
// (By.xpath("//*[@title='_we_wk_data_store']"));
// driver.switchTo().frame(iframe2);
// driver.findElement(By.xpath()).click();
// String monthYear1 =
// driver.findElement(By.xpath("//*[@class='DayPicker-Caption']")).getText();
// System.out.println("Current month and year is " + "----->" + monthYear1);

// *[@aria-label='Tue Dec 05 2023']
// String dynamicXPath = "//*[@aria-label='" +day + " " + month + " " + date + "
// " + year + "']";
