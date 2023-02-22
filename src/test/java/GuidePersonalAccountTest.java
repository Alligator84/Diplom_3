import domain.User;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GuidePersonalAccountTest extends BaseTest {

    @Before
    public void beforeUp() {
        user = User.getRandomUser();
        mainPage.openPage();
        mainPage.clickPersonalAccountButton();
        loginPage.clickRegistrationLink();
        registrationPage.userRegistration(user);
    }

    @Test
    @DisplayName("Успешная проверка перехода по клику на «Личный кабинет» для авторизованного пользователя")
    public void successfulCheck() {
        mainPage.openPage();
        mainPage.clickLogInToAccountButton();
        loginPage.loginAccount(user);
        mainPage.clickPersonalAccountButton();
        assertTrue(accountPage.getPersonalAccountNotification());
        assertEquals(user.getUserName(), accountPage.getActualValueNameField());
        assertEquals(user.getUserEmail().toLowerCase(), accountPage.getActualValueEmailField());
    }

    @Test
    @DisplayName("Неуспешная проверка перехода по клику на «Личный кабинет» для неавторизованного пользователя")
    public void unsuccessfulCheck() {
        mainPage.openPage();
        mainPage.clickPersonalAccountButton();
        assertNotEquals(accountPage.getProfilePageUrl(), driver.getCurrentUrl());
    }
}