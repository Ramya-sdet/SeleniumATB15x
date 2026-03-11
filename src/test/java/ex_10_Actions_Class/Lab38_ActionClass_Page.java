package ex_10_Actions_Class;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Lab38_ActionClass_Page {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/");
        driver.manage().window().maximize();


        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
    }
}
