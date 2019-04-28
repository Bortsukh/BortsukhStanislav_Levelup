package ru.levelup.Stanislav.Bortsukh.homework_6.task_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ManagePage extends BaseComponent {
    private WebDriver driver;

    @FindBy(xpath = "//ul[contains(@class, 'nav-tabs')]//li[3]")
    private WebElement manageProjects;
    @FindBy(xpath = "//form//button[contains(@class, 'btn-primary')]")
    private WebElement createNewProject;
    @FindBy(className = "category")
    private List<WebElement> categories;
    @FindBy(id = "project-name")
    private WebElement projectName;
    @FindBy(id = "project-description")
    private WebElement projectDescription;
    @FindBy(xpath = "//input[@value='Add Project']")
    private WebElement addProjectButton;
    @FindBy(xpath = "//input[@value ='Delete Project']")
    private WebElement deleteProject;
    @FindBy(xpath = "//ul[contains(@class, 'nav-tabs')]//li[2]")
    private WebElement manageUsers;
    @FindBy(xpath = "//div[@id='manage-user-div']//a[contains(@class, 'btn')]")
    private WebElement createNewAccountButton;
    @FindBy(className = "category")
    private List<WebElement> categoriesForUser;
    @FindBy(id = "user-username")
    private WebElement userName;
    @FindBy(id = "user-realname")
    private WebElement userRealName;
    @FindBy(id = "email-field")
    private WebElement useremail;
    @FindBy(id = "user-password")
    private WebElement userPassword;
    @FindBy(id = "user-verify-password")
    private WebElement userPasswordVerify;
    @FindBy(xpath = "//input[@value='Create User']")
    private WebElement createUserButton;
    //driver.findElement(By.id("user-username")).sendKeys("vova");
    //driver.findElement(By.id("user-realname")).sendKeys("vovochka");
    //driver.findElement(By.id("email-field")).sendKeys("vova@kkk.ru");
    //driver.findElement(By.id("user-password")).sendKeys("vova");
    //driver.findElement(By.id("user-verify-password")).sendKeys("vova");

    public ManagePage(WebDriver driver) {
        super(driver);
    }

    public void clickManageProjects(){
        manageProjects.click();
    }

    public void clickCreateNewProject(){
        createNewProject.click();
    }

    public List<WebElement> getCategories(){
        return categories;
    }

    public void addNewProject(final String name, final String description){
        projectName.sendKeys(name);
        projectDescription.sendKeys(description);
        addProjectButton.click();
    }

    public void clickDeleteProject(){
        deleteProject.click();
        deleteProject.click();
    }

    public void clickManageUsers(){
        manageUsers.click();
    }

    public String nameOfCreateNewAccountButton(){
        return createNewAccountButton.getText();
    }

    public void clickCreateNewAccount(){
        createNewAccountButton.click();
    }

    public List<WebElement> getCategoriesForUser(){
        return categoriesForUser;
    }

    public void createNewUser(final String name, final String realName, final String email,
                              final String password,final String verifyPassword){
        userName.sendKeys(name);
        userRealName.sendKeys(realName);
        useremail.sendKeys(email);
        userPassword.sendKeys(password);
        userPasswordVerify.sendKeys(verifyPassword);
        createUserButton.click();
    }
}
