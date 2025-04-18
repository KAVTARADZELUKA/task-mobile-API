package step;

import config.Constants;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class WireMockSteps {
    public static void mockSuccessResponse() {
        stubFor(get(urlEqualTo(Constants.USERS_PATH))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON)
                        .withBody(Constants.USER_JSON)));
    }

    public static void mockErrorResponse() {
        stubFor(get(urlEqualTo(Constants.USERS_PATH))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody(Constants.INTERNAL_SERVER_ERROR)));
    }
}
