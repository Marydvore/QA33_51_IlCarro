package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.cssSelector("a.navigation-link[href='/login?url=%2Fsearch']"));
        //click(By.xpath("//a[text()=' Log In ']"));
    }

    public void fillLoginForm(String email, String password){
        type(By.xpath("//input[@formcontrolname='email']"), email);
        type(By.xpath("//input[@formcontrolname='password']"), password);
        //type(By.id("email"), email);
        //type(By.id("password"), password);
    }

    public void submitLogin(){
        click(By.xpath("//button[text()='Y’alla!']"));
        //click(By.xpath("//button[@type='submit']"));

    }

    public void clickOKButton() {
        click(By.xpath("//button[text()='Ok']"));

    }

    public String getMessage() {
        //WebElement element = wd.findElement(By.cssSelector(".dialog-container>h2"));
        //String text=element.getText();
        //return text;

        pause(2000);
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();
    }
}
