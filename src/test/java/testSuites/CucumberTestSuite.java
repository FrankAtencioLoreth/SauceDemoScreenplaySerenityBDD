package testSuites;
// Import necessary annotations and classes from JUnit Platform Suite API
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

// Define the class as a JUnit test suite
@Suite
// Specify that the Cucumber engine should be used to run this test suite
@IncludeEngines("cucumber")
// Define the path to the folder containing the Cucumber feature files
@SelectClasspathResource("/features")
// Set a configuration parameter for the Cucumber plugin
@ConfigurationParameter(
        key = PLUGIN_PROPERTY_NAME,
        value = "io.cucumber.core.plugin.SerenityReporterParallel,pretty,timeline:build/test-results/timeline"
)
public class CucumberTestSuite {
    // This class is intended to serve as a test suite for running Cucumber tests with specific configuration settings.
    // The selected plugins enable generating test reports in different formats, including Serenity reports and a timeline view.
}
