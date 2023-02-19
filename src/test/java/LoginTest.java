import domain.User;
import org.junit.Before;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Before
    public void beforeUp() {
        user = User.getRandomUser();
        mainPage.openPage();
        mainPage.clickPersonalAccountButton();
        loginPage.clickRegistrationLink();
        registrationPage.userRegistration(user);
    }

    @Test
    @DisplayName("Успешный вход по кнопке «Войти в аккаунт» на главной")
    public void successfulLoginLoginSignIn() {
        mainPage.openPage();
        mainPage.clickLogInToAccountButton();
        loginPage.loginAccount(user);
        assertTrue(mainPage.waitPlaceAnOrderButton());
    }

    @Test
    @DisplayName("Успешный вход через кнопку «Личный кабинет»")
    public void successfulLoginPersonalAccount() {
        mainPage.openPage();
        mainPage.clickPersonalAccountButton();
        loginPage.loginAccount(user);
        assertTrue(mainPage.waitPlaceAnOrderButton());
    }

    @Test
    @DisplayName("Успешный вход через кнопку в форме регистрации")
    public void successfulLoginPageRegistration() {
        mainPage.openPage();
        mainPage.clickPersonalAccountButton();
        loginPage.clickRegistrationLink();
        registrationPage.clickLoginLink();
        loginPage.loginAccount(user);
        assertTrue(mainPage.waitPlaceAnOrderButton());
    }

    @Test
    @DisplayName("Успешный вход через кнопку в форме восстановления пароля")
    public void successfulLoginRecoveryPage() {
        mainPage.openPage();
        mainPage.clickLogInToAccountButton();
        loginPage.clickRecoverPasswordLink();
        restorePage.clickLoginLink();
        loginPage.loginAccount(user);
        assertTrue(mainPage.waitPlaceAnOrderButton());
    }
}