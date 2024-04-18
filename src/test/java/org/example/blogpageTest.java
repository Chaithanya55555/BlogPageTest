package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class blogpageTest {
    public static void main(String[] args) throws  Exception{
        try {
            WebDriverManager.chromedriver().setup();
            WebDriver obj = new ChromeDriver();
            obj.get("https://qabloglist.ccbp.tech/");
            List <WebElement> h1 = obj.findElements(By.xpath("//h1[text() = 'My fifth post']/preceding::h1[@class = 'blog-title']"));
            for (int i = 0; i < h1.size() ; i++) {
                System.out.println(h1.get(i).getText());
            }
            List <WebElement> a = obj.findElements(By.xpath("//*[text() = 'Home']/following::a"));
            WebElement firstLink = a.get(0);
            firstLink.click();
            String expectedUrl = "https://qabloglist.ccbp.tech/about";
            WebDriverWait waitAbout = new WebDriverWait(obj,Duration.ofSeconds(10));
            waitAbout.until(ExpectedConditions.urlToBe(expectedUrl));
            String currentUrl = obj.getCurrentUrl();
            if (currentUrl.equals(expectedUrl)){
                System.out.println("Navigation to About Page Successful");
            }
            WebElement secondLink = a.get(1);
            secondLink.click();
            String expectedContactUrl = "https://qabloglist.ccbp.tech/contact";
            WebDriverWait waitContactPage = new WebDriverWait(obj,Duration.ofSeconds(10));
            waitContactPage.until(ExpectedConditions.urlToBe(expectedContactUrl));
            String currentContactURl = obj.getCurrentUrl();
            if (currentContactURl.equals(expectedContactUrl)) {
                System.out.println("Navigation to Contact Page Successful");
            }
            Thread.sleep(3000);
            obj.quit();
        }
        catch (Exception e){
            System.out.println("An exception occurred: " + e.getMessage());
        }

    }
}
