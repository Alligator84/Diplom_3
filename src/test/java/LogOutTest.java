import domain.User;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogOutTest extends BaseTest {

    @Before
    public void beforeUp() {
        user = User.getRandomUser();
        mainPage.openPage();
        mainPage.clickPersonalAccountButton();
        loginPage.clickRegistrationLink();
        registrationPage.userRegistration(user);
        loginPage.loginAccount(user);
    }

    @Test
    @DisplayName("Успешный выход по кнопке «Выйти» в личном кабинете.")
    public void successfulLogOut() {
        mainPage.clickPersonalAccountButton();
        accountPage.logOutPersonalAccountButtonClick();
        loginPage.waitLoginPageToLoad();
        assertEquals(loginPage.getLoginPageUrl(), driver.getCurrentUrl());
    }
}