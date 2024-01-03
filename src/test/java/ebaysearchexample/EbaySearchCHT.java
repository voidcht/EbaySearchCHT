package ebaysearchexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EbaySearchCHT {

    WebDriver webDriver;

    @BeforeMethod
    public void initializeBrowser(){
        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();

        webDriver.get("https://www.ebay.com/");

    }

    @Test
    public void searchCameras(){
        //finding the search box and insert text to search
        webDriver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Cameras");

        Select select = new Select(webDriver.findElement(By.xpath("//select[@id='gh-cat']")));
        select.selectByVisibleText("Cameras & Photo");

        webDriver.findElement(By.xpath("//input[@id='gh-btn']")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @AfterMethod
    void closeBrowser(){
        webDriver.quit();
    }
}
