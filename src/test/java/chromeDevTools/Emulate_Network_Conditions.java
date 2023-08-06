package chromeDevTools;

import base.Hooks;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.network.model.ConnectionType;
import org.openqa.selenium.devtools.v114.network.Network;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.openqa.selenium.devtools.v114.network.Network.loadingFailed;


public class Emulate_Network_Conditions extends Hooks {

    public static void emulateNetworkOnline(DevTools devTools){
        devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));

        devTools.send(Network.emulateNetworkConditions(false, 100, 200000,100000, Optional.of(ConnectionType.CELLULAR2G)));
    }

    public static void emulateNetworkOffline(DevTools devTools){
        devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(true, 100, 200000,100000, Optional.of(ConnectionType.WIFI)));
        devTools.addListener(loadingFailed(), loadingFailed -> System.out.println("Error Text: " + loadingFailed.getErrorText()));
    }


    @Test
    public void emulateNetworkConditions(){
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        // Emulate online network conditions
//        emulateNetworkOnline(devTools);

        // Emulate Offline mode
        emulateNetworkOffline(devTools);

        long startTime = System.currentTimeMillis();
        driver.get("https://www.automationteststore.com");
        long endTime = System.currentTimeMillis();

        System.out.println("Page loaded in: " + (endTime - startTime));
        // CELLULAR2G
        // 6507 6433


    }
}
