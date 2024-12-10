package javaTask10;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Qsn03 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.guvi.in/");
		driver.manage().window().maximize();
		waitForTime(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Sign up')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("TestUser");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testusernew@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");
		driver.findElement(By.xpath("//input[@id='mobileNumber']")).sendKeys("1234567890");
		waitForTime(2000);
		driver.findElement(By.xpath("//a[@id='signup-btn']")).click();
		waitForTime(2000);
		driver.findElement(By.xpath("//select[@id='profileDrpDwn']")).click();
		waitForTime(2000);
		List<WebElement> currentProfile = driver.findElements(By.xpath("//div[@class='form-group']//select[@id='profileDrpDwn']//option"));
		waitForTime(2000);
		
		for(int index=0;index<currentProfile.size();index++) {
			if(currentProfile.get(index).getText().equalsIgnoreCase("Working professional in IT")) {
				currentProfile.get(index).click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//select[@id='degreeDrpDwn']")).click();
		waitForTime(2000);
		List<WebElement> degree = driver.findElements(By.xpath("//div[@class='form-group']//select[@id='degreeDrpDwn']//option"));
		waitForTime(2000);
		
		for(int index=0;index<degree.size();index++) {
			if(degree.get(index).getText().equalsIgnoreCase("B.E. / B.Tech. EEE")) {
				degree.get(index).click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//div[@class='form-group']//input[@id='year']")).sendKeys("2018");
		waitForTime(2000);
		driver.findElement(By.xpath("//a[@id='details-btn']")).click();
		waitForTime(8000);
		
		driver.findElement(By.xpath("//a[@id='login-btn']"));
		
		WebElement myElement =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
		myElement.sendKeys("testusernew@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");
		driver.findElement(By.xpath("//a[@id='login-btn']"));
		
		wait.until(ExpectedConditions.urlContains("dashboard"));
        System.out.println("Login Successful");
        driver.quit();

	}
	
	public static void waitForTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
