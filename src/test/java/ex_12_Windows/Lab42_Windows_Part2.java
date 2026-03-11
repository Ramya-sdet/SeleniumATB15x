package ex_12_Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Set;

public class Lab42_Windows_Part2 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        String URL = "https://app.vwo.com/#/login";
        driver.get(URL);
        driver.manage().window().maximize();


        String parent_id = driver.getWindowHandle();
        System.out.println(parent_id);
        // 490E6ED1FFCE856958FBB4A646C90572


        WebElement link_parent = driver.findElement(By.xpath("//a[normalize-space()='Start a free trial']"));
        link_parent.click();

        Set<String> windows_handles_ids = driver.getWindowHandles();
        // 1D338BD81AC274FF43D0698647443AD0
        //98C2024C16C8DACAC182BDDC5D7C6ED9

        for (String window : windows_handles_ids) {
            System.out.println(window);
            if (!window.equalsIgnoreCase(parent_id)) {
                driver.switchTo().window(window);

                //verify in the child,Sign up for a full-featured trial
                WebElement Title=driver.findElement(By.xpath("//h1"));
                Assert.assertTrue(true,"Sign up for a full-featured trial");



            }

        }


        //switching back to my parents window
        driver.switchTo().window(parent_id);


    }
}
