package org.max.lesson3.home.accuweather;
import io.restassured.http.Method;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.max.lesson3.seminar.accuweather.AccuweatherAbstractTest;

import static io.restassured.RestAssured.given;
public class GetWeatherFifteenDayTest extends AccuweatherAbstractTest {
    @ParameterizedTest
    @ValueSource(ints={50, 100, 150})
    void get_ten_day_return_401(int location) {

        given()
                .queryParam("apikey", getApiKey())
                .pathParam("version", "v1")
                .pathParam("location", location)
                .when()
                .request(Method.GET,getBaseUrl()+"/forecasts/{version}/daily/10day/{location}")
                .then()
                .statusCode(401);
    }
}
