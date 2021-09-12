package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(snippets = SnippetType.CAMELCASE,
		strict = true,
		features = "testCases/eClaim_Feature/Crm.feature", glue = "stepDefinitions"	
		)

public class CrmTest  {

}