import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestsGet {

    @Test
    public void gettest01(){
        given()
                .header("Content-Type","application/json")
              .log()
                .all()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.first_name[0]",equalTo("Michael"))
                .body("data.first_name",hasItems("Lindsay","George"))
                .log().body();

    }
}
