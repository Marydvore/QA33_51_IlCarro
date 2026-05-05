package tests;

import models.User;
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
    public void loginSuccess1() {
        User user= new User().setEmail("iv@iv.com").setPassword("Ii123#@&");
        //user.setEmail("iv@iv.com");
        //user.setPassword("Ii123#@&");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");

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
        User user= new User().setEmail("ivad@iv.com").setPassword("Ii123#@&");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
    }

    @Test
    public void loginWrongEmailWithoutAtItsNotLookLikeEmail() {
        User user= new User().setEmail("iviv.com").setPassword("Ii123#@&");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);

        Assert.assertTrue(app.getHelperUser().isEmailWithoutAtPresentDisabled());
        Assert.assertTrue(app.getHelperUser().isEmailWithoutAtItsNotLookLikeEmail());

        app.getHelperUser().fillLoginForm("iv@iv.com", "Ii123#@&");
        app.getHelperUser().submitLogin();
    }

    @Test
    public void loginWrongPassword() {
        User user= new User().setEmail("iv@iv.com").setPassword("Ii12");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
    }

    @Test
    public void loginUnregisteredUser() {
        User user= new User().setEmail("kate@za.com").setPassword("@@!!123Ka");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");

    }

    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOKButton();
    }
}