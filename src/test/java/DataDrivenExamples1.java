import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DataDrivenExamples1 extends DataDotTests{

    @Test(dataProvider = " dataforpost")
    public void test_Post(String firstname, String lastname, int subjectId){
        JSONObject request = new JSONObject();
        request.put("firstname",firstname);
        request.put("lastname",lastname);
        request.put("subjectId",subjectId);
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


    @Test(dataProvider = "dataDelete")
    public void test_Delete(int userId ){

        baseURI = "http://localhost:3000";
        given()
                .when()
                .delete("/users/"+userId)
                .then()
                .statusCode(200);
    }
@Parameters({"userId"})
    @Test
    public void test_Delete2(int userId ){
    System.out.println("value of userId is "+ userId);
        baseURI = "http://localhost:3000";
        given()
                .when()
                .delete("/users/"+userId)
                .then()
                .statusCode(200);
    }
}
