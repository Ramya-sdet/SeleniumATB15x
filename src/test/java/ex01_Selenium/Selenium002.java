package ex01_Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium002 {
    public static void main(String[] args) {
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://App.vwo.com");
        driver.quit();
    }
}