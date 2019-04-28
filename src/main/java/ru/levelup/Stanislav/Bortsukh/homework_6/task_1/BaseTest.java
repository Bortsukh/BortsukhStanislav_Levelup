package ru.levelup.Stanislav.Bortsukh.homework_6.task_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BaseTest {
    private WebDriver driver;

    private LoginPage loginPage;
    private HomePage homePage;
    private ManagePage managePage;

    @BeforeTest
    public void openAndLogin() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //english language
        options.addArguments("--lang=en");
        driver = new ChromeDriver(options);
        //open test site
        driver.get("http://khda91.fvds.ru/mantisbt/");

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        managePage = new ManagePage(driver);

        //catch exception
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //check Title
        assertThat(homePage.getPageTitle(), equalTo("MantisBT"));

        //login
        loginPage.login("admin", "admin");

        //Assert User name in the right-top side of screen that user is loggined
        String actUserName= homePage.nameOfUserText();
        assertThat("admin", equalTo(actUserName));

        //Assert left side menu
        List<WebElement> naviListForCompare = homePage.getNaviList();
        List<String> expNaviList = Arrays.asList(new String[]{"My View",
                "View Issues", "Report Issue", "Change Log",
                "Roadmap", "Summary", "Manage"});
        List<String>  actNaviList = new ArrayList<String>();
        for (WebElement item: naviListForCompare) {
            actNaviList.add(item.getText());
        }
        assertThat(actNaviList, containsInAnyOrder(expNaviList.toArray(new String[expNaviList.size()])));

        //Click "Manage" button at the left side menu
        homePage.clickManageLink();
    }

    @Test(alwaysRun=true)
    public void addProject() {
        //Click "Manage Projects" button at the top menuon the "Manage MantisBT" page
        managePage.clickManageProjects();
        assertThat(managePage.getPageTitle(), equalTo("Manage Projects - MantisBT"));

        //Click "Create New Projects" button
        managePage.clickCreateNewProject();

        //Check fields on the "Add Project" view	"Project Name Status Inherit Global Categories View Status Description"
        List<String> expCategory = Arrays.asList(new String[]{"* Project Name", "Status", "Inherit Global Categories",
                "View Status", "Description"});
        List<WebElement> category = managePage.getCategories();
        List<String> actCategory = new ArrayList<>();
        for (WebElement categories : category) {
            actCategory.add(categories.getText());
        }
        assertThat(actCategory, equalTo(expCategory));

        //Fill Project inforamtion and Add project
        managePage.addNewProject("SB", "New One");

        //delete Created class
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//tr//a[contains(text(),'SB')]")).click();
        managePage.clickDeleteProject();
    }

    @Test(alwaysRun=true)
    public void addUser() {
        //Click "Manage Projects" button at the top menuon the "Manage MantisBT" page
        managePage.clickManageUsers();
        assertThat(managePage.getPageTitle(), equalTo("Manage Users - MantisBT"));

        //Check "Create New Account" button
        String nameOfButton = managePage.nameOfCreateNewAccountButton();
        assertThat("Create New Account", equalTo(nameOfButton));

        //Click "Create New Account" button
        managePage.clickCreateNewAccount();

        //Check fields on the "Create New Account" view
        List<String> expCategory = Arrays.asList(new String[]{"Username",
                "Real Name",
                "E-mail",
                "Password",
                "Verify Password",
                "Access Level",
                "Enabled",
                "Protected"});
        List<WebElement> category = managePage.getCategoriesForUser();
        List<String> actCategory = new ArrayList<>();
        for (WebElement categories : category) {
            actCategory.add(categories.getText());
        }
        assertThat(actCategory, equalTo(expCategory));

        //Fill user inforamtion Username: any Real Name: any E-Mail: any Password: any Verify Password: any Access Level: reporter Enabled: true Protected: false
        //Click "Create User" button
        managePage.createNewUser("vova", "vovochka", "vova@kkk.ru", "vova", "vova" );

        //Logout
        managePage.clickUserInfo();
        managePage.clickSingOutButton();

        //Login under created user
        loginPage.login("vova", "vova");

        //Assert User name in the right-top side of screen that user is loggined
        String actUserName= homePage.nameOfUserText();
        assertThat("vova",equalTo(actUserName));

    }

    @AfterTest
    public void logoutAndClose(){
        //logout
        homePage.clickUserInfo();
        homePage.clickSingOutButton();
        driver.close();
    }
}
