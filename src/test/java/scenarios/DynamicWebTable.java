package scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement ele = driver.findElement(By.xpath("//h2[.='Dynamic Web Table']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
		Thread.sleep(2000);
		String name = "Chrome";
		String cpu = driver.findElement(By.xpath("//table[@id='taskTable']/tbody/tr/td[.='"+name+"']/following-sibling::td[contains(.,'%')]")).getText();
		System.out.println(cpu);
		System.out.println("dynamic table");
		System.out.println("print");
		driver.quit();
	
	}
}
