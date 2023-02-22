import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstructorGuideTest extends BaseTest {

    @Test
    @DisplayName("Успешный переход к разделу «Булки»")
    public void successfulTransitionToBuns() {
        mainPage.openPage();
        mainPage.clickSaucesSection();
        mainPage.clickBunsSection();
        assertEquals("Булки", mainPage.getBunsTitle());
    }

    @Test
    @DisplayName("Успешный переход к разделу «Соусы»")
    public void successfulTransitionToSauces() {
        mainPage.openPage();
        mainPage.clickSaucesSection();
        assertEquals("Соусы", mainPage.getSaucesTitle());
    }

    @Test
    @DisplayName("Успешный переход к разделу «Начинки»")
    public void successfulTransitionToIngredients() {
        mainPage.openPage();
        mainPage.clickIngredientsSection();
        assertEquals("Начинки", mainPage.getIngredientsTitle());
    }
}