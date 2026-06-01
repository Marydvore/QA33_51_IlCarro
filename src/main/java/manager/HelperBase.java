package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.util.List;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        clearNew(element);
        if (text != null) {
            element.sendKeys(text);
        }
    }

    public void clearNew(WebElement element){  //натайпили и стерли
        String os = System.getProperty("os.name");
        System.out.println(os);
        element.sendKeys(" ");

        //element.sendKeys(Keys.BACK_SPACE);

        if (os.startsWith("Win")){
            element.sendKeys(Keys.CONTROL,"a");
        }else {
            element.sendKeys(Keys.COMMAND,"a");
        }
        element.sendKeys(Keys.DELETE);
    }

    public void click(By locator){
        WebElement element = wd.findElement(locator);
        element.click();
    }

    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isElementPresent(By locator) {
        List<WebElement> list = wd.findElements(locator);
        //System.out.println(list.size());
        return list.size() > 0;
    }

    public String getErrorText() {
        return wd.findElement(By.cssSelector("div.error")).getText();
    }

    public String getTextWrongEmail() {
        return wd.findElement(By.cssSelector("div.error")).getText();
    }

    public void getScreen(String link) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) wd;
        File tmp = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tmp,new File(link));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
