package grid4;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Grid4_2 extends Hooks {

    @Test
    public void fluentWait() throws InterruptedException {
        driver.get("https://www.automationteststore.com/");

        Thread.sleep(20000);
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("MAKEUP"))).click();
        wait.until(ExpectedConditions.urlContains("product/category&path=36"));
        System.out.println("Browser Title: " + driver.getTitle());
    }

}
