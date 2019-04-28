package ru.levelup.Stanislav.Bortsukh.homework_6.task_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseComponent {
    private WebDriver driver;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordTextField;
    @FindBy(id = "username")
    private WebElement usernameTextField;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver)
    {
       super(driver);
    }

    public void login(final String username, final String password){
        //login
        usernameTextField.sendKeys(username);
        loginButton.click();
        passwordTextField.sendKeys(password);
        loginButton.click();
    }
}
