package hooks;

import config.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setUp() throws Exception {
        DriverManager.initializeDriver();
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
