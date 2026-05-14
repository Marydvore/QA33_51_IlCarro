package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HelperCar extends HelperBase {
    public HelperCar(WebDriver wd) {

        super(wd);
    }

    public void openCarForm() {
        click(By.xpath("//a[text()=' Let the car work ']"));
    }

    public void fillCarForm(Car car) {
        type(By.id("pickUpPlace"), car.getLocation());
        click(By.xpath("//*[text()='OK']"));
        type(By.id("make"), car.getManufacture());
        type(By.id("model"), car.getModel());
        type(By.id("year"), car.getYear());
        select(By.id("fuel"), car.getFuel());
        type(By.id("seats"), String.valueOf(car.getSeats()));
        //type(By.id("seats"), car.getSeats()+"");
        type(By.id("class"), car.getCarClass());
        type(By.id("serialNumber"), car.getCarRegNumber());
        //type(By.id("price"), String.valueOf(car.getPrice()));
        type(By.id("price"), car.getPrice()+"");
        type(By.id("about"), car.getAbout());
    }

    private void select(By locator, String option) {
        Select select = new Select(wd.findElement(locator));
        // Gas
        //select.selectByIndex(5);
        //select.selectByValue("Gas");
        //select.selectByVisibleText(" Gas ");
        select.selectByValue(option);
    }

    public void submitCarForm() {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector(\"button[type='submit']\").removeAttribute(\"disabled\")");
        click(By.xpath("//button[@type='submit']"));
    }

    public void attachPhoto(String link) {
        wd.findElement(By.cssSelector("#photos")).sendKeys(link);
    }
}
