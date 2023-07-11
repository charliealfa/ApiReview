import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestResponse {
    /*
        1) Postman is used for manual API testing.
        2) Rest-Assured Library for API automation
        3) We follow these steps for the writing of automation codes:
            a) Understanding the requirements
            b) Writing the test case:
        - We use "Gherkin Language" to write the test case.
                x) Given: Prerequisites --> Endpoint, body
                y) When: Actions--> Get, Put, Delete ...
                z) Then: Dönütler--> Assert
                t) And: It is used where multiple operations will be written consecutively.
            c) We follow these steps while writing the test code:
                i) Set the URL
                ii) Set the expected data
                iii) Send a request and receive a response
                iv) Assert data
    */
    public static void main(String[] args) {
        String baseUrl = "https://petstore.swagger.io/v2/pet/99";
        //Get request nasıl yapılır:
        Response response = given().when().get(baseUrl);

        //response.prettyPrint();
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.contentType() = " + response.contentType());
        System.out.println("response.statusLine() = " + response.statusLine());

        System.out.println("response.header('Content-type') = " + response.header("Content-type"));

        System.out.println("response.getTime() = " + response.getTime());
    }
}
