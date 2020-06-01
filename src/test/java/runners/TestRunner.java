package runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = {"@TopUpPFA"},
        plugin = {"pretty"},
        features = "classpath:features",
        glue = {"dvsa.cvs.StepDefinition"}
)

public class TestRunner {
}
