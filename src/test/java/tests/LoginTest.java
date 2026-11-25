package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithLockedOutUser() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");

        assertTrue(loginPage.erorrVisible());
        assertEquals(loginPage.getErorrText(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void loginWithCorrectUser() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertTrue(productsPage.successLogin());
    }

    @Test
    public void loginWithGlitchUser() {
        loginPage.open();
        long startTime = System.currentTimeMillis();
        loginPage.login("performance_glitch_user", "secret_sauce");
        assertTrue(productsPage.successLogin());
        long duration = System.currentTimeMillis() - startTime;
        assertTrue(duration >= 5000);
    }

    @Test
    public void loginWithhoutUsername() {
        loginPage.open();
        loginPage.login("", "secret_sauce");

        assertTrue(loginPage.erorrVisible());
        assertEquals(loginPage.getErorrText(), "Epic sadface: Username is required");
    }
}