package tests;

import models.Car;
import models.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCarTests extends TestBase {

    @BeforeClass
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("iv@iv.com").setPassword("Ii123#@&"));
            logger.info("Before method finished login");
        }
        app.getHelperCar().pause(4000);
    }

    @Test
    public void addNewCarSuccess() {
        int i = new Random().nextInt(1000) + 1000;
        logger.info("Test data ---> location: 'Tel Aviv, Israel', manufacture: 'Opel', " +
                "model: 'Astra', year: '2025', fuel: 'Petrol', seats: '4', car class: 'C'," +
                " carRegNumber: '678-900-" + i + "', price: '50', about: 'Nice car'");
        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Opel")
                .model("Astra")
                .year("2025")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .carRegNumber("678-900-" + i)
                .price(50)
                .about("Nice car")
                .build();

        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("D:\\QA_33_51\\QA33_51_IlCarro\\Bugatti_Veyron_16.4_–_Frontansicht_(1),_5._April_2012,_Düsseldorf 2.jpg");
        app.getHelperCar().getScreen("src/test/screenchots/screen.png");
        app.getHelperCar().submitCarForm();
    }
}
