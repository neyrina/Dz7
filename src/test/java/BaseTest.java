import WDFactory.Browsers;
import WDFactory.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected final Logger logger = (Logger) LogManager.getLogger(Dz7.class);

    @Before
    public void startUp() {
        String inpWord = System.getProperty("browser").trim().toLowerCase();
        Browsers word = Browsers.fetchValue(inpWord);
        driver = WebDriverFactory.create(word);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("Драйвер поднят");
    }
    @After
    public void quit() {
        driver.quit();
    }
}
