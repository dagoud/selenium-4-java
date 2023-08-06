package chromeDevTools;

import base.Hooks;
import com.google.common.collect.ImmutableList;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.network.Network;
import org.testng.annotations.Test;

import java.util.Optional;

public class Network_Intercept extends Hooks {

    @Test
    public void networkIntercept(){
        DevTools devtools = ((ChromeDriver) driver).getDevTools();
        devtools.createSession();

        devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devtools.send(Network.setBlockedURLs(ImmutableList.of(".png", ".jpg")));

        driver.get("https://www.automationteststore.com/");
        devtools.send(Network.disable());
    }
}
