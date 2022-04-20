package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    public static Properties properties = new Properties();
    public static FileReader fileReader;

    @BeforeTest
    public void setUp() throws IOException {
        if (driver == null) {
            FileReader fileReader = new FileReader(System.getProperty("user.dir") +
                    "\\src\\test\\java\\config_files\\config.properties");
            properties.load(fileReader);
        }

        if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
            driver.get(properties.getProperty("testUrl"));
        }
    }

    @AfterTest
    public void tearDown() {
        driver.close();

    }
}
