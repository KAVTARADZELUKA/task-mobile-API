import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"step", "hooks"},
        plugin = {"pretty", "summary"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
