import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Actions extends Setup {
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
        setAuthorName(response.jsonPath().getString("author"));
        return response;
    }

    public Response getBookById() {
        Response response = given().
                get("http://216.10.245.166/Library/GetBook.php?ID=" + getId())
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
                get("http://216.10.245.166/Library/GetBook.php?AuthorName=" + getAuthorName())
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .response();
        return response;
    }

    public Response deleteBook() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(getId())
                .post("http://216.10.245.166//Library/DeleteBook.php")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .response();
        return response;
    }
}
