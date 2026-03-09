package ex_09_Input_Select_Alerts_Radio;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium32_Input_Checkbox_Radios {
    @Description("Input_Checkbox_Radiobox")
    @Test
    public void test_HTMLTags() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/practice.html");

        WebElement firstname = driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
        firstname.sendKeys("Divya");

        // RADIO Box
        WebElement radiobox = driver.findElement(By.id("sex-1"));
        radiobox.click();

        // CheckBox
        driver.findElement(By.id("tool-1")).click();
    }
}
