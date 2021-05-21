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
        Response output = getBookById();
        Assert.assertEquals("physics", output.jsonPath().getString("isbn[0]"));

    }

    @Test
    public void getBookByNameTest() {
        Response output = getBookByName();
        Assert.assertEquals("physics", output.jsonPath().getString("isbn[0]"));

    }

    @Test
    public void removeBookTest() {
        Response output = deleteBook();
        Assert.assertEquals("book is successfully deleted", output.jsonPath().getString("Msg"));
    }

}
