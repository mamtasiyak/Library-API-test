import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Actions extends Setup{
    public Response addBook(String payload) {
        Response response = given().
                contentType(ContentType.JSON).
                body(payload).
                post("http://216.10.245.166/Library/Addbook.php")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .response();
        setId(response.jsonPath().getString("ID"));
        return response;
    }

    public Response getBookById(){
        Response response = given().
                get("http://216.10.245.166/Library/GetBook.php?ID="+getId())
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .response();
        return response;
    }
}
