package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.cssSelector("a.navigation-link[href='/login?url=%2Fsearch']"));
    }

    public void fillLoginForm(String email, String password){
        type(By.xpath("//input[@formcontrolname='email']"), email);
        type(By.xpath("//input[@formcontrolname='password']"), password);
    }

    public void submitLogin(){
        click(By.xpath("//button[text()='Y’alla!']"));
    }
}
