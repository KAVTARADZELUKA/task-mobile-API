package config;

import io.appium.java_client.android.options.UiAutomator2Options;

public class CapabilityBuilder {
    public static UiAutomator2Options getCapabilities() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Galaxy S21 Ultra 5G");
        options.setUdid("R5CR715ZETN");
        options.setPlatformName("Android");
        options.setPlatformVersion("14");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.credobusiness");
        options.setAppActivity("com.credobusiness.MainActivity");

        return options;
    }
}
