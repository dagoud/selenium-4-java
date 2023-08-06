package waits;

import base.Hooks;
import org.testng.annotations.Test;

public class Page_Load extends Hooks {

    @Test
    public void pageload(){
        // old approach
        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        // new approach - NONE, EAGER, NORMAL
        driver.get("https://www.automationteststore.com/");
    }

}
