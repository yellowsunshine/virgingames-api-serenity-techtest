package com.virgingames.cucumber.steps;

import com.virgingames.gamesinfo.GamesSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.Date;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class GamesStepDefs {

    //variable declaration to store values of response, so that we can use it for multiple steps if needed
    static List<Object> defaultGameFrequencyList;
    static long currentTimeStamp;
    static List<Long> givenStartTimes;
    static ValidatableResponse response;

    //@Steps to initialise object of GamesSteps class
    @Steps
    GamesSteps gamesSteps;

    @When("^User sends a GET request to the Get Bingo Lobby Feed end point$")
    public void userSendsAGETRequestToTheGetBingoLobbyFeedEndPoint() {
        response = gamesSteps.getAllGamesInfo();
    }

    @Then("^verifies that the non-null game frequency has been set to (\\d+)$")
    public void verifiesThatTheNonNullGameFrequencyHasBeenSetTo(int frequency) {
        defaultGameFrequencyList = response.extract()
                //path that extracts all the values from the entire record
                .path("bingoLobbyInfoResource.streams.defaultGameFrequency");
        System.out.println(defaultGameFrequencyList);
        for (Object defaultGameFrequency : defaultGameFrequencyList) {
            if (!(defaultGameFrequency == null)) {
                Assert.assertThat(defaultGameFrequency, equalTo(frequency));
            }
        }
    }

    @Then("^verifies that the start time for Streams is a future time stamp$")
    public void verifiesThatTheStartTimeForStreamsIsAFutureTimeStamp() {
        currentTimeStamp = response.extract()
                .path("timestamp");
        givenStartTimes = response.extract()
                .path("bingoLobbyInfoResource.streams.startTime");
        Date date = new Date(currentTimeStamp);
        System.out.println(currentTimeStamp);
        System.out.println(givenStartTimes);
        for (Long startTime : givenStartTimes) {
            System.out.println("The current time stamp is: " + date);
            System.out.println("The given start time is: " + new Date(startTime));
            System.out.println("***************************************************************************");
            Assert.assertThat(startTime, greaterThan(currentTimeStamp));
        }
    }
}





