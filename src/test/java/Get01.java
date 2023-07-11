import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {

    @Test
    public void get01(){
        // set the URL
        String url = "https://restful-booker.herokuapp.com/booking/55";

        // set expected data
        int statusCode = 200;
        String contentType = "application/json; charset=utf-8";

        // Send the request and get the response
        Response response = given().when().get(url);

        // Assert data. There is multiple ways to assert data
        // 1 then()
        response.then().statusCode(200);
            // In this case we can chain the asserts
            response.then()
                    .statusCode(200)
                            .contentType(contentType)
                                    .header("Server","Cowboy");


        // 2 assertion
        Assert.assertEquals(statusCode,response.statusCode());

    }
}
