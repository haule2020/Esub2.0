package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(snippets = SnippetType.CAMELCASE,
		strict = true,
		features = "C:\\Esubmition2021\\Data\\TestSteps.feature", glue = "stepDefinitions",tags={"@Esub"}		
		)

public class eClaim_Test  {

}