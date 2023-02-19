package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RestorePage {

    private final WebDriver driver;

    private final By loginLink = By.xpath(".//a[(@class='Auth_link__1fOlj') and (@href='/login')]");

    public RestorePage(WebDriver driver) {
        this.driver = driver;
    }

    public void wait(By element) {
        new WebDriverWait(driver,  Duration.ofSeconds(10))
                .until(driver1 -> driver.findElement(element).isDisplayed());
    }

    @Step("Нажатие на ссылку входа")
    public void clickLoginLink(){
        wait(loginLink);
        driver.findElement(loginLink).click();
    }
}