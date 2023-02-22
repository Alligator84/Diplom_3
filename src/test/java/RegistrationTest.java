import domain.User;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegistrationTest extends BaseTest {

    @Test
    @DisplayName("Успешную регистрация")
    public void successfulUserRegistration() {
        openLoginPage(User.getRandomUser());
        loginPage.waitLoginPageToLoad();
        assertEquals(loginPage.getLoginPageUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля. Минимальный пароль — шесть символов")
    public void errorUserRegistrationWithIncorrectPassword() {
        openLoginPage(User.getRandomUserWithIncorrectPassword());
        String errorMessage = registrationPage.getMessageIncorrectPassword();
        assertEquals("Некорректный пароль", errorMessage);
        assertEquals(registrationPage.getRegistrationPageUrl(), driver.getCurrentUrl());
    }

    private void openLoginPage(User user) {
        mainPage.openPage();
        mainPage.clickPersonalAccountButton();
        loginPage.clickRegistrationLink();
        registrationPage.userRegistration(user);
    }
}