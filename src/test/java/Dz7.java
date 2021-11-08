import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.LoginPage;
import pages.PersonalPage;

public class Dz7 extends BaseTest {

    @Test
    public void mainTest() throws RuntimeException, InterruptedException {
        //1. Открыть otus.ru
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        logger.info("Открыт сайт Отус");
        //2. Авторизоваться на сайте
        loginPage.auth();
        logger.info("Залогинились");
        //3. Войти в личный кабинет
        PersonalPage personalPage = new PersonalPage(driver);
        personalPage.enterLk();
        logger.info("Открыт ЛК");
        //4. В разделе "О себе" заполнить все поля "Личные данные" и добавить не менее двух контактов
        personalPage.inputFio("Елена", "Кукунина", "Elena", "Kukunina", "24.09.1989");//Вводим ФИО и дату рождения
        personalPage.inputCountry();//Страна
        personalPage.inputCity();//Город
        personalPage.inputLanguage();//уровень англ.
        personalPage.chooseMoveOptions();//готовность к переезду
        personalPage.chooseWorkingFormat();//Формат работы
        personalPage.chooseContacts();//Способ связи
        personalPage.chooseGender();//пол
        logger.info("Заполнены все поля Личные данные и контакты");
        //5. Нажать сохранить
        personalPage.save();
        logger.info("Изменения сохранены");
        //6. Открыть https://otus.ru в “чистом браузере”
        quit();
        startUp();
        LoginPage loginPage2 = new LoginPage(driver);
        loginPage2.open();
        logger.info("Открыт сайт Отус");
        //7. Авторизоваться на сайте
        loginPage2.auth();
        logger.info("Залогинились");
        //8. Войти в личный кабинет
        PersonalPage personalPage2 = new PersonalPage(driver);
        personalPage2.enterLk();
        logger.info("Открыт ЛК");
        //9. Проверить, что в разделе о себе отображаются указанные ранее данные
        Assert.assertEquals("Елена", driver.findElement(By.id("id_fname")).getAttribute("value"));
        Assert.assertEquals("Кукунина", driver.findElement(By.id("id_lname")).getAttribute("value"));
        Assert.assertEquals("24.09.1989", driver.findElement(By.cssSelector(".input-icon > input:nth-child(1)")).getAttribute("value"));
        Assert.assertEquals("Россия", driver.findElement(By.cssSelector(".js-lk-cv-dependent-master > label:nth-child(1) > div:nth-child(2)")).getText());
        Assert.assertEquals("Москва", driver.findElement(By.cssSelector(".js-lk-cv-dependent-slave-city > label:nth-child(1) > div:nth-child(2)")).getText());
        Assert.assertEquals("Выше среднего (Upper Intermediate)", driver.findElement(By.cssSelector("div[class='select lk-cv-block__input lk-cv-block__input_full js-lk-cv-custom-select'][data-selected-option-class='lk-cv-block__select-option_selected']")).getText());
        Assert.assertTrue("Есть готовность к переезду", driver.findElement(By.xpath("//input[@id='id_ready_to_relocate_0']")).isSelected());
        Assert.assertTrue("Не Удаленно", driver.findElement(By.cssSelector("input[title='Удаленно']")).isSelected());
        Assert.assertEquals("Elena Kukunina", driver.findElement(By.id("id_contact-0-value")).getAttribute("value"));
        Assert.assertEquals("Elena Kukunina", driver.findElement(By.id("id_contact-1-value")).getAttribute("value"));
        Assert.assertEquals("f", driver.findElement(By.id("id_gender")).getAttribute("value"));
    }
}

