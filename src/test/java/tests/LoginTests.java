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
            logger.info("Before method finished logout");
        }
    }

    @Test
    public void loginSuccess() {
        logger.info("Test data ---> email: 'iv@iv.com' & password: 'Ii123#@&'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("iv@iv.com", "Ii123#@&");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        logger.info("Assert check is message present with text 'Logged in success'");

        //app.getHelperUser().clickOKButton();
    }

    @Test
    public void loginSuccess1() {
        User user= new User().setEmail("iv@iv.com").setPassword("Ii123#@&");
        //user.setEmail("iv@iv.com");
        //user.setPassword("Ii123#@&");

        logger.info("Test data ---> email: 'iv@iv.com' & password: 'Ii123#@&'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        logger.info("Assert check is message present with text 'Logged in success'");

    }

    @Test
    public void loginSuccessModel() {
        logger.info("Test data ---> email: 'iv@iv.com' & password: 'Ii123#@&'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("iv@iv.com", "Ii123#@&");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        logger.info("Assert check is message present with text 'Logged in success'");

        //app.getHelperUser().clickOKButton();
    }

    @Test
    public void loginWrongEmail() {
        logger.info("Test data ---> email: 'ivad@iv.com' & password: 'Ii123#@&'");
        User user= new User().setEmail("ivad@iv.com").setPassword("Ii123#@&");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        logger.info("Assert check is message present with error text 'Login or Password incorrect'");
    }

    @Test
    public void loginWrongEmailYallaButtonNoActive() {
        logger.info("Test data ---> email: 'iviv.com' & password: 'Ii123#@&'");
        User user= new User().setEmail("iviv.com").setPassword("Ii123#@&");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);

        //Assert.assertTrue(app.getHelperUser().isEmailWithoutAtPresentDisabled());
        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        logger.info("Assert check is message present with error text 'It'snot look like email'");
        //Assert.assertTrue(app.getHelperUser().isEmailWithoutAtItsNotLookLikeEmail());
        Assert.assertTrue(app.getHelperUser().isYallaButtonNoActive());
        logger.info("Assert check is element button 'Yalla' no active'");
    }

    @Test
    public void loginWrongPassword() {
        logger.info("Test data ---> email: 'iv@iv.com' & password: 'Ii12'");
        User user= new User().setEmail("iv@iv.com").setPassword("Ii12");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        logger.info("Assert check is message present with error text 'Login or Password incorrect'");
    }

    @Test
    public void loginUnregisteredUser() {
        logger.info("Test data ---> email: 'kate@za.com' & password: '@@!!123Ka'");
        User user= new User().setEmail("kate@za.com").setPassword("@@!!123Ka");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        logger.info("Assert check is message present with error text 'Login or Password incorrect'");

    }

    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOKButton();
    }
}