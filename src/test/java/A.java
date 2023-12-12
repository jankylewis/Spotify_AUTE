import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class A {

    public static void main (String[] args) {

        final String baseUri = "https://jsonplaceholder.typicode.com/";

//        //Request specification
//        //Given
//        RequestSpecification rs = given();
//        rs.baseUri(baseUri);
//        rs.basePath("todos");
//
//        //Response scope
//        Response res = rs.get("/1");
////        res.prettyPrint();
//        res.prettyPrint();
////        res.getBody().



//                Response response = RequestSpecification
//                .given()
//                .contentType("application/x-www-form-urlencoded; charset=utf-8")
//                .formParam("grant_type", "client_credentials")
//                .formParam("client_id", "ff4df67329594a35a57ad06dcd53605f")
//                .formParam("client_secret", "363912205fc049b3b49d6210c08182f8")
//                .when()
//                .post("https://accounts.spotify.com/api/token");




        RequestSpecification rs = given();
        rs                .formParam("grant_type", "client_credentials")
                .formParam("client_id", "ff4df67329594a35a57ad06dcd53605f")
                .formParam("client_secret", "363912205fc049b3b49d6210c08182f8");
        Response res = rs.post("https://accounts.spotify.com/api/token");

//        rs.contentType();

        res.prettyPrint();


    }

}
