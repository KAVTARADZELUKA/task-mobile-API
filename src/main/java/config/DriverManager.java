package config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private static AndroidDriver driver;

    public static void initializeDriver() throws MalformedURLException {
        UiAutomator2Options options = CapabilityBuilder.getCapabilities();
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
