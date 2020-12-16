package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class) // to run with testng
@CucumberOptions(
features = "src/test/java/features", //location of feature files
glue="stepDefinition") //test runner and step definition should have the same parent
public class TestRunner extends AbstractTestNGCucumberTests {

}
