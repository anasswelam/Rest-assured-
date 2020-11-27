import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Examles {

    //@Test
    public void test_Get(){
        baseURI = "http://localhost:3000/";
        given()
                .param("firstname","Anas")
                .log().all().
                get("/users")
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test
    public void test_Post(){
        JSONObject request = new JSONObject();
        request.put("firstname","hello");
        request.put("lastname","java");
        request.put("subjectId",3);
        request.put("id",3);
        baseURI = "http://localhost:3000";
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type","application/json")
                .body(request.toJSONString())
                .when()
                .post("/users")
                .then()
                .statusCode(201).log().all();
    }
}
