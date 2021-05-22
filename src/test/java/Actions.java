import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Actions extends Setup {
    public Response addBook(String payload) {
        Response response = given().
                contentType(ContentType.JSON).
                body(payload).
                post(addURL)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .response();
        setId(response.jsonPath().getString("ID"));
        return response;
    }

    public Response getBookById() {
        Response response = given().
                get(getURL + getId())
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .response();
        return response;
    }

    public Response getBookByName() {
        Response response = given().
                get(getUrl1 + getAuthorName())
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .response();
        return response;
    }

    public Response deleteBook(String id) {
        String Id = "{\n" +
                "\"ID\":" + id + "\n" +
                "}";
        Response response = given()
                .header("Content-type", "application/json")
                .body(Id)
                .and()
                .delete(deleteURL)
                .then()
                .statusCode(200)
                .extract().response();
        return response;
    }
}
