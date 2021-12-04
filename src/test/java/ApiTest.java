import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class ApiTest {
    @Test
    public void canCreateUser(){
        String user = "{ \"id\": 1, \"username\": \"ivan\", \"firstName\": \"Ivan\",  \"lastName\": \"Ivanov\",  \"email\": \"ivan@gmail.com\",  \"password\": \"bestpass\",  \"phone\": \"+380998887766\",  \"userStatus\": 0}";
        String uri = "https://petstore.swagger.io";
        String path = "/v2";
        RestAssured.given()
                .baseUri(uri)
                .basePath(path)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/user")
                .then()
                .statusCode(200)
                .and()
                .body("code", Matchers.equalTo(200));
    }
}
