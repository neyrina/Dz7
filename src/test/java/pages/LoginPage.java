package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private final String URL = "http://otus.ru";
    private final String LOGIN = "kukunina_ey@interrao.ru";
    private final String PASSWORD = "Aa!23456789";
    private By enterButton = By.cssSelector("button.header2__auth.js-open-modal");
    private By loginButton = By.cssSelector("div.new-input-line.new-input-line_last.new-input-line_relative");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(URL);
    }

    public void auth()throws InterruptedException{
        driver.findElement(enterButton).click();
        driver.findElement(By.cssSelector(".js-email-input")).sendKeys(LOGIN);
        driver.findElement(By.cssSelector(".js-psw-input")).sendKeys(PASSWORD);
        driver.findElement(loginButton).click();
        Thread.sleep(1000);
    }

}

