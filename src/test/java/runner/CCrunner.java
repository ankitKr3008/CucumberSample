package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucmber.html"},
        features = "src/test/resources/Feature/login.feature",
        glue = "steps"
)

public class CCrunner {

}
