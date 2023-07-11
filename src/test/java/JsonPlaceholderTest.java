import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class JsonPlaceholderTest extends HooksForJsonPlaceHolder{

    /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
	 	    I send a GET request to the Url
	    And
	        Accept type is “application/json”
	    Then
	        HTTP Status Code should be 200
	    And
	        Response format should be "application/json"
	    And
	        There should be 200 todos
	    And
	        "quis ut nam facilis et officia qui" should be one of the todos title
	    And
	        2, 7, and 9 should be among the userIds
    */


    @Test
    public void TC_01(){
        //Set URL
        //String url = "https://jsonplaceholder.typicode.com/todos";

        spec.pathParams("endPoint","todos");//path param ile request'e parametre değişkeni atıyoruz.


        //Set the expected data

        //Send the request and get the response
        Response response = given().when().spec(spec).get("{endPoint}");

        //Do Assertion
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id",hasSize(200),
                        "title",hasItem("quis ut nam facilis et officia qui"),
                        "userId",hasItems(2,5,7));
        //hasSize() ==> eleman sayısını assert eder.
        //hasItem() ==> contains() methodu gibi objenin içerilip içerilmediğini assert eder.
        //hasItems() ==> containsAll() methodu gibi birden fazla objenin içerilip içerilmediğini assert eder.
    }
}
