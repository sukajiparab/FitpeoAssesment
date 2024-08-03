import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://www.fitpeo.com/");

		driver.findElement(By.partialLinkText("Revenue Calculator")).click();

		WebElement slider = driver.findElement(By.cssSelector(".MuiSlider-thumb"));
		Actions a=new Actions(driver);

		a.clickAndHold(slider).moveToLocation( 905, 667).release().perform();
		WebElement textbox=driver.findElement(By.xpath("//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-sizeSmall css-1kkflqu']/input"));
		//textbox.clear();
		textbox.sendKeys(Keys.CONTROL+"a");
		textbox.sendKeys(Keys.DELETE);
		textbox.sendKeys("560");
		driver.findElement(By.cssSelector(".PrivateSwitchBase-input.css-1m9pwf3")).click();
		driver.findElement(By.xpath("//span[normalize-space()='19.19']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='63']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='15']")).click();
		String amt=driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-hocx5c'][normalize-space()='$75600'])[1]")).getText();
		Assert.assertEquals(amt, "$75600");
	}

}
