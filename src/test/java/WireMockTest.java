import org.testng.annotations.Test;
import step.WireMockSteps;

import static step.UsersServiceSteps.getUsers;

public class WireMockTest {

    @Test
    void testSuccessScenario() {
        WireMockSteps.mockSuccessResponse();

        getUsers().then().statusCode(200);
    }

    @Test
    void testErrorScenario() {
        WireMockSteps.mockErrorResponse();

        getUsers().then().statusCode(500);
    }
}
