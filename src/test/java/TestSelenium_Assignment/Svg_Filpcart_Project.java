package TestSelenium_Assignment;

import ex_07_WaitHelper.WaitHelpers;
import io.qameta.allure.Description;
import org.example.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Svg_Filpcart_Project extends CommonToAll {
    ChromeDriver driver;

    @Description("Verify that the on search with svg icon results are visible.")
    @Test
    public void test_Flipkart_Search_SVG_Icon() {

        driver = new ChromeDriver();
        openBrowser(driver, "https://www.flipkart.com/search");

        WebElement search_input = driver.findElement(By.name("q"));
        search_input.sendKeys("Applemacmini");

        List<WebElement> svgElements = driver.findElements(By.xpath("//*[local-name()='svg']"));
        svgElements.get(0).click();

        WaitHelpers.checkVisibility(driver, By.xpath("//div[contains(@data-id,'CPU')]/div/a[2]"));

        //Capture Title and price
        List<WebElement> titles = driver.findElements(By.xpath("//div[contains(@data-id,'CPU') or contains(@data-id,'MP')]/div/a[2]"));
        List<WebElement> Prices =driver.findElements(By.xpath("//div[contains(@data-id,'CPU') or contains(@data-id,'MP')]/div/a[2]/following-sibling::a/div/div[1]"));

        //Print titles
        for (WebElement title : titles) {
            System.out.println(title.getDomAttribute("title"));

        }
        //print prices
        for (WebElement P:Prices){
            System.out.println(P.getText());
        }

        //Cheapest mac-mini Price
       List<Integer> pricelist =new ArrayList<>();

        for (WebElement P:Prices){
            String Price=P.getText().replaceAll("[^0-9]","");
            if(!Price.isEmpty()){
                pricelist.add(Integer.parseInt(Price));
            }

        }
        Collections.sort(pricelist);
        System.out.println("Cheapest mac-mini Price:₹"+pricelist.get(0));



        WaitHelpers.waitJVM(5000);
        closeBrowser(driver);



    }
}
