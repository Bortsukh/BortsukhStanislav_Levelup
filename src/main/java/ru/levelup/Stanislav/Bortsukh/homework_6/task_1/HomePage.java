package ru.levelup.Stanislav.Bortsukh.homework_6.task_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseComponent {

    private WebDriver driver;

    @FindBy(partialLinkText = "Manage")
    private WebElement manageLink;

    @FindBy(className = "user-info")
    private WebElement nameOfUser;

    @FindBy(xpath="//ul[contains(@class, 'nav-list')]//li")
    private List<WebElement> naviList;

    @FindBy(xpath = "//span[contains(@class, 'user-info')]")
    private WebElement userInfo;

    @FindBy(xpath = "//ul[contains(@class, 'nav')]//i[contains(@class, 'fa-sign-out')]")
    private WebElement singOutButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickManageLink(){
        manageLink.click();
    }

    public String nameOfUserText(){
        return nameOfUser.getText();
    }

    public List<WebElement> getNaviList(){
        return naviList;
    }

    public void clickUserInfo(){
        userInfo.click();
    }

    public void clickSingOutButton(){
        singOutButton.click();
    }

}
