import com.github.javafaker.Faker;

public class Setup {
    public String id;
    public String authorName;
    public String addURL = "http://216.10.245.166/Library/Addbook.php";
    public String getURL = "http://216.10.245.166/Library/GetBook.php?ID=";
    public String getUrl1 = "http://216.10.245.166/Library/GetBook.php?AuthorName=";
    public String deleteURL = "http://216.10.245.166/Library/DeleteBook.php";
    Faker faker = new Faker();
    String aisle = faker.number().digits(6);

    public String payload = "{\n" +
            "\"name\":\"Chemistry\",\n" +
            "\"isbn\":\"physics\",\n" +
            "\"aisle\":" + aisle + ",\n" +
            "\"author\":\"Sonu\"\n" +
            "}";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String setAuthorName(String authorName) {
        this.authorName = authorName;
        return authorName;
    }
}
