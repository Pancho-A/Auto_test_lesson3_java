package org.max.lesson3.home.accuweather;

import io.qameta.allure.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.max.lesson3.seminar.accuweather.location.Location;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetLocationTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("GetLocation")
    @Description("GET Location")
    @Link("")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Ананьев Павел")
    void getLocation_autocomplete_returnArkhangelsk() {
        List<Location> response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/locations/v1/cities/autocomplete?q=Arkhangelsk")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .extract()
                .body().jsonPath().getList(".", Location.class);

        Assertions.assertEquals(1,response.size());
        Assertions.assertEquals("Arkhangelsk", response.get(0).getLocalizedName());
    }
}
