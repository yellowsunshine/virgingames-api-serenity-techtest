package com.virgingames.cucumber;
import com.virgingames.testbase.TestBase;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * @RunWith annotation tells JUnit that tests should run using
 * CucumberWithSerenity class
 *
 * The @CucumberOptions can be used to provide additional
 * configuration to the runner.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/java/resources/feature/",
tags = "@SANITY")
public class SanityCucumberRunner extends TestBase {



}
