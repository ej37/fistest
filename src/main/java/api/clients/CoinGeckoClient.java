package api.clients;

import api.constants.Endpoints;
import api.dto.responses.BitCoinResponseDTO;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import utils.Log;

import static io.restassured.RestAssured.given;

public class CoinGeckoClient {

    @Step("Get request to CoinGecko API")
    public BitCoinResponseDTO getBitCoinDetails(){
        Log.info("Sending get request to fetch bitcoin details");
        Response response= given()
                .header("Accept", "application/json")
                .when()
                .get(Endpoints.GET_BITCOIN_DETAILS)
                .then()
                .statusCode(200)
                .extract().response();

        Allure.addAttachment(
                "Bitcoin API Response JSON",
                "application/json",
                response.asPrettyString()
        );

        return response.as(BitCoinResponseDTO.class);

    }
}
