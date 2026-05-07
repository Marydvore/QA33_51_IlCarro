package tests;

import models.User;
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
    }

    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOKButton();
    }
}
