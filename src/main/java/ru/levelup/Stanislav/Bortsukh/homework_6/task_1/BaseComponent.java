package ru.levelup.Stanislav.Bortsukh.homework_6.task_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseComponent {
    protected WebDriver driver;

    protected BaseComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
