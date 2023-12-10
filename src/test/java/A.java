import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class A {

    public static void main (String[] args) {

        final String baseUri = "https://jsonplaceholder.typicode.com/";

        //Request specification
        //Given
        RequestSpecification rs = given();
        rs.baseUri(baseUri);
        rs.basePath("todos");

        //Response scope
        Response res = rs.get("/1");
        res.prettyPrint();
//        res.getBody().
    }

}
