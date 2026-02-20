package scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginationScenarioAutomationPracticeBlogSpot {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String Product="Soundbar";
		boolean flag=false;
		List<WebElement> pages = driver.findElements(By.xpath("//ul[@id='pagination']/li"));
		int count=pages.size();

		for(int i=1;i<=count;i++) {

			//click on the page
			driver.findElement(By.xpath("//ul[@id='pagination']/li[" + i + "]/a")).click();

			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));
			for(WebElement row:rows)
			{
				String name = row.findElement(By.xpath(".//td[2]")).getText();
				System.out.println(name);
				Thread.sleep(2000);
				if (name.equalsIgnoreCase(Product)) {

					row.findElement(By.xpath(".//td[4]/input")).click();
					Thread.sleep(2000);
					String price = row.findElement(By.xpath(".//td[3]")).getText();
					System.out.println(price +" of "+Product);
					System.out.println("Found on page " + i);
					flag = true;
					break;
				}
			}
		}
	}
}
