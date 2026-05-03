package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        //wd.findElement(By.cssSelector("a[href='/login']"));
        //WebElement loginTab = wd.findElement(By.xpath("//a[text()='LOGIN']"));
        //loginTab.click();
        click(By.cssSelector("a[href='/login']"));
    }

    public void fillLoginForm(String email, String password){
        //WebElement emailInput = wd.findElement(By.name("email"));
        //emailInput.click();
        //emailInput.clear();
        //emailInput.sendKeys(email);
        type(By.name("email"), email);

        //WebElement passwordInput = wd.findElement(By.xpath("//input[@placeholder='Password']"));
        //passwordInput.click();
        //passwordInput.clear();
        //passwordInput.sendKeys(password);
        type(By.xpath("//input[@placeholder='Password']"), password);
    }

    public void submitLogin(){
        click(By.xpath("//button[text()='Login']"));
    }
}
