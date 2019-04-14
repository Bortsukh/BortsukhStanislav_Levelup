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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class SeleniumTest {
    private WebDriver driver;

    @BeforeTest
    public void openAndLogin() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //english language
        options.addArguments("--lang=en");
        WebDriver driver = new ChromeDriver(options);
        //open test site
        driver.get("http://khda91.fvds.ru/mantisbt/");
        //catch exception
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //check Title
        assertThat(driver.getTitle(), equalTo("MantisBT"));
        //login
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
        driver.findElement(By.className("btn-success")).click();
        //Assert User name in the right-top side of screen that user is loggined
        String nameOfUser = driver.findElement(By.className("user-info")).getText();
        assertThat("admin",equalTo(nameOfUser));
        //Assert left side menu
        List<WebElement> naviList = driver.findElements(By.xpath("//ul[contains(@class, 'nav-list')]//li"));
        List<String> expNaviList = Arrays.asList(new String[]{"My View",
                "View Issues", "Report Issue", "Change Log",
                "Roadmap", "Summary", "Manage"});
        List<String>  actNaviList = new ArrayList<String>();
        for (WebElement item: naviList) {
            actNaviList.add(item.getText());
        }
        assertThat(actNaviList, containsInAnyOrder(expNaviList.toArray(new String[expNaviList.size()])));
        //Click "Manage" button at the left side menu
        driver.findElement(By.xpath("//ul[contains(@class, 'nav-list')]//li[7]")).click();
    }

    @Test
    public void addProject(){
        //Click "Manage Projects" button at the top menuon the "Manage MantisBT" page
        driver.findElement(By.xpath("//ul[contains(@class, 'nav-tabs')]//li[3]")).click();
        assertThat(driver.getTitle(), equalTo("Manage Projects - MantisBT"));
        //Click "Create New Projects" button
        driver.findElement(By.xpath("//form//button[contains(@class, 'btn-primary')]")).click();
        //Check fields on the "Add Project" view	"Project Name Status Inherit Global Categories View Status Description"
//        List <String> expCategory = Arrays.asList(new String[]{"Project Name", "Status", "Inherit Global Categories",
//                "View Status", "Description"});
//        List<WebElement> category = driver.findElements(By.className("category"));
//        List<String> actCategory = new ArrayList<>();
//        for ( WebElement categories : category) {
//            actCategory.add(categories.getText());
//        }
//        assertThat(expCategory, equalTo(expCategory));
    }

    @AfterTest
    public void logoutAndClose(){
        driver.close();
    }
}
