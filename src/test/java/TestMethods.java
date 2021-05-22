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
        addBook(payload);
        Response output = getBookById();
        Assert.assertEquals(output.jsonPath().getString("book_name[0]"), "Chemistry");

    }

    @Test
    public void getBookByNameTest() {
        addBook(payload);
        Response getBook = getBookById();
        setAuthorName(getBook.jsonPath().getString("author[0]"));
        Response output = getBookByName();
        Assert.assertEquals(output.jsonPath().getString("book_name[0]"), "Chemistry");

    }

    @Test
    public void removeBookTest() {
        addBook(payload);
        Response output = deleteBook(getId());
        Assert.assertEquals(output.jsonPath().getString("msg"), "book is successfully deleted");
    }

}
