import domain.User;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SwitchAccountToConstructorTest extends BaseTest {

    @Before
    public void beforeUp() {
        user = User.getRandomUser();
        mainPage.openPage();
        mainPage.clickPersonalAccountButton();
        loginPage.clickRegistrationLink();
        registrationPage.userRegistration(user);
        loginPage.loginAccount(user);
        mainPage.clickPersonalAccountButton();
    }

    @Test
    @DisplayName("Успешная проверка перехода по клику на «Конструктор»")
    public void successfulByClickButtonConstructor() {
        accountPage.clickDesignerButton();
        assertTrue(mainPage.waitCollectBurgerField());
        assertEquals(mainPage.getMainPage(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Проверь переход по клику на логотип Stellar Burgers")
    public void successfulByClickLogo() {
        accountPage.clickRegistrationLink();
        assertTrue(mainPage.waitCollectBurgerField());
        assertEquals(mainPage.getMainPage(), driver.getCurrentUrl());
    }
}