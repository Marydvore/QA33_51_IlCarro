package tests;

import models.User;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
            logger.info("Before method finished logout");
        }
    }

    @Test
    public void registrationSuccess() {
        // 1 variable
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        System.out.println(i);
        System.out.println("==========================");
        // 2 variable
        int z = (int) (System.currentTimeMillis() / 1000) % 3600;
        System.out.println(z);

        logger.info("Test data ---> Name: 'Alex', Last name: 'Art', email: 'art" + z + "@art.com', password: '$Art1*!23'");
        User user = new User()
                .setName("Alex")
                .setLastName("Art")
                .setEmail("art" + z + "@art.com")
                .setPassword("$Art1*!23");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "You are logged in success");
        logger.info("Assert check is message present with text 'You are logged in success'");
    }

    @Test
    public void registrationEmptyName(){
        logger.info("Test data ---> Name: ' ', Last name: 'Art', email: 'art000@art.com', password: '$Art1*!23'");
        User user = new User()
                .setName("")
                .setLastName("Art")
                .setEmail("art000@art.com")
                .setPassword("$Art1*!23");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "Name is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNoActive());
        logger.info("Assert check is message present with error text 'Name is required'");
        logger.info("Assert check is element button 'Yalla' no active'");

    }

    @Test
    public void registrationEmptyLastName(){
        logger.info("Test data ---> Name: 'Alex', Last name: ' ', email: 'art000@art.com', password: '$Art1*!23'");
        User user = new User()
                .setName("Alex")
                .setLastName("")
                .setEmail("art000@art.com")
                .setPassword("$Art1*!23");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "Last name is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNoActive());
        logger.info("Assert check is message present with error text 'Last name is required'");
        logger.info("Assert check is element button 'Yalla' no active'");

    }

    @Test
    public void registrationEmptyEmail(){
        logger.info("Test data ---> Name: 'Alex', Last name: 'Art', email: ' ', password: '$Art1*!23'");
        User user = new User()
                .setName("Alex")
                .setLastName("Art")
                .setEmail("")
                .setPassword("$Art1*!23");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "Email is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNoActive());
        logger.info("Assert check is message present with error text 'Email is required'");
        logger.info("Assert check is element button 'Yalla' no active'");

    }


    @Test
    public void registrationWrongEmail() {
        logger.info("Test data ---> Name: 'Alex', Last name: 'Art', email: 'art000art.com', password: '$Art1*!23'");
        User user = new User()
                .setName("Alex")
                .setLastName("Art")
                .setEmail("art000art.com")
                .setPassword("$Art1*!23");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        //Assert.assertEquals(app.getHelperUser().getErrorText(), "Wrong email format\n" +
        //        "Wrong email format");
        Assert.assertTrue(app.getHelperUser().getErrorText().contains("Wrong email format"));
        Assert.assertTrue(app.getHelperUser().isYallaButtonNoActive());
        logger.info("Assert check is message present with error text 'Wrong email format'");
        logger.info("Assert check is element button 'Yalla' no active'");
    }

    @Test
    public void registrationEmptyPassword(){
        logger.info("Test data ---> Name: 'Alex', Last name: 'Art', email: 'art000@art.com', password: ' '");
        User user = new User()
                .setName("Alex")
                .setLastName("Art")
                .setEmail("art000@art.com")
                .setPassword("");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "Password is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNoActive());
        logger.info("Assert check is message present with error text 'Password is required'");
        logger.info("Assert check is element button 'Yalla' no active'");

    }

    @Test
    public void registrationWrongPassword() {
        logger.info("Test data ---> Name: 'Alex', Last name: 'Art', email: 'art000@art.com', password: '$Art1'");
        User user = new User()
                .setName("Alex")
                .setLastName("Art")
                .setEmail("art000@art.com")
                .setPassword("$Art1");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "Password must contain minimum 8 symbols\n" +
                "Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNoActive());
        logger.info("Assert check is message present with error text 'Password must contain minimum 8 symbols\\n\" +\n" +
                " \"Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]'");
        logger.info("Assert check is element button 'Yalla' no active'");
    }

    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOKButton();
    }
}
