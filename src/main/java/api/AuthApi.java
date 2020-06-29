package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.AuthPayLoad;

import static io.restassured.RestAssured.given;

public class AuthApi extends BaseApi {

    private static final String authUrl = baseUrl + "auth/";

    public static Response postAuth(AuthPayLoad authPayLoad) {
        return given()
                .contentType(ContentType.JSON)
                .body(authPayLoad)
                .when()
                .post(authUrl);
    }
}
