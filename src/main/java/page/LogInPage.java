package page;

import org.openqa.selenium.By;

public class LogInPage {
    protected final By denyButton = By.id("com.android.permissioncontroller:id/permission_deny_button");
    protected final By skipIntroButton = By.xpath("//android.widget.TextView[@text='გამოტოვება']");
    protected final By finishIntroButton = By.xpath("//android.view.ViewGroup[@resource-id='finishButton']");

    // Language selection
    protected final By changeLanguageButton = By.xpath("//android.view.ViewGroup[@resource-id='changeLanguageButton']");
    protected final By kaLanguageButton = By.xpath("//android.view.ViewGroup[@resource-id='kaLanguageButton']");
    protected final By enLanguageButton = By.xpath("//android.view.ViewGroup[@resource-id='enLanguageButton']");
    protected final By ruLanguageButton = By.xpath("//android.view.ViewGroup[@resource-id='ruLanguageButton']");
    protected final By closeButton = By.xpath("//android.view.ViewGroup[@resource-id='closeButton']");

    // Login form
    protected final By usernameInput = By.xpath("//android.widget.EditText[@resource-id='usernameInput']");
    protected final By passwordInput = By.xpath("//android.widget.EditText[@resource-id='passwordInput']");
    protected final By loginButton = By.xpath("//android.view.ViewGroup[@resource-id='loginButton']");

    // Validation messages
    protected final By flashMessageText = By.xpath("//android.widget.TextView[@resource-id='flashMessageText']");
    protected final By usernameErrorText = By.xpath("//android.widget.TextView[@resource-id='usernameErrorText']");
    protected final By passwordErrorText = By.xpath("//android.widget.TextView[@resource-id='passwordErrorText']");
}
