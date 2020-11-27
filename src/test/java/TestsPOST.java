import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestsPOST {
@Test
    public void postTest1(){
   // Map<String,Object> map = new HashMap<String, Object>();
//map.put("name","Nosa");
//map.put("job","Engineer");
//    System.out.println(map);
   // JSONObject request = new JSONObject(map);
    JSONObject request = new JSONObject();
    request.put("name","Nosa");
request.put("job","Engineer");
    System.out.println(request);
    System.out.println(request.toJSONString());
    given().header("Content-Type","application/json")
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(request.toJSONString())
            .when()
            .post("https://reqres.in/api/users")
            .then()
            .statusCode(201);

    }
}
