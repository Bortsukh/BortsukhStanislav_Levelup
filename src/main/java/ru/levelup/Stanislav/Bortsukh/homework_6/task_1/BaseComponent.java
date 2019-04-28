package ru.levelup.Stanislav.Bortsukh.homework_6.task_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public abstract class BaseComponent {
    protected WebDriver driver;

    @FindBy(xpath = "//span[contains(@class, 'user-info')]")
    private WebElement userInfo;

    @FindBy(xpath = "//ul[contains(@class, 'nav')]//i[contains(@class, 'fa-sign-out')]")
    private WebElement singOutButton;

    protected BaseComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickUserInfo()
    {
        userInfo.click();
    }

    public void clickSingOutButton()
    {
        singOutButton.click();

    }

    public String getPageTitle(){
        return driver.getTitle();
    }

}
