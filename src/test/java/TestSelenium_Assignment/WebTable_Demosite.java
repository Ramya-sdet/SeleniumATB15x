package TestSelenium_Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class WebTable_Demosite {
    WebDriver driver;

    // Reusable method
    public void addUser(String firstName, String lastName, String email, String age,
                        String salary, String department) {

        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("age")).sendKeys(age);
        driver.findElement(By.id("salary")).sendKeys(salary);
        driver.findElement(By.id("department")).sendKeys(department);
        driver.findElement(By.id("submit")).click();
    }

    @Test
    public void test1() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();


        // Adding Employee 1
        driver.findElement(By.id("addNewRecordButton")).click();

        addUser("Aanad", "aravind","Anand12@example.com",
                "25", "40000", "Admin");

        Thread.sleep(3000);

        // Adding Employee 2
        driver.findElement(By.id("addNewRecordButton")).click();

        addUser("Chaitanya", "Rao","Chaitu@example.com",
                "22", "30000", "HR");

        Thread.sleep(3000);

        // Adding Employee 3
        driver.findElement(By.id("addNewRecordButton")).click();

        addUser("Kavya", "Shree","Kavi34@example.com",
                "29", "90000", "IT");

        Thread.sleep(3000);

        // Adding Employee 4
        driver.findElement(By.id("addNewRecordButton")).click();

        addUser("Sanjay", "Kumar","Sanju5@example.com",
                "35", "66000", "Finance");

        Thread.sleep(3000);

        // Adding Employee 5
        driver.findElement(By.id("addNewRecordButton")).click();

        addUser("Vinu", "Priya","tory4@example.com",
                "44", "77000", "Legal");
        Thread.sleep(3000);

        WebElement Legal_EmpName = driver.findElement(By.xpath("//td[contains(text(), 'Legal')]/parent::tr/td[6]"));
        System.out.println(Legal_EmpName.getText());

        WebElement delLegalEmp = driver.findElement(By.id("delete-record-3"));
        delLegalEmp.click();

        Thread.sleep(10000);

        driver.quit();
    }

}
