package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/java/LoginAppFeatures/login.feature"},
        glue= {"src/test/java/stepdefinations/LoginStepDefinations.java"},
        tags= "@login",    // based on tags scenarios will run
        monochrome=true, dryRun=false
		)
public class LoginTestRunners {

}
