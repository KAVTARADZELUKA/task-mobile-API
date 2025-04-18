package step;

import config.Constants;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UsersServiceSteps {
    public static Response getUsers() {
        return RestAssured
                .given()
                .baseUri(Constants.BASE_URI)
                .port(Constants.PORT)
                .when()
                .get(Constants.USERS_PATH);
    }
}
