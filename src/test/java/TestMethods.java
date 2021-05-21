import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMethods extends Actions{

    @Test
    public void addBookTest(){
        Actions action = new Actions();
        Response output = action.addBook(payload);
        Assert.assertEquals("successfully added", output.jsonPath().getString("Msg"));
    }

//    @Test
//    public void getBookByIdTest(){
//        Actions action = new Actions();
//        Response output = action.getBookById();
//        Assert.assertEquals("physics",output.jsonPath().getString("isbn[0]"));
//
//    }
    @Test
    public void getBookByIdTest(){
        Actions action = new Actions();
        Response output = action.addBook(payload);
        Assert.assertEquals("physics",output.jsonPath().getString("isbn[0]"));

    }

}
