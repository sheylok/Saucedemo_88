package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import pages.ProductsPage;
import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @AfterEach
    public void TearDown() {
        driver.quit();
    }
}
