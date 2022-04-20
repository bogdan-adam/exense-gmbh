package test_cases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public static void checkAdminCanLoginTest() {
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
        loginButton.click();
        WebElement newPlanButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(By.xpath("//button[text()='New plan']")));
        assertEquals(newPlanButton.getText(), "New plan");
    }

}
