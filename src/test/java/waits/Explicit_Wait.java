package waits;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Explicit_Wait extends Hooks {

    @Test
    public void explicitWait() {
        driver.get("https://www.automationteststore.com/");

        // Old approach
//        WebElement element = new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.elementToBeClickable(By.id("customer_menu_top")));

        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.elementToBeClickable(By.id("customer_menu_top")));

        System.out.println(element.getText());

    }
}
