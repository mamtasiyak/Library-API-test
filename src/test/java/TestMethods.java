import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMethods extends Actions {

    @Test
    public void addBookTest() {
        Response output = addBook(payload);
        Assert.assertEquals("successfully added", output.jsonPath().getString("Msg"));
    }

    @Test
    public void getBookByIdTest() {
        Response book = addBook(payload);
        Response output = getBookById();
        Assert.assertEquals("physics", output.jsonPath().getString("isbn[0]"));

    }

    @Test
    public void getBookByNameTest() {
        Response book = addBook(payload);
        Response getBook = getBookById();
        setAuthorName(getBook.jsonPath().getString("author[0]"));
        Response output = getBookByName();
        Assert.assertEquals("physics", output.jsonPath().getString("isbn[0]"));

    }

    @Test
    public void removeBookTest() {
        Response book = addBook(payload);
        Response output = deleteBook(getId());
        Assert.assertEquals("book is successfully deleted", output.jsonPath().getString("Msg"));
    }

}
