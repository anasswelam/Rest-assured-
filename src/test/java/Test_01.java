import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import org.junit.Assert;
import org.junit.Test;


public class Test_01 {

    @Test
    public void test01(){

      Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.toString());
        System.out.println( response.getStatusCode());
        System.out.println( response.getBody());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());
        int statustCode = response.getStatusCode();
        Assert.assertEquals(statustCode,201);
    }

    @Test
    public void test02(){
        given().get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200).assertThat().
                body("data[0].'id'",equals(7));
    }

   
}
