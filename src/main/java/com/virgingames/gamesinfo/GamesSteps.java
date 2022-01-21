package com.virgingames.gamesinfo;

import com.virgingames.constants.EndPoints;
import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class GamesSteps {

    /**
     * GamesSteps class to write methods, which have been used within cucumber steps
     */

    //@Step annotation shows the step info in Serenity Report
    @Step("Getting information on ventureID 14 from Bingo Lobby Info Resource")
    public ValidatableResponse getAllGamesInfo() {
        return SerenityRest.rest()
                .given()
                .log()
                .all()
                .when()
                .get(EndPoints.GET_BINGO_LOBBY_FEED)
                .then()
                .statusCode(200)
                .log().all()
                //And parsing the text into JSON format
                .parser("text/plain;charset=UTF-8", Parser.JSON);
    }
}
