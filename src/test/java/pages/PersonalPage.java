package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalPage extends BasePage{

    public PersonalPage(WebDriver driver) {
        super(driver);
    }

    private final By saveButton = By.xpath("//*[contains(text(), 'Сохранить и продолжить')]");
    private final By fName = By.id("id_fname");
    private final By lName = By.id("id_lname");
    private final By fName_latin = By.id("id_fname_latin");
    private final By lName_latin = By.id("id_lname_latin");
    private final By date = By.name("date_of_birth");

    public void enterLk() throws RuntimeException {
        String URL = "https://otus.ru/lk/biography/personal/";
        driver.get(URL);
    }

    public void save() throws RuntimeException {
        driver.findElement(saveButton).click();
    }

    public void inputFio(String fname, String lname, String fname_latin, String lname_latin, String date_of_birth) {
        driver.findElement(fName).clear();
        driver.findElement(lName).clear();
        driver.findElement(fName_latin).clear();
        driver.findElement(lName_latin).clear();
        driver.findElement(date).clear();

        driver.findElement(fName).sendKeys(fname);
        driver.findElement(lName).sendKeys(lname);
        driver.findElement(fName_latin).sendKeys(fname_latin);
        driver.findElement(lName_latin).sendKeys(lname_latin);
        driver.findElement(date).sendKeys(date_of_birth);
    }

    public void inputCountry() throws RuntimeException {
        if (!driver.findElement(By.cssSelector(".js-lk-cv-dependent-master.js-lk-cv-custom-select")).getText().contains("Россия")) {
            driver.findElement(By.cssSelector(".js-lk-cv-dependent-master.js-lk-cv-custom-select")).click();
            driver.findElement(By.xpath("//*[contains(text(), 'Россия')]")).click();
        }
    }

    public void inputCity() throws RuntimeException {
        if (!driver.findElement(By.cssSelector(".js-lk-cv-dependent-slave-city.js-lk-cv-custom-select")).getText().contains("Москва")) {
            driver.findElement(By.cssSelector(".js-lk-cv-dependent-slave-city.js-lk-cv-custom-select")).click();
            driver.findElement(By.xpath("//*[contains(text(), 'Москва')]")).click();
        }
    }

    public void inputLanguage() throws InterruptedException {
        if (!driver.findElement(By.cssSelector("div[class='select lk-cv-block__input lk-cv-block__input_full js-lk-cv-custom-select'][data-selected-option-class='lk-cv-block__select-option_selected']")).getText().contains("\n" +
                "        Выше среднего (Upper Intermediate)\n" +
                "    ")) {
            driver.findElement(By.cssSelector("div[class='select lk-cv-block__input lk-cv-block__input_full js-lk-cv-custom-select'][data-selected-option-class='lk-cv-block__select-option_selected']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[contains(text(), '\n" +
                    "        Выше среднего (Upper Intermediate)\n" +
                    "    ')]")).click();
        }
    }

    public void chooseWorkingFormat() throws RuntimeException {
        if (!driver.findElement(By.cssSelector("input[title='Удаленно']")).isSelected()) {
            driver.findElement(By.cssSelector("input[title='Удаленно']")).click();
        }
        if (driver.findElement(By.cssSelector("input[title='Полный день']")).isSelected()) {
            driver.findElement(By.cssSelector("input[title='Полный день']")).click();
        }
        if (driver.findElement(By.cssSelector("input[title='Гибкий график']")).isSelected()) {
            driver.findElement(By.cssSelector("input[title='Гибкий график']")).click();
        }
    }

    public void chooseGender() throws RuntimeException {
        driver.findElement(By.id("id_gender")).click();
        driver.findElement(By.cssSelector("option[value='f']")).click();

    }

    public void chooseContacts() throws RuntimeException {
        if (driver.findElement(By.id("id_contact-0-value")).getAttribute("value").equals("Elena Kukunina") & driver.findElement(By.id("id_contact-1-value")).getAttribute("value").equals("Elena Kukunina")) {
            driver.findElement(By.xpath("//div[@class='container__col container__col_12 container__col_md-0']//button")).click();
            driver.findElement(By.xpath("//div[@data-num='1']//div[@class='container__col container__col_12 container__col_md-0']//button[last()]")).click();
            save();
            enterLk();
        }
        driver.findElement(By.xpath("//span[@class='placeholder']")).click();
        driver.findElement(By.cssSelector("button[title='Тelegram']")).click();
        driver.findElement(By.id("id_contact-0-value")).sendKeys("Elena Kukunina");

        driver.findElement(By.cssSelector("button[class='lk-cv-block__action lk-cv-block__action_md-no-spacing js-formset-add js-lk-cv-custom-select-add']")).click();
        driver.findElement(By.xpath("//span[@class='placeholder']")).click();
        driver.findElement(By.xpath("//div[@class='lk-cv-block__select-options lk-cv-block__select-options_left js-custom-select-options-container']//button[last()]")).click();
        driver.findElement(By.id("id_contact-1-value")).sendKeys("Elena Kukunina");
    }

    public void chooseMoveOptions() throws RuntimeException {
        driver.findElement(By.cssSelector("label[class='radio radio_light4 radio_size-sm radio_vertical-center lk-cv-block__radio']")).click();
    }


}
