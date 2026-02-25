package TestSelenium_Assignment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSelenium_KatalonApp {
    @Test
    public void CuraApp() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Thread.sleep(2000);

        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement BtnMakeAppointment=driver.findElement(By.id("btn-make-appointment"));
        BtnMakeAppointment.click();

        WebElement Username= driver.findElement(By.id("txt-username"));
        Username.sendKeys("John Doe");
        WebElement Password=driver.findElement(By.id("txt-password"));
        Password.sendKeys("ThisIsNotAPassword");
        WebElement LoginBtn=driver.findElement(By.id("btn-login"));
        LoginBtn.click();
        Thread.sleep(5000);

       Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");
       String h2Makeappointment = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals(h2Makeappointment ,"Make Appointment");
    }
}
