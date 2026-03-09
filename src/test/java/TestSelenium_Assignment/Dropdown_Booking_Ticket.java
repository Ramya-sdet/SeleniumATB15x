package TestSelenium_Assignment;

import ex_07_WaitHelper.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Dropdown_Booking_Ticket {
    @Test
    public void test_bookingTicket() {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver();
        String URL = "https://www.booking.com";
        driver.get(URL);
        driver.manage().window().maximize();
        WaitHelpers.waitJVM(2000);


        //CloseModal
        WebElement CloseModal=driver.findElement(By.xpath("//div[@role=\"dialog\"]/div/div[1]/div[1]/div/div/button[@type=\"button\"]"));
        CloseModal.click();

        //Click Flights Link
        WebElement FlightsEle=driver.findElement(By.xpath("//a[@id=\"flights\"]"));
        FlightsEle.click();

        //Enter Destination Using Actions
        WebElement Going_to=driver.findElement(By.xpath("//div[@data-ui-name=\"segments_list_item\"]/div/div/button[3]"));
        Going_to.click();

        WebElement Input=driver.findElement(By.xpath("//input[@type=\"text\"]"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).sendKeys(Input, "DEL")
                .keyUp(Keys.SHIFT).build().perform();
        actions.sendKeys(Keys.TAB).click();

        //Search Flights
        WebElement Explore=driver.findElement(By.xpath("//button[@data-ui-name=\"button_search_submit\"]"));
        Explore.click();
    }
}
