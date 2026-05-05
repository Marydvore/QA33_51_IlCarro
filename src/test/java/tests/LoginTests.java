package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void loginSuccess() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("iv@iv.com", "Ii123#@&");
        app.getHelperUser().submitLogin();

        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");

        //app.getHelperUser().clickOKButton();
    }

    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("iv@iv.com", "Ii123#@&");
        app.getHelperUser().submitLogin();

        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");

        //app.getHelperUser().clickOKButton();
    }

    @Test
    public void loginWrongEmail() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("ivad@iv.com", "Ii123#@&");
        app.getHelperUser().submitLogin();

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
    }

    @Test
    public void loginWrongEmailWithoutAtItsNotLookLikeEmail() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("iviv.com", "Ii123#@&");

        Assert.assertTrue(app.getHelperUser().isEmailWithoutAtPresentDisabled());
        Assert.assertTrue(app.getHelperUser().isEmailWithoutAtItsNotLookLikeEmail());

        app.getHelperUser().fillLoginForm("iv@iv.com", "Ii123#@&");
        app.getHelperUser().submitLogin();
    }

    /*@Test
    public void loginWrongEmailWithoutAtPresentDisabled() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("iviv.com", "Ii123#@&");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isEmailWithoutAtPresentDisabled());

        app.getHelperUser().fillLoginForm("iv@iv.com", "Ii123#@&");
        app.getHelperUser().submitLogin();
    }*/

    @Test
    public void loginWrongPassword() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("iv@iv.com", "Ii12");
        app.getHelperUser().submitLogin();

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
    }

    @Test
    public void loginUnregisteredUser() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("kate@za.com", "@@!!123Ka");
        app.getHelperUser().submitLogin();

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");

    }

    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOKButton();
    }
}