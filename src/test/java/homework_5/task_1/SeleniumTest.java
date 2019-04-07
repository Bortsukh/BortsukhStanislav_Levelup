package homework_5.task_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    @Test
    public void addTagsTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://khda91.fvds.ru/mantisbt/");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        WebElement loginBtn = new WebDriverWait(driver, 10, 1000)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-success")));
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        loginBtn.click();
        
        driver.close();
    }

}
