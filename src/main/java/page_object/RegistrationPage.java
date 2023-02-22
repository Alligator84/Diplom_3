package page_object;

import domain.User;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    private final WebDriver driver;
    private final String registrationPageUrl = "https://stellarburgers.nomoreparties.site/register";

    private final By userNameField = By.xpath(".//fieldset[1]/div/div/input");

    private final By userEmailField = By.xpath(".//fieldset[2]/div/div/input");

    private final By userPasswordField = By.xpath(".//fieldset[3]/div/div/input");

    private final By registerButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    private final By loginLink = By.xpath(".//a[(@class='Auth_link__1fOlj') and (@href='/login')]");

    private final By messageIncorrectPassword = By.xpath(".//p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void wait(By element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> driver.findElement(element).isDisplayed());
    }

    @Step("Ввод юзера")
    public void inputUserName(String name) {
        driver.findElement(userNameField).sendKeys(name);
    }

    @Step("Ввод email")
    public void inputUserEmail(String email) {
        driver.findElement(userEmailField).sendKeys(email);
    }

    @Step("Ввод пароля")
    public void inputUserPassword(String password) {
        driver.findElement(userPasswordField).sendKeys(password);
    }

    @Step("Нажатие кнопки регистрации")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Нажатие кнопки входа")
    public void clickLoginLink() {
        wait(loginLink);
        driver.findElement(loginLink).click();
    }

    @Step("Сообщение о некорректном пароле")
    public String getMessageIncorrectPassword() {
        return driver.findElement(messageIncorrectPassword).getText();
    }

    @Step("Пролучение ссылки страницы регистрации")
    public String getRegistrationPageUrl() {
        return registrationPageUrl;
    }

    @Step("Регистрация пользователя")
    public void userRegistration(User user) {
        wait(registerButton);
        inputUserName(user.getUserName());
        inputUserEmail(user.getUserEmail());
        inputUserPassword(user.getUserPassword());
        clickRegisterButton();
    }
}