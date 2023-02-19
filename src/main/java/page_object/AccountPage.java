package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {

    private final WebDriver driver;

    private static final String profilePageUrl = "https://stellarburgers.nomoreparties.site/account/profile";

    private final By logOutPersonalAccountButton =  By.xpath(".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']");

    private final By designerButton = By.xpath(".//a[(@class='AppHeader_header__link__3D_hX') and (@href='/')]");

    private final By stellarBurgersLogo = By.cssSelector(".AppHeader_header__logo__2D0X2 svg");

    private final By userNameField = By.xpath(".//input[(@name='Name') and (@type='text')]");

    private final By userEmailField = By.xpath(".//input[(@name='name') and (@type='text')]");

    private final By personalAccountNotification =  By.xpath(".//p[text()='В этом разделе вы можете изменить свои персональные данные']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void wait(By element) {
        new WebDriverWait(driver,  Duration.ofSeconds(10))
                .until(driver1 -> driver.findElement(element).isDisplayed());
    }

    @Step("Получаем текущее значение поля name")
    public String getActualValueNameField() {
        return driver.findElement(userNameField).getAttribute("value");
    }

    @Step("Получаем текущее значение поля email")
    public String getActualValueEmailField() {
        return driver.findElement(userEmailField).getAttribute("value");
    }

    @Step("Получаем уведдомления аккаунта")
    public boolean getPersonalAccountNotification() {
        wait(personalAccountNotification);
        String text = driver.findElement(personalAccountNotification).getText();
        return (text.equals("В этом разделе вы можете изменить свои персональные данные"));
    }

    @Step("Выход из аккаунта")
    public void logOutPersonalAccountButtonClick(){
        wait(logOutPersonalAccountButton);
        driver.findElement(logOutPersonalAccountButton).click();
    }

    @Step("Нажатие на конструктор")
    public void clickDesignerButton(){
        wait(designerButton);
        driver.findElement(designerButton).click();
    }

    @Step("Нажатие на ссылку регистрации")
    public void clickRegistrationLink(){
        wait(stellarBurgersLogo);
        driver.findElement(stellarBurgersLogo).click();
    }

    @Step("Ссылка на ссылку профиля")
    public String getProfilePageUrl() {
        return profilePageUrl;
    }
}