package step;

import config.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import page.LogInPage;

import java.time.Duration;
import java.util.Map;

public class LoginStepDefinitions extends LogInPage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;
    private static final Duration TIMEOUT = Duration.ofSeconds(5);

    public LoginStepDefinitions() {
        driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, TIMEOUT);
    }

    @Given("user denies notification permission")
    public void userDeniesNotificationPermission() {
        click(denyButton);
    }

    @Given("user skips the intro")
    public void userSkipsTheIntro() {
        click(skipIntroButton);
        click(finishIntroButton);
    }

    @When("user selects {string} language")
    public void userSelectsLanguage(String language) {
        click(changeLanguageButton);
        selectLanguage(language);
        click(closeButton);
    }

    @When("user taps on login button")
    public void userTapsOnLoginButton() {
        driver.findElement(loginButton).click();
    }

    @When("user enters {string} as username")
    public void userEntersUsername(String username) {
        click(usernameInput);
        type(usernameInput, username);
    }

    @When("user enters {string} as password")
    public void userEntersPassword(String password) {
        click(passwordInput);
        type(passwordInput, password);
    }

    @Then("error message should be displayed in {string} for username {string} and password {string}")
    public void errorMessageShouldBeDisplayed(String language, String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            validateFieldErrors(language, username, password);
        } else {
            validatePopupMessage(language);
        }
    }

    private void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    private void type(By locator, String text) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(locator));
        input.clear();
        input.sendKeys(text);
    }

    private void selectLanguage(String language) {
        Map<String, By> languages = Map.of(
                "ქართული", kaLanguageButton,
                "English", enLanguageButton,
                "Русский", ruLanguageButton
        );
        if (!languages.containsKey(language)) {
            throw new IllegalArgumentException("Unsupported language: " + language);
        }
        click(languages.get(language));
    }

    private void validateFieldErrors(String language, String username, String password) {
        if (username.isEmpty()) validateErrorText(usernameErrorText, language);
        if (password.isEmpty()) validateErrorText(passwordErrorText, language);
    }

    private void validateErrorText(By locator, String language) {
        String actual = wait.until(ExpectedConditions.elementToBeClickable(locator)).getText();
        String expected = getExpectedFieldError(language);
        Assert.assertEquals(actual, expected, "Invalid field error for language: " + language);
    }

    private void validatePopupMessage(String language) {
        String actual = wait.until(ExpectedConditions.elementToBeClickable(flashMessageText)).getText();
        String expected = getExpectedPopupError(language);
        Assert.assertEquals(actual, expected, "Popup error does not match for language: " + language);
    }

    private String getExpectedFieldError(String language) {
        return switch (language.toLowerCase()) {
            case "ქართული" -> "აუცილებელი ველი არ არის შევსებული";
            case "english" -> "Mandatory field is empty";
            case "русский" -> "Необходимое поле не заполнено";
            default -> throw new IllegalArgumentException("Unsupported language: " + language);
        };
    }

    private String getExpectedPopupError(String language) {
        return switch (language.toLowerCase()) {
            case "ქართული" -> "ავტორიზაციის დროს დაფიქსირდა შეცდომა";
            case "english" -> "An error occurred while login";
            case "русский" -> "Произошла ошибка при входе в систему";
            default -> throw new IllegalArgumentException("Unsupported language: " + language);
        };
    }
}
