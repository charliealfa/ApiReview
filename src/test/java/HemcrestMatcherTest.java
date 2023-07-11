import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HemcrestMatcherTest {
    @Test
    public void softAssertionTest(){
        // set the URL
        String url = "https://restful-booker.herokuapp.com/booking/56";

        // set expected data

        // Send the request and get the response
        Response response = given().when().get(url);

        // then() metodu kullanılırsa hamcrest matchers kullanılır
        // soft assertion için then metodundan sonra assertionların tümü tek body içinde yapılırsa soft assertion olur

        response.then()
                .body("firstname",equalTo("Josh"),
                        "lastname",equalTo("Doen"),
                        "totalprice",equalTo(111));

    }


    @Test
    public void hardAssertionTest(){
        // set the URL
        String url = "https://restful-booker.herokuapp.com/booking/56";

        // set expected data

        // Send the request and get the response
        Response response = given().when().get(url);

        // then() metodu kullanılırsa hamcrest matchers kullanılır
        // hard assertion için then metodundan sonra assertionlar ayrı body'ler içinde yapılırsa hard assertion olur

        response.then()
                .body("firstname",equalTo("Josh"))
                .body("depositpaid",equalTo(false))
                .body("totalprice",equalTo(111));

    }
}
