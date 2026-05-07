package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.awt.*;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.cssSelector("a.navigation-link[href='/login?url=%2Fsearch']"));
        //click(By.xpath("//a[text()=' Log In ']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath("//input[@formcontrolname='email']"), email);
        type(By.xpath("//input[@formcontrolname='password']"), password);
        //type(By.id("email"), email);
        //type(By.id("password"), password);
    }

    public void fillLoginForm(User user) {
        type(By.xpath("//input[@formcontrolname='email']"), user.getEmail());
        type(By.xpath("//input[@formcontrolname='password']"), user.getPassword());
        //type(By.id("email"), email);
        //type(By.id("password"), password);
    }

    public void submit() {
        click(By.xpath("//button[text()='Y’alla!']"));
        //click(By.xpath("//button[@type='submit']"));

    }

    public void clickOKButton() {
        if (isElementPresent(By.xpath("//button[text()='Ok']"))) {
            click(By.xpath("//button[text()='Ok']"));
        }

    }

    public String getMessage() {
        //WebElement element = wd.findElement(By.cssSelector(".dialog-container>h2"));
        //String text=element.getText();
        //return text;

        pause(2000);
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();
    }


    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[text()=' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//*[text()=' Logout ']"));
    }

    public boolean isEmailWithoutAtItsNotLookLikeEmail() {
        return isElementPresent(By.xpath("//form/div/div"));
    }

    public boolean isEmailWithoutAtPresentDisabled() {
        return isElementPresent(By.xpath("//*[@disabled]"));
    }


    public boolean isYallaButtonNoActive() {
        boolean res = isElementPresent(By.cssSelector("button[disabled]"));  //1 variable

        WebElement element = wd.findElement(By.cssSelector("button[type='submit']")); // 2 variable
        boolean result = element.isEnabled();
        return res && !result;
    }

    //**************************  REGISTRATION  *****************************

    public void openRegistrationForm() {
        click(By.xpath("//a[text() = ' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void checkPolicy() {
        // var1
        //click(By.id("terms-of-use")); но нет размера
        //var2
        //click(By.cssSelector("label[for ='terms-of-use']")); но есть ссылка
        //var3
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click()");
    }

    public void checkPolicyXY(){
        WebElement label = wd.findElement(By.cssSelector("label[for ='terms-of-use']"));
        Rectangle rectangle = label.getRect();
        int w = rectangle.getWidth();
        int xOffset=-w/2;
        Actions actions = new Actions(wd);
        actions.moveToElement(label,xOffset, 0).click().release().perform();

        //Dimension size = wd.manage().window().getSize(); параметры экрана

    }
}
