package page_object;

import domain.User;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;

    private final String loginPageUrl = "https://stellarburgers.nomoreparties.site/login";

    private final By registrationLink =  By.xpath(".//a[(@class='Auth_link__1fOlj') and (@href='/register')]");

    private final By recoverPasswordLink =  By.xpath(".//a[(@class='Auth_link__1fOlj') and (@href='/forgot-password')]");

    private final By loginButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    private final By userEmailField = By.xpath(".//input[(@name='name')]");

    private final By userPasswordField = By.xpath(".//input[(@name='Пароль')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void wait(By element) {
        new WebDriverWait(driver,  Duration.ofSeconds(10))
                .until(driver1 -> driver.findElement(element).isDisplayed());
    }

    @Step("Получение ссылки на страницу регистрации")
    public void clickRegistrationLink(){
        wait(registrationLink);
        driver.findElement(registrationLink).click();
    }

    @Step("Получение ссылки на страницу восстановления пароля")
    public void clickRecoverPasswordLink(){
        wait(recoverPasswordLink);
        driver.findElement(recoverPasswordLink).click();
    }

    @Step("Получение ссылки на страницу авторизации")
    public String getLoginPageUrl() {
        return loginPageUrl;
    }

    @Step("Нажатие кнопки логин")
    public void clickLoginButton(){
        wait(loginButton);
        driver.findElement(loginButton).click();
    }

    @Step("Ожидание загрузки страницы аутентификации")
    public void waitLoginPageToLoad() {
        wait(recoverPasswordLink);
    }

    @Step("Заполнение поля с email")
    public void inputUserEmail(String email) {
        driver.findElement(userEmailField).sendKeys(email);
    }

    @Step("Заполнение поля с паролем")
    public void inputUserPassword(String password) {
        driver.findElement(userPasswordField).sendKeys(password);
    }

    @Step("Логин в личном кабиинете")
    public void loginAccount(User user) {
        waitLoginPageToLoad();
        inputUserEmail(user.getUserEmail());
        inputUserPassword(user.getUserPassword());
        clickLoginButton();
    }
}