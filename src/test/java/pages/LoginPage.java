package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Authorization page*/

public class LoginPage {
    private final By loginInput = By.cssSelector("#user-name");
    private final By passwordInput = By.cssSelector("#password");
    private final By submitBtn = By.cssSelector("#login-button");
    private final By erorr = By.cssSelector("[data-test='error']");

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String username, String password) {
        driver.findElement(loginInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(submitBtn).click();
    }

    public boolean erorrVisible() {
        return driver.findElement(erorr).isDisplayed();
    }

    public String getErorrText() {
        return driver.findElement(erorr).getText();
    }
}