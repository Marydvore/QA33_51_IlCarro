package tests;

import org.testng.annotations.Test;

public class LoginTests extends  TestBase{

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(" iv@iv.com", "Ii123#@&");
        app.getHelperUser().submitLogin();
    }
}