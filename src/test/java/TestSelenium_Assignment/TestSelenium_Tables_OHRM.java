package TestSelenium_Assignment;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium_Tables_OHRM {
    @Owner("Ramya")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify login is working")
    @Test
    public void test_OHRM_login() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement input_username = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement input_password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement button = driver.findElement(By.xpath("//button"));
//        WebElement button = driver.findElement(By.xpath("//button[@type=\"submit\"]"));

        input_username.sendKeys("admin");
        input_password.sendKeys("Hacker@4321");
        button.click();

        Thread.sleep(3000);

        //Login, Find the first Terminated Employee and click on the Delete
        List<WebElement> First_TerminatedEmp = driver.findElements(By.xpath("//div[text()=\"Terminated\"]"));
        WebElement First_TerminatedEmpName = driver.findElement(By.xpath("//div[contains(text(),'Terminated')]/../preceding-sibling::div[3]"));
        System.out.println(First_TerminatedEmpName.getText());
        WebElement DeleteFirst_terminatedEmp = driver.findElement(By.xpath( "//div[text()=\"Terminated\"]/following::i[1]"));
        DeleteFirst_terminatedEmp.click();


        WebElement deletePopup=driver.findElement(By.xpath("//p[@class=\"oxd-text oxd-text--p oxd-text--card-body\"]"));
        Thread.sleep(2000);
        String Delete_Popup=deletePopup.getText();
        Assert.assertEquals(Delete_Popup,"The selected record will be permanently deleted. Are you sure you want to continue?");

    }
}
