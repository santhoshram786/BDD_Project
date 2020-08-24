package Runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = 
"C:\\Users\\Malkari Santhosh\\Documents\\eclipse\\SDET_BDD-Assignment\\src\\test\\java\\Features", 
glue = "TestScenarios",plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},monochrome = true)
public class TestRunner {

	 @AfterClass
	    public static void writeExtentReport() {
	        Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\src\\test\\java\\Config\\report.xml"));
	    
	    }
}
