import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HooksForJsonPlaceHolder {

    protected RequestSpecification spec;

    @Before
    public void setUp(){
        spec = new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .setBaseUri("https://jsonplaceholder.typicode.com/").build();
    }
}
