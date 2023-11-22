package Lecture18;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Mouse_Action_iFrames {
	public WebDriver driver;
	public Actions action;

	@Test
	public void MouseKeyboardIframes() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/draggable");
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());

		for (int i = 0; i < frames.size(); i++) {
			System.out.println(frames.get(i).getText());
		}
		driver.switchTo().frame(0);
		WebElement target = driver.findElement(By.id("draggable"));
		action = new Actions(driver);
		action.clickAndHold(target).dragAndDropBy(target, 100, 200).build().perform();

	}

	@Test
	public void mouseDropable() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable");
		driver.switchTo().frame(0);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement destination = driver.findElement(By.id("droppable"));
		action.dragAndDrop(source, destination).build().perform();
	}

	@Test
	public void keyBoardOperations() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable");
		driver.switchTo().frame(0);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement destination = driver.findElement(By.id("droppable"));
		action.dragAndDrop(source, destination).build().perform();
}}