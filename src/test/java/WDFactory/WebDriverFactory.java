package WDFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverFactory {
    private static WebDriver driver;

    public static WebDriver create(Browsers webDriverName ){
        if (webDriverName != null) {
        switch (webDriverName){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        } else {
            System.out.println("Incorrect browser");
        }
        return driver;

    }
}
