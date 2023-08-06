package chromeDevTools;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class Emulate_Geo_Locations extends Hooks {

    @Test
    public void emulateGeoLocations() throws InterruptedException {
        Map<String, Object> coordinates = new HashMap<>();
        coordinates.put("latitude", 35.33426699942268);
        coordinates.put("longitude", -97.49761410867413);
        coordinates.put("accuracy", 100);
//35.33426699942268, -97.49761410867413 - would need to enable in chrome location (privacy) settings
        ((ChromeDriver) driver).executeCdpCommand("Emulation.setGeolocationOverride", coordinates);

        driver.get("https://locations.kfc.com/search");
        Thread.sleep(5000);

        WebElement locationIcon = driver.findElement(By.cssSelector("button[data-ya-track=\"geolocate\"]"));
        locationIcon.click();
        Thread.sleep(5000);

    }
}
