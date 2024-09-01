package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import utils.TestBase;

public class LoginTest extends TestBase {

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.openLoginPage();

        loginPage.login();

        Assert.assertTrue("Login não foi bem-sucedido.", loginPage.isLoginSuccessful());
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.openLoginPage();

        loginPage.loginError();

        Assert.assertTrue("A mensagem de erro não foi exibida.", loginPage.isErrorMessageDisplayed());
    }
}
