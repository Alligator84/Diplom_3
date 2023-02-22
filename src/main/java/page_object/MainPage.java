package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private final WebDriver driver;

    private final String mainPageUrl = "https://stellarburgers.nomoreparties.site/";

    private final By logInToAccountButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");

    private final By personalAccountButton = By.xpath(".//a[(@class='AppHeader_header__link__3D_hX') and (@href='/account')]");

    private final By collectBurgerField = By.xpath(".//h1[@class='text text_type_main-large mb-5 mt-10']");

    private final By bunsSection = By.xpath(".//div[@style='display: flex;']/div[1]/span");

    private final By bunsTitle = By.xpath(".//h2[@class='text text_type_main-medium mb-6 mt-10'][1]");

    private final By saucesSection = By.xpath(".//div[@style='display: flex;']/div[2]/span");

    private final By saucesTitle = By.xpath(".//h2[@class='text text_type_main-medium mb-6 mt-10'][2]");

    private final By ingredientsSection = By.xpath(".//div[@style='display: flex;']/div[3]/span");

    private final By placeAnOrder = By.xpath(".//div[@class='BurgerConstructor_basket__container__2fUl3 mt-10']/button");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(mainPageUrl);
    }

    public void wait(By element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> driver.findElement(element).isDisplayed());
    }

    @Step("Нажатие на кнопку входа в аккаунт")
    public void clickLogInToAccountButton() {
        wait(logInToAccountButton);
        driver.findElement(logInToAccountButton).click();
    }

    @Step("Нажатие на кнопку профиля")
    public void clickPersonalAccountButton() {
        wait(personalAccountButton);
        driver.findElement(personalAccountButton).click();
    }

    @Step("Выбор булок")
    public void clickBunsSection() {
        driver.findElement(bunsSection).click();
    }

    @Step("Выбор соусов")
    public void clickSaucesSection() {
        driver.findElement(saucesSection).click();
    }

    @Step("Выбор ингредиентов")
    public void clickIngredientsSection() {
        driver.findElement(ingredientsSection).click();
    }

    @Step("Ожидаем поля бургера")
    public boolean waitCollectBurgerField() {
        wait(collectBurgerField);
        String text = driver.findElement(collectBurgerField).getText();
        return (text.equals("Соберите бургер"));
    }

    @Step("Получаем ссылку главной страницы")
    public String getMainPage() {
        return mainPageUrl;
    }

    @Step("Ожидаем оформления заказа")
    public boolean waitPlaceAnOrderButton() {
        wait(placeAnOrder);
        String text = driver.findElement(placeAnOrder).getText();
        return (text.equals("Оформить заказ"));
    }

    @Step("Получаем описание buns")
    public String getBunsTitle() {
        return driver.findElement(bunsTitle).getText();
    }

    @Step("Получаем описание sauces")
    public String getSaucesTitle() {
        return driver.findElement(saucesTitle).getText();
    }

    @Step("Получаем описание Ingredients")
    public String getIngredientsTitle() {
        return driver.findElement(ingredientsSection).getText();
    }
}